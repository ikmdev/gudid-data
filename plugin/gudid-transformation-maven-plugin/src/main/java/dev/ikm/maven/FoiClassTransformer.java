package dev.ikm.maven;

import dev.ikm.tinkar.common.id.*;
import dev.ikm.tinkar.composer.*;
import dev.ikm.tinkar.composer.assembler.*;
import dev.ikm.tinkar.composer.template.*;
import dev.ikm.tinkar.terms.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FoiClassTransformer extends AbstractTransformer {
    private static final Logger LOG = LoggerFactory.getLogger(FoiClassTransformer.class.getSimpleName());

    // Column indices for foiclass.txt
    private static final int REVIEW_PANEL = 0;
    private static final int MEDICAL_SPECIALTY = 1;
    private static final int PRODUCT_CODE = 2;
    private static final int DEVICE_NAME = 3;


    // Hard-coded UUIDs for parent medical specialty concepts (placeholders for now)
    private static final Map<String, UUID> MEDICAL_SPECIALTY_CONCEPT_UUIDS = new HashMap<>();

    static {
        // TODO: Replace these placeholder UUIDs with actual UUIDs from starter data
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Anesthesiology", UUID.fromString("00000000-0000-0000-0000-000000000001"));
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Cardiovascular", UUID.fromString("00000000-0000-0000-0000-000000000002"));
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Clinical Chemistry", UUID.fromString("00000000-0000-0000-0000-000000000003"));
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Dental", UUID.fromString("00000000-0000-0000-0000-000000000004"));
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Ear, Nose, & Throat", UUID.fromString("00000000-0000-0000-0000-000000000005"));
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Gastroenterology & Urology", UUID.fromString("00000000-0000-0000-0000-000000000006"));
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("General Hospital", UUID.fromString("00000000-0000-0000-0000-000000000007"));
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Hematology", UUID.fromString("00000000-0000-0000-0000-000000000008"));
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Immunology", UUID.fromString("00000000-0000-0000-0000-000000000009"));
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Microbiology", UUID.fromString("00000000-0000-0000-0000-000000000010"));
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Neurology", UUID.fromString("00000000-0000-0000-0000-000000000011"));
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Obstetrics/Gynecology", UUID.fromString("00000000-0000-0000-0000-000000000012"));
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Ophthalmic", UUID.fromString("00000000-0000-0000-0000-000000000013"));
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Orthopedic", UUID.fromString("00000000-0000-0000-0000-000000000014"));
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Pathology", UUID.fromString("00000000-0000-0000-0000-000000000015"));
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Physical Medicine", UUID.fromString("00000000-0000-0000-0000-000000000016"));
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Radiology", UUID.fromString("00000000-0000-0000-0000-000000000017"));
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("General & Plastic Surgery", UUID.fromString("00000000-0000-0000-0000-000000000018"));
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Clinical Toxicology", UUID.fromString("00000000-0000-0000-0000-000000000019"));
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Unknown Medical Specialty", UUID.fromString("00000000-0000-0000-0000-000000000020"));
    }
    public FoiClassTransformer(UUID namespace) {
        super(namespace);
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

        EntityProxy.Concept author = GudidUtility.getUserConcept(namespace);
        EntityProxy.Concept path = GudidUtility.getPathConcept();

        int processedCount = 0;
        int skippedCount = 0;

        try (Stream<String> lines = Files.lines(inputFile.toPath())) {
            lines.skip(1) // skip header line
                    .map(row -> row.split("\\|", -1)) // -1 to preserve empty trailing fields
                    .forEach(data -> {
                        try {
                            if (data.length < 4) {
                                LOG.warn("Insufficient columns in row, expected at least 4, got {}: {}",
                                        data.length, String.join("|", data));
                                return;
                            }

                            String medicalSpecialty = data[MEDICAL_SPECIALTY];
                            String productCode = data[PRODUCT_CODE];
                            String deviceName = data[DEVICE_NAME];

                            // Validate required fields
                            if (isEmptyOrNull(productCode)) {
                                LOG.warn("Empty or null PRODUCTCODE found in row: {}", String.join("|", data));
                                return;
                            }

                            if (isEmptyOrNull(deviceName)) {
                                LOG.warn("Empty or null DEVICENAME found for PRODUCTCODE '{}' in row: {}",
                                        productCode, String.join("|", data));
                                return;
                            }

                            // Create the FDA Product Code concept
                            createFdaProductCodeConcept(composer, author, path, medicalSpecialty, productCode, deviceName);

                        } catch (Exception e) {
                            LOG.error("Error processing row: " + String.join("|", data), e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException("Error reading foiclass.txt file: " + inputFile.getAbsolutePath(), e);
        }

        LOG.info("Completed transformation of foiclass.txt. Processed: {}, Skipped: {}", processedCount, skippedCount);
        gudidUtility.logMappingStatus();
    }

    private void createFdaProductCodeConcept(Composer composer, EntityProxy.Concept author,
                                             EntityProxy.Concept path, String medicalSpecialty,
                                             String productCode, String deviceName) {

        // Generate UUID for this FDA Product Code concept
        UUID conceptUuid = generateConceptUuid(productCode);
        EntityProxy.Concept fdaProductCodeConcept = EntityProxy.Concept.make(PublicIds.of(conceptUuid));

        // Get parent concept based on medical specialty
        EntityProxy.Concept parentConcept = getParentConcept(medicalSpecialty);

        // Create session with current timestamp
        long currentTime = System.currentTimeMillis() / 1000;
        Session session = composer.open(State.ACTIVE, currentTime, author,
                getModuleConcept(), path);

        session.compose((ConceptAssembler conceptAssembler) -> conceptAssembler
                .concept(fdaProductCodeConcept)

                // Add UUID identifier
                .attach((Identifier identifier) -> identifier
                        .source(TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER)
                        .identifier(conceptUuid.toString())
                )

                // Add Product Code identifier
                .attach((Identifier identifier) -> identifier
                        .source(getFdaProductCodeIdentifierSource())
                        .identifier(productCode)
                )

                // Add Fully Qualified Name (DEVICENAME)
                .attach((FullyQualifiedName fqn) -> fqn
                        .language(TinkarTerm.ENGLISH_LANGUAGE)
                        .text(deviceName)
                        .caseSignificance(TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE)
                )

                // Add Regular Name (PRODUCTCODE as abbreviation)
                .attach((RegularName regularName) -> regularName
                        .language(TinkarTerm.ENGLISH_LANGUAGE)
                        .text(productCode)
                        .caseSignificance(TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE)
                )

                // Add Stated Definition with parent concept
                .attach((StatedDefinition statedDefinition) -> statedDefinition
                        .parents(parentConcept)
                )
        );

        // Store mapping for use by ProductCodes.txt transformation
        gudidUtility.addProductCodeMapping(productCode, conceptUuid);

        LOG.debug("Created FDA Product Code concept: '{}' ({}), Parent: {}",
                deviceName, productCode, getParentConceptName(medicalSpecialty));
    }

    private UUID generateConceptUuid(String productCode) {
        // Generate a deterministic UUID based on namespace and product code
        return UUID.nameUUIDFromBytes((namespace.toString() + "|FDA_PRODUCT_CODE|" + productCode).getBytes());
    }

    private EntityProxy.Concept getParentConcept(String medicalSpecialty) {
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
        return gudidUtility.getMedicalSpecialtyFullName(medicalSpecialty);
    }

    private EntityProxy.Concept getModuleConcept() {
        return GudidUtility.getModuleConcept();
    }

    private EntityProxy.Concept getFdaProductCodeIdentifierSource() {
        return GudidUtility.getFdaProductCodeIdentifierSource();
    }

    private boolean isEmptyOrNull(String value) {
        return value == null || value.trim().isEmpty();
    }
}

}
