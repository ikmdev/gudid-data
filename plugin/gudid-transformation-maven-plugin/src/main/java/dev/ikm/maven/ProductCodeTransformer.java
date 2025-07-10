package dev.ikm.maven;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.common.util.uuid.UuidT5Generator;
import dev.ikm.tinkar.composer.Composer;
import dev.ikm.tinkar.composer.Session;
import dev.ikm.tinkar.composer.template.AxiomSyntax;
import dev.ikm.tinkar.terms.EntityProxy;
import dev.ikm.tinkar.terms.State;
import dev.ikm.tinkar.terms.TinkarTerm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

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

        // Group productCodes by PrimaryDI
        Map<String, Set<String>> primaryDiToProductCodes = new HashMap<>();

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
                                .computeIfAbsent(primaryDi, _ -> new HashSet<>())
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

                // Get FDA product code concept UUIDs from mapping
                List<UUID> fdaProductCodeUuids = productCodes.stream()
                        .flatMap(productCode -> GudidUtility.getConceptByProductCode(productCode).stream())
                        .toList();

                if (fdaProductCodeUuids.isEmpty()) {
                    LOG.warn("No valid FDA product code mappings found for PrimaryDI: {}", primaryDi);
                    skippedCount.incrementAndGet();
                    return;
                }

                // Create session
                Session session = composer.open(State.ACTIVE, author, module, path);

                // Create stated definition semantic with OWL expression
                createStatedDefinitionSemantic(session, deviceConcept, fdaProductCodeUuids);

                if (processedCount.incrementAndGet() % 100000 == 0) {
                    LOG.info("processedCount: {}", processedCount.get());
                    composer.commitSession(session);
                }

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
            owlBuilder.append(":[").append(fdaProductCodeUuids.getFirst()).append("]");
        } else {
            // Multiple product codes - use ObjectIntersectionOf
            owlBuilder.append(" ObjectIntersectionOf(");
            for (UUID fdaProductCodeUuid : fdaProductCodeUuids) {
                owlBuilder.append(":[").append(fdaProductCodeUuid).append("] ");
            }
            owlBuilder.append(") ");
        }
        owlBuilder.append(")");
        return owlBuilder.toString();
    }

}
