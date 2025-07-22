package dev.ikm.maven;

import dev.ikm.tinkar.common.id.PublicId;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.common.util.uuid.UuidT5Generator;
import dev.ikm.tinkar.entity.EntityService;
import dev.ikm.tinkar.terms.EntityProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GudidUtility {
    private static final Logger LOG = LoggerFactory.getLogger(GudidUtility.class);

    private static final EntityProxy.Concept CONCEPT_GUDID_AUTHOR = EntityProxy.Concept.make(PublicIds.of("abcc8d16-6c3a-4d74-a83e-e766dcd6fe3d"));
    private static final EntityProxy.Concept CONCEPT_GUDID_MODULE = EntityProxy.Concept.make(PublicIds.of("7d48d128-83bc-4831-a00a-56dbf1d2a812"));
    private static final EntityProxy.Concept CONCEPT_PUBLIC_DEVICE_RECORD_KEY = EntityProxy.Concept.make(PublicIds.of("4595a20d-22fa-45c6-9197-966ccd4b6a2b"));
    private static final EntityProxy.Concept CONCEPT_PREMARKET_SUBMISSION_NUMBER = EntityProxy.Concept.make(PublicIds.of("8c0fd617-7cd8-4498-8aca-428c5361890b"));

    private static final Map<String, String> MEDICAL_SPECIALTY_MAPPINGS = new LinkedHashMap<>();
    private static final Map<String, UUID> DEVICE_ID_ISSUING_AGENCY_MAPPINGS = new LinkedHashMap<>();
    static final Map<String, UUID> MEDICAL_SPECIALTY_CONCEPT_UUIDS = new LinkedHashMap<>();

    static {
        // Initialize medical specialty mappings
        MEDICAL_SPECIALTY_MAPPINGS.put("AN", "Anesthesiology");
        MEDICAL_SPECIALTY_MAPPINGS.put("CV", "Cardiovascular");
        MEDICAL_SPECIALTY_MAPPINGS.put("CH", "Clinical Chemistry");
        MEDICAL_SPECIALTY_MAPPINGS.put("DE", "Dental");
        MEDICAL_SPECIALTY_MAPPINGS.put("EN", "Ear, Nose, & Throat");
        MEDICAL_SPECIALTY_MAPPINGS.put("GU", "Gastroenterology & Urology");
        MEDICAL_SPECIALTY_MAPPINGS.put("HO", "General Hospital");
        MEDICAL_SPECIALTY_MAPPINGS.put("HE", "Hematology");
        MEDICAL_SPECIALTY_MAPPINGS.put("IM", "Immunology");
        MEDICAL_SPECIALTY_MAPPINGS.put("MI", "Microbiology");
        MEDICAL_SPECIALTY_MAPPINGS.put("NE", "Neurology");
        MEDICAL_SPECIALTY_MAPPINGS.put("OB", "Obstetrics/Gynecology");
        MEDICAL_SPECIALTY_MAPPINGS.put("OP", "Ophthalmic");
        MEDICAL_SPECIALTY_MAPPINGS.put("OR", "Orthopedic");
        MEDICAL_SPECIALTY_MAPPINGS.put("PA", "Pathology");
        MEDICAL_SPECIALTY_MAPPINGS.put("PM", "Physical Medicine");
        MEDICAL_SPECIALTY_MAPPINGS.put("RA", "Radiology");
        MEDICAL_SPECIALTY_MAPPINGS.put("SU", "General & Plastic Surgery");
        MEDICAL_SPECIALTY_MAPPINGS.put("TX", "Clinical Toxicology");
        MEDICAL_SPECIALTY_MAPPINGS.put("", "Unknown Medical Specialty"); // Default for blank values

        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Anesthesiology", UUID.fromString("eec10bd1-fcd8-4d8c-936c-645f920bcfba"));
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Cardiovascular", UUID.fromString("97cce489-04fb-47ae-abf4-d0cf4185ff36"));
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Clinical Chemistry", UUID.fromString("0cc27ea9-b441-4e4c-8baf-888d936f304c"));
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Dental", UUID.fromString("49509c1f-fccf-426b-bddb-302f30ff87ab"));
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Ear, Nose, & Throat", UUID.fromString("9ccd764f-d64d-408c-8000-ef2d503154bb"));
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Gastroenterology & Urology", UUID.fromString("eb743737-eb31-4d23-af77-c5fec133273d"));
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("General Hospital", UUID.fromString("822682f2-37e5-4a23-a480-490b71f38104"));
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Hematology", UUID.fromString("4f4c13df-dc61-420f-bb13-9f59ab26d6a7"));
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Immunology", UUID.fromString("86027a36-ac17-462b-b864-d0e3f5bd9a74"));
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Microbiology", UUID.fromString("04b2404e-5535-4c11-8e5a-5a7201336199"));
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Neurology", UUID.fromString("1f45fa9f-ebcd-41d0-b387-da989066cdbe"));
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Obstetrics/Gynecology", UUID.fromString("2f7f306c-0e5a-484c-8e97-59f923bc7f56"));
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Ophthalmic", UUID.fromString("4f38386d-b5d9-46a2-8e82-27f429e925e0"));
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Orthopedic", UUID.fromString("114c587a-6bda-4036-99bb-ce76a21fce85"));
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Pathology", UUID.fromString("e443fd71-842b-458b-adc4-2c9015e212d5"));
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Physical Medicine", UUID.fromString("08fec815-1598-42c2-99cf-90dd69f0dfdc"));
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Radiology", UUID.fromString("ccc82d08-561a-4e11-9084-083300760957"));
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("General & Plastic Surgery", UUID.fromString("4f79eeba-874a-4b6c-93d4-82f6f49b5815"));
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Clinical Toxicology", UUID.fromString("e6026812-6a34-4d28-abad-3db727ea9cfc"));
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Unknown Medical Specialty", UUID.fromString("a2daa52b-7f15-404e-adfe-f30959817d04"));

        DEVICE_ID_ISSUING_AGENCY_MAPPINGS.put("HIBCC", UUID.fromString("5bc619bd-1080-413c-86b7-0c696605532c"));
        DEVICE_ID_ISSUING_AGENCY_MAPPINGS.put("ICCBBA", UUID.fromString("8cf247be-cc9e-4a0e-9ab9-77330209a398"));
        DEVICE_ID_ISSUING_AGENCY_MAPPINGS.put("GS1", UUID.fromString("bd5c11e4-b0eb-4971-b5bf-7d1ccc778a73"));
        DEVICE_ID_ISSUING_AGENCY_MAPPINGS.put("NDC/NHRIC", UUID.fromString("f363ef10-4c50-410f-9aa0-95ceef14c658"));
    }

    private final UUID namespace;
    private final String basePath;
    private final Set<String> includedMedicalSpecialties;
    private final Map<String, Optional<UUID>> productCodeToConceptMapping = new ConcurrentHashMap<>();

    private Map<String, Set<String>> devicesByProductCode;
    private Map<String, String> productCodeToMedicalSpecialty;

    public GudidUtility(UUID namespace, String basePath) {
        this(namespace, basePath, null);
    }

    public GudidUtility(UUID namespace, String basePath, String[] medicalSpecialtiesFilter) {
        this.namespace = namespace;
        this.basePath = basePath;
        if (medicalSpecialtiesFilter == null || "ALL".equalsIgnoreCase(medicalSpecialtiesFilter[0])) {
            this.includedMedicalSpecialties = MEDICAL_SPECIALTY_MAPPINGS.keySet();
        } else {
            this.includedMedicalSpecialties = Set.of(medicalSpecialtiesFilter);
        }
        initializeDeviceProductCodeMap();
    }

    private void initializeDeviceProductCodeMap() {
        try (Stream<String> productCodes = Files.lines(Path.of(basePath, "gudid-origin", "target", "origin-sources", "gudid", "productCodes.txt"));
             Stream<String> foiClass = Files.lines(Path.of(basePath, "gudid-origin", "target", "origin-sources", "foi", "foiclass.txt"), Charset.forName("windows-1252"))) {

            devicesByProductCode = productCodes.map(row -> row.split("\\|"))
                    .collect(Collectors.groupingBy(row -> row[0],
                            Collectors.mapping(row -> row[1], Collectors.toSet())));

            productCodeToMedicalSpecialty = foiClass.map(row -> row.split("\\|"))
                    .filter(row -> includedMedicalSpecialties.contains(row[1]))
                    .collect(Collectors.toMap(row -> row[2], row -> row[1]));

            LOG.info("includedMedicalSpecialties: {}", includedMedicalSpecialties);

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public boolean isMedicalSpecialtyIncluded(String medicalSpecialty, String productCode) {
        return medicalSpecialty.equals(productCodeToMedicalSpecialty.get(productCode));
    }

    public boolean isDeviceIncluded(String primaryDi) {
        long count = devicesByProductCode.getOrDefault(primaryDi, Collections.emptySet()).stream()
                .map(productCodeToMedicalSpecialty::get).filter(Objects::nonNull)
                .distinct().count();
        return count > 0;
    }

    public boolean isDeviceIncluded(String primaryDi, String productCode) {
        long count = devicesByProductCode.getOrDefault(primaryDi, Collections.emptySet()).stream()
                .filter(code -> code.equals(productCode))
                .map(productCodeToMedicalSpecialty::get).filter(Objects::nonNull)
                .distinct().count();
        return count > 0;
    }

    public UUID getNamespace() {
        return namespace;
    }

    public String getMedicalSpecialtyFullName(String abbreviation) {
        String fullName = MEDICAL_SPECIALTY_MAPPINGS.get(abbreviation == null ? "" : abbreviation.trim());
        if (fullName == null) {
            LOG.warn("Unknown medical specialty abbreviation: '{}', defaulting to Unknown Medical Specialty", abbreviation);
            return MEDICAL_SPECIALTY_MAPPINGS.get("");
        }
        return fullName;
    }

    public Optional<UUID> getConceptByProductCode(String productCode) {
        return productCodeToConceptMapping.computeIfAbsent(productCode, _ -> {
            UUID conceptUuid = UuidT5Generator.get(namespace, "FDA_PRODUCT_CODE_" + productCode);
            if (EntityService.get().getEntity(PublicIds.of(conceptUuid)).isEmpty()) {
                LOG.warn("Concept does not exist for FDA product code: {}", productCode);
                return Optional.empty();
            }
            return Optional.of(conceptUuid);
        });
    }

    public boolean isEmptyOrNull(String value) {
        return value == null || value.trim().isEmpty();
    }

    public EntityProxy.Concept getAuthorConcept() {
        if (EntityService.get().getEntity(CONCEPT_GUDID_AUTHOR.publicId()).isEmpty()) {
            throw new RuntimeException("Cannot resolve CONCEPT_GUDID_AUTHOR with UUID: " + CONCEPT_GUDID_AUTHOR.publicId().idString());
        }
        return CONCEPT_GUDID_AUTHOR;
    }

    public EntityProxy.Concept getModuleConcept() {
        if (EntityService.get().getEntity(CONCEPT_GUDID_MODULE.publicId()).isEmpty()) {
            throw new RuntimeException("Cannot resolve CONCEPT_GUDID_MODULE with UUID: " + CONCEPT_GUDID_MODULE.publicId().idString());
        }
        return CONCEPT_GUDID_MODULE;
    }

    public EntityProxy.Concept getPublicDeviceRecordKeyConcept() {
        if (EntityService.get().getEntity(CONCEPT_PUBLIC_DEVICE_RECORD_KEY.publicId()).isEmpty()) {
            throw new RuntimeException("Cannot resolve CONCEPT_PUBLIC_DEVICE_RECORD_KEY with UUID: " + CONCEPT_PUBLIC_DEVICE_RECORD_KEY.publicId().idString());
        }
        return CONCEPT_PUBLIC_DEVICE_RECORD_KEY;
    }

    public EntityProxy.Concept getConceptPremarketSubmissionNumber() {
        if (EntityService.get().getEntity(CONCEPT_PREMARKET_SUBMISSION_NUMBER.publicId()).isEmpty()) {
            throw new RuntimeException("Cannot resolve CONCEPT_PREMARKET_SUBMISSION_NUMBER with UUID: " + CONCEPT_PREMARKET_SUBMISSION_NUMBER.publicId().idString());
        }
        return CONCEPT_PREMARKET_SUBMISSION_NUMBER;
    }

    public static EntityProxy.Concept lookupDeviceIdIssuingAgencyConcept(String deviceIdIssuingAgencyCode) {
        if (!DEVICE_ID_ISSUING_AGENCY_MAPPINGS.containsKey(deviceIdIssuingAgencyCode)) {
            throw new RuntimeException("No concept mapping for issuing agency code: " + deviceIdIssuingAgencyCode);
        }
        PublicId issuingAgencyUuid = PublicIds.of(DEVICE_ID_ISSUING_AGENCY_MAPPINGS.get(deviceIdIssuingAgencyCode));
        if (EntityService.get().getEntity(issuingAgencyUuid).isEmpty()) {
            throw new RuntimeException("Concept for agency code '" + deviceIdIssuingAgencyCode + "' does not exist with UUID: " + issuingAgencyUuid.idString());
        }
        return EntityProxy.Concept.make(issuingAgencyUuid);
    }

    public String buildOwlExpression(EntityProxy.Concept deviceConceptUuid, List<UUID> fdaProductCodeUuids) {
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

    public EntityProxy.Concept getMedicalSpecialtyParentConcept(String medicalSpecialty) {
        // Handle empty or null medical specialty
        if (isEmptyOrNull(medicalSpecialty)) {
            LOG.debug("Empty medical specialty found, using Unknown Medical Specialty");
            return EntityProxy.Concept.make(
                    PublicIds.of(MEDICAL_SPECIALTY_CONCEPT_UUIDS.get("Unknown Medical Specialty")));
        }

        String parentConceptName = getMedicalSpecialtyFullName(medicalSpecialty);
        UUID parentUuid = MEDICAL_SPECIALTY_CONCEPT_UUIDS.get(parentConceptName);

        if (parentUuid == null) {
            LOG.warn("No UUID mapping found for medical specialty: '{}', using Unknown Medical Specialty",
                    parentConceptName);
            parentUuid = MEDICAL_SPECIALTY_CONCEPT_UUIDS.get("Unknown Medical Specialty");
        }

        return EntityProxy.Concept.make(PublicIds.of(parentUuid));
    }

}
