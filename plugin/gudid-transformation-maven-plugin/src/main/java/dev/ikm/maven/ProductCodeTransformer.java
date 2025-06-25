package dev.ikm.maven;

import dev.ikm.tinkar.common.id.*;
import dev.ikm.tinkar.common.util.uuid.*;
import dev.ikm.tinkar.composer.*;
import dev.ikm.tinkar.composer.assembler.*;
import dev.ikm.tinkar.composer.template.*;
import dev.ikm.tinkar.terms.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.atomic.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.stream.*;

public class ProductCodeTransformer extends AbstractTransformer {
    private static final Logger LOG = LoggerFactory.getLogger(ProductCodeTransformer.class.getSimpleName());
    // Column indices for ProductCodes.txt
    private static final int PRIMARY_DI = 0;
    private static final int PRODUCT_CODE = 1;
    private static final int PRODUCT_CODE_NAME = 2;

    public ProductCodeTransformer(UUID namespace) {
        super(namespace);
    }

    /**
     * Transforms ProductCodes.txt file into stated definition semantics
     * @param inputFile ProductCodes.txt input file
     * @param composer Composer for creating semantics
     */
    @Override
    public void transform(File inputFile, Composer composer) {
        if (inputFile == null || !inputFile.exists() || !inputFile.isFile()) {
            throw new RuntimeException("ProductCodes input file is either null or invalid: " +
                    (inputFile != null ? inputFile.getAbsolutePath() : "null"));
        }

        LOG.info("Starting transformation of ProductCodes.txt file: " + inputFile.getName());

        EntityProxy.Concept author = gudidUtility.getAuthorConcept();
        EntityProxy.Concept path = TinkarTerm.DEVELOPMENT_PATH;
        EntityProxy.Concept module = gudidUtility.getModuleConcept();

        AtomicInteger processedCount = new AtomicInteger(0);
        AtomicInteger skippedCount = new AtomicInteger(0);

        // Use current time for all semantics
        long currentTime = System.currentTimeMillis();

        // Group productCodes by PrimaryDI
        Map<String, List<String>> primaryDiToProductCodes = new HashMap<>();

        try (Stream<String> lines = Files.lines(inputFile.toPath())) {
            lines.skip(1) // skip header line
                    .map(row -> row.split("\\|", -1))
                    .forEach(data -> {
                        if (data.length < 3) {
                            LOG.warn("Insufficient columns in row, expected at least 3, got {}: {}",
                                    data.length, String.join("|", data));
                            return;
                        }

                        String primaryDi = data[PRIMARY_DI];
                        String productCode = data[PRODUCT_CODE];

                        if (gudidUtility.isEmptyOrNull(primaryDi) || gudidUtility.isEmptyOrNull(productCode)) {
                            LOG.warn("Empty PrimaryDI or productCode found in row: {}", String.join("|", data));
                            return;
                        }

                        primaryDiToProductCodes
                                .computeIfAbsent(primaryDi, k -> new ArrayList<>())
                                .add(productCode);
                    });
        } catch (IOException e) {
            throw new RuntimeException("Error reading ProductCodes.txt file: " + inputFile.getAbsolutePath(), e);
        }

        LOG.info("Grouped {} unique PrimaryDIs with product codes", primaryDiToProductCodes.size());

        // Process each PrimaryDI group
        primaryDiToProductCodes.forEach((primaryDi, productCodes) -> {
            try {
                // Get device concept UUID from mapping (created by Device.txt transformer)
                EntityProxy.Concept deviceConcept = EntityProxy.Concept.make(PublicIds.of(UuidT5Generator.get(namespace, primaryDi)));

                // Remove duplicates from product codes
                List<String> uniqueProductCodes = productCodes.stream()
                        .distinct()
                        .collect(Collectors.toList());

                // Get FDA product code concept UUIDs from mapping
                List<UUID> fdaProductCodeUuids = new ArrayList<>();
                for (String productCode : uniqueProductCodes) {
                    UUID fdaProductCodeUuid = gudidUtility.getConceptByProductCode(productCode);
                    if (fdaProductCodeUuid == null) {
                        LOG.warn("No FDA product code concept mapping found for productCode: {} in PrimaryDI: {}",
                                productCode, primaryDi);
                        continue;
                    }
                    fdaProductCodeUuids.add(fdaProductCodeUuid);
                }

                if (fdaProductCodeUuids.isEmpty()) {
                    LOG.warn("No valid FDA product code mappings found for PrimaryDI: {}", primaryDi);
                    skippedCount.incrementAndGet();
                    return;
                }

                // Create session
                Session session = composer.open(State.ACTIVE, currentTime, author, module, path);

                // Create stated definition semantic with OWL expression
                createStatedDefinitionSemantic(session, deviceConcept, fdaProductCodeUuids);

                processedCount.incrementAndGet();

            } catch (Exception e) {
                LOG.error("Error processing PrimaryDI: " + primaryDi, e);
                skippedCount.incrementAndGet();
            }
        });

        LOG.info("Completed transformation of ProductCodes.txt. Processed: {}, Skipped: {}",
                processedCount.get(), skippedCount.get());
    }

    private void createStatedDefinitionSemantic(Session session, EntityProxy.Concept deviceConcept, List<UUID> fdaProductCodeUuids) {

        // Generate OWL expression
        String owlExpression = buildOwlExpression(deviceConcept, fdaProductCodeUuids);

        // Create semantic UUID based on device concept and OWL expression
        EntityProxy.Semantic axiomSemantic = EntityProxy.Semantic.make(PublicIds.of(UuidT5Generator.get(namespace, deviceConcept.publicId().asUuidArray()[0] + "AXIOM")));

        try {
            session.compose(new AxiomSyntax()
                            .semantic(axiomSemantic)
                            .text(owlExpression),
                    deviceConcept);


            LOG.debug("Created stated definition semantic for device concept: {} with {} FDA product codes",
                    deviceConcept, fdaProductCodeUuids.size());

        } catch (Exception e) {
            LOG.error("Error creating stated definition semantic for device concept: " + deviceConcept, e);
        }
    }

    private String buildOwlExpression(EntityProxy.Concept deviceConceptUuid, List<UUID> fdaProductCodeUuids) {
        StringBuilder owlBuilder = new StringBuilder();

        owlBuilder.append("SubClassOf(:[").append(deviceConceptUuid.publicId().asUuidArray()[0]).append("]");

        if (fdaProductCodeUuids.size() == 1) {
            // Single product code
            owlBuilder.append(":[").append(fdaProductCodeUuids.get(0)).append("])");
        } else {
            // Multiple product codes - use ObjectIntersectionOf
            owlBuilder.append("ObjectIntersectionOf(");
            for (int i = 0; i < fdaProductCodeUuids.size(); i++) {
                owlBuilder.append(":[").append(fdaProductCodeUuids.get(i)).append("]");
                if (i < fdaProductCodeUuids.size() - 1) {
                    owlBuilder.append("");  // Space between concepts
                }
            }
            owlBuilder.append("))");
        }
        return owlBuilder.toString();
    }

}
