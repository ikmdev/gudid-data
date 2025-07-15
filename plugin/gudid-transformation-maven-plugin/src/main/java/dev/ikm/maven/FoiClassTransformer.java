package dev.ikm.maven;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.common.util.uuid.UuidT5Generator;
import dev.ikm.tinkar.composer.Composer;
import dev.ikm.tinkar.composer.Session;
import dev.ikm.tinkar.composer.assembler.ConceptAssembler;
import dev.ikm.tinkar.composer.assembler.SemanticAssembler;
import dev.ikm.tinkar.composer.template.Identifier;
import dev.ikm.tinkar.composer.template.StatedAxiom;
import dev.ikm.tinkar.terms.EntityProxy;
import dev.ikm.tinkar.terms.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static dev.ikm.maven.GudidUtility.MEDICAL_SPECIALTY_CONCEPT_UUIDS;
import static dev.ikm.tinkar.terms.TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE;
import static dev.ikm.tinkar.terms.TinkarTerm.DESCRIPTION_PATTERN;
import static dev.ikm.tinkar.terms.TinkarTerm.DEVELOPMENT_PATH;
import static dev.ikm.tinkar.terms.TinkarTerm.ENGLISH_LANGUAGE;
import static dev.ikm.tinkar.terms.TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE;
import static dev.ikm.tinkar.terms.TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE;
import static dev.ikm.tinkar.terms.TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER;

public class FoiClassTransformer extends AbstractTransformer {
    private static final Logger LOG = LoggerFactory.getLogger(FoiClassTransformer.class.getSimpleName());

    // Column indices for foiclass.txt
    private static final int REVIEW_PANEL = 0;
    private static final int MEDICAL_SPECIALTY = 1;
    private static final int PRODUCT_CODE = 2;
    private static final int DEVICE_NAME = 3;

    public FoiClassTransformer(GudidUtility gudidUtility) {
        super(gudidUtility);
    }

    /**
     * Transforms foiclass.txt file into FDA Product Code concepts
     * @param inputFile foiclass.txt input file
     * @param composer Composer for creating concepts
     */
    @Override
    public void transform(File inputFile, Composer composer) {
        if (inputFile == null || !inputFile.exists() || !inputFile.isFile()) {
            throw new RuntimeException("FoiClass input file is either null or invalid: " +
                    (inputFile != null ? inputFile.getAbsolutePath() : "null"));
        }

        LOG.info("Starting transformation of foiclass.txt file: " + inputFile.getName());

        EntityProxy.Concept author = gudidUtility.getAuthorConcept();
        EntityProxy.Concept path = DEVELOPMENT_PATH;
        EntityProxy.Concept module = gudidUtility.getModuleConcept();

        // Create session with ACTIVE state
        Session session = composer.open(State.ACTIVE, author, module, path);

        AtomicInteger processedCount = new AtomicInteger(0);
        AtomicInteger skippedCount = new AtomicInteger(0);

        try (Stream<String> lines = Files.lines(inputFile.toPath(), Charset.forName("windows-1252"))) {
            lines.skip(1) // skip header line
                    .map(row -> row.split("\\|", -1)) // -1 to preserve empty trailing fields
                    .filter(data -> gudidUtility.isMedicalSpecialtyIncluded(data[MEDICAL_SPECIALTY], data[PRODUCT_CODE]))
                    .forEach(data -> {
                        try {
                            if (data.length < 4) {
                                LOG.warn("Insufficient columns in row, expected at least 4, got {}: {}",
                                        data.length, String.join("|", data));
                                skippedCount.incrementAndGet();
                                return;
                            }

                            String medicalSpecialty = data[MEDICAL_SPECIALTY];
                            String productCode = data[PRODUCT_CODE];
                            String deviceName = data[DEVICE_NAME];

                            // Validate required fields
                            if (gudidUtility.isEmptyOrNull(productCode)) {
                                LOG.warn("Empty or null PRODUCTCODE found in row: {}", String.join("|", data));
                                skippedCount.incrementAndGet();
                                return;
                            }

                            if (gudidUtility.isEmptyOrNull(deviceName)) {
                                LOG.warn("Empty or null DEVICENAME found for PRODUCTCODE '{}' in row: {}",
                                        productCode, String.join("|", data));
                                skippedCount.incrementAndGet();
                                return;
                            }

                            // Create the FDA Product Code concept
                            createFdaProductCodeConcept(session, medicalSpecialty, productCode, deviceName);

                            processedCount.incrementAndGet();

                        } catch (Exception e) {
                            LOG.error("Error processing row: " + String.join("|", data), e);
                            skippedCount.incrementAndGet();
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException("Error reading foiclass.txt file: " + inputFile.getAbsolutePath(), e);
        }

        LOG.info("Completed transformation of foiclass.txt. Processed: {}, Skipped: {}",
                processedCount.get(), skippedCount.get());
    }

    private void createFdaProductCodeConcept(Session session, String medicalSpecialty,
                                             String productCode, String deviceName) {

        // Generate UUID for this FDA Product Code concept
        UUID conceptUuid = UuidT5Generator.get(namespace, "FDA_PRODUCT_CODE_" + productCode);
        EntityProxy.Concept fdaProductCodeConcept = EntityProxy.Concept.make(PublicIds.of(conceptUuid));

        // Create the concept with identifiers and stated definition
        session.compose((ConceptAssembler conceptAssembler) -> conceptAssembler
                .concept(fdaProductCodeConcept)

                // Add UUID identifier
                .attach((Identifier identifier) -> identifier
                        .source(UNIVERSALLY_UNIQUE_IDENTIFIER)
                        .identifier(conceptUuid.toString())
                )
        );

        createStatedAxiom(session, fdaProductCodeConcept, medicalSpecialty);

        // Create Fully Qualified Name semantic (DEVICENAME)
        createDescriptionSemantic(session, fdaProductCodeConcept, deviceName,
                FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE);

        // Create Regular Name semantic (PRODUCTCODE)
        createDescriptionSemantic(session, fdaProductCodeConcept, productCode,
                REGULAR_NAME_DESCRIPTION_TYPE);

        LOG.debug("Created FDA Product Code concept: '{}' ({}), Parent: {}",
                deviceName, productCode, getParentConceptName(medicalSpecialty));
    }

    private void createStatedAxiom(Session session, EntityProxy.Concept concept, String medicalSpecialty) {
        EntityProxy.Semantic axiomSemantic = EntityProxy.Semantic.make(PublicIds.of(UuidT5Generator.get(namespace, concept.publicId().asUuidArray()[0] + medicalSpecialty + "AXIOM")));
        // Get parent concept based on medical specialty
        EntityProxy.Concept parentConcept = getParentConcept(medicalSpecialty);
        try {
            session.compose(new StatedAxiom()
                            .semantic(axiomSemantic)
                            .isA(parentConcept),
                    concept);
        } catch (Exception e) {
            LOG.error("Error creating state definition semantic for concept: " + concept, e);
        }
    }

    private void createDescriptionSemantic(Session session, EntityProxy.Concept concept,
                                           String description, EntityProxy.Concept descriptionType) {
        String typeStr = descriptionType.equals(FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE) ? "FQN" :
                descriptionType.equals(REGULAR_NAME_DESCRIPTION_TYPE) ? "Regular" : "Definition";

        EntityProxy.Semantic semantic = EntityProxy.Semantic.make(
                PublicIds.of(UuidT5Generator.get(namespace,
                        concept.publicId().asUuidArray()[0] + description + typeStr + "DESC")));

        try {
            session.compose((SemanticAssembler semanticAssembler) -> semanticAssembler
                    .semantic(semantic)
                    .pattern(DESCRIPTION_PATTERN)
                    .reference(concept)
                    .fieldValues(fieldValues -> fieldValues
                            .with(ENGLISH_LANGUAGE)
                            .with(description)
                            .with(DESCRIPTION_NOT_CASE_SENSITIVE)
                            .with(descriptionType)
                    ));
        } catch (Exception e) {
            LOG.error("Error creating " + typeStr + " description semantic for concept: " + concept, e);
        }
    }

    private EntityProxy.Concept getParentConcept(String medicalSpecialty) {
        // Handle empty or null medical specialty
        if (gudidUtility.isEmptyOrNull(medicalSpecialty)) {
            LOG.debug("Empty medical specialty found, using Unknown Medical Specialty");
            return EntityProxy.Concept.make(
                    PublicIds.of(MEDICAL_SPECIALTY_CONCEPT_UUIDS.get("Unknown Medical Specialty")));
        }

        String parentConceptName = gudidUtility.getMedicalSpecialtyFullName(medicalSpecialty);
        UUID parentUuid = MEDICAL_SPECIALTY_CONCEPT_UUIDS.get(parentConceptName);

        if (parentUuid == null) {
            LOG.warn("No UUID mapping found for medical specialty: '{}', using Unknown Medical Specialty",
                    parentConceptName);
            parentUuid = MEDICAL_SPECIALTY_CONCEPT_UUIDS.get("Unknown Medical Specialty");
        }

        return EntityProxy.Concept.make(PublicIds.of(parentUuid));
    }

    private String getParentConceptName(String medicalSpecialty) {
        if (gudidUtility.isEmptyOrNull(medicalSpecialty)) {
            return "Unknown Medical Specialty";
        }
        return gudidUtility.getMedicalSpecialtyFullName(medicalSpecialty);
    }


}
