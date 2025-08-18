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

    private static final EntityProxy.Concept CONCEPT_GUDID_AUTHOR = GudidTerm.GUDID_AUTHOR;
    private static final EntityProxy.Concept CONCEPT_GUDID_MODULE = GudidTerm.DEVELOPMENT_GUDID;

    private static final Map<String, String> MEDICAL_SPECIALTY_MAPPINGS = new LinkedHashMap<>();
    private static final Map<String, PublicId> DEVICE_ID_ISSUING_AGENCY_MAPPINGS = new LinkedHashMap<>();
    static final Map<String, PublicId> MEDICAL_SPECIALTY_CONCEPT_UUIDS = new LinkedHashMap<>();

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
        MEDICAL_SPECIALTY_MAPPINGS.put("", "Unknown Medical Specialty"); // NOTE 'Unknown' is mapped to empty string in source file

        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Anesthesiology", GudidTerm.GUDID_ANESTHESIOLOGY);
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Cardiovascular", GudidTerm.GUDID_CARDIOVASCULAR);
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Clinical Chemistry", GudidTerm.GUDID_CLINICAL_CHEMISTRY);
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Dental", GudidTerm.GUDID_DENTAL);
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Ear, Nose, & Throat", GudidTerm.GUDID_EAR_NOSE_THROAT);
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Gastroenterology & Urology", GudidTerm.GUDID_GASTROENTEROLOGY_UROLOGY);
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("General Hospital", GudidTerm.GUDID_GENERAL_HOSPITAL);
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Hematology", GudidTerm.GUDID_HEMATOLOGY);
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Immunology", GudidTerm.GUDID_IMMUNOLOGY);
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Microbiology", GudidTerm.GUDID_MICROBIOLOGY);
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Neurology", GudidTerm.GUDID_NEUROLOGY);
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Obstetrics/Gynecology", GudidTerm.GUDID_OBSTETRICS_GYNECOLOGY);
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Ophthalmic", GudidTerm.GUDID_OPHTHALMIC);
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Orthopedic", GudidTerm.GUDID_ORTHOPEDIC);
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Pathology", GudidTerm.GUDID_PATHOLOGY);
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Physical Medicine", GudidTerm.GUDID_PHYSICAL_MEDICINE);
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Radiology", GudidTerm.GUDID_RADIOLOGY);
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("General & Plastic Surgery", GudidTerm.GUDID_GENERAL_PLASTIC_SURGERY);
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Clinical Toxicology", GudidTerm.GUDID_CLINICAL_TOXICOLOGY);
        MEDICAL_SPECIALTY_CONCEPT_UUIDS.put("Unknown Medical Specialty", GudidTerm.GUDID_UNKNOWN_MEDICAL_SPECIALTY);

        DEVICE_ID_ISSUING_AGENCY_MAPPINGS.put("HIBCC", GudidTerm.GUDID_HIBCC);
        DEVICE_ID_ISSUING_AGENCY_MAPPINGS.put("ICCBBA", GudidTerm.GUDID_ICCBBA);
        DEVICE_ID_ISSUING_AGENCY_MAPPINGS.put("GS1", GudidTerm.GUDID_GS1);
        DEVICE_ID_ISSUING_AGENCY_MAPPINGS.put("NDC/NHRIC", GudidTerm.GUDID_NDC_NHRIC);
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
            this.includedMedicalSpecialties = Collections.emptySet();
            LOG.info("includedMedicalSpecialties: ALL");
        } else {
            this.includedMedicalSpecialties = Set.of(medicalSpecialtiesFilter);
            initializeDeviceProductCodeMap();
            LOG.info("includedMedicalSpecialties: {}", includedMedicalSpecialties);
        }
    }

    private void initializeDeviceProductCodeMap() {
        try (Stream<String> productCodes = Files.lines(Path.of(basePath, "gudid-origin", "target", "origin-sources", "gudid", "productCodes.txt"));
             Stream<String> foiClass = Files.lines(Path.of(basePath, "gudid-origin", "target", "origin-sources", "foi", "foiclass.txt"), Charset.forName("windows-1252"))) {

            devicesByProductCode = productCodes.map(row -> row.split("\\|"))
                    .collect(Collectors.groupingBy(row -> row[0],
                            Collectors.mapping(row -> row[1], Collectors.toSet())));

            productCodeToMedicalSpecialty = foiClass.map(row -> row.split("\\|"))
                    .filter(row -> row[1].isBlank() || includedMedicalSpecialties.contains(row[1]))
                    .collect(Collectors.toMap(row -> row[2], row -> row[1]));

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public boolean isMedicalSpecialtyIncluded(String medicalSpecialty, String productCode) {
        if (isUnfilteredMode()) {
            return true;
        }
        return medicalSpecialty.equals(productCodeToMedicalSpecialty.get(productCode));
    }

    public boolean isDeviceIncluded(String primaryDi) {
        if (isUnfilteredMode()) {
            return true;
        }
        long count = devicesByProductCode.getOrDefault(primaryDi, Collections.emptySet()).stream()
                .map(productCodeToMedicalSpecialty::get).filter(Objects::nonNull)
                .distinct().count();
        return count > 0;
    }

    public boolean isDeviceIncluded(String primaryDi, String productCode) {
        if (isUnfilteredMode()) {
            return true;
        }
        long count = devicesByProductCode.getOrDefault(primaryDi, Collections.emptySet()).stream()
                .filter(code -> code.equals(productCode))
                .map(productCodeToMedicalSpecialty::get).filter(Objects::nonNull)
                .distinct().count();
        return count > 0;
    }

    private boolean isUnfilteredMode() {
        return includedMedicalSpecialties.isEmpty();
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

    public static EntityProxy.Concept lookupDeviceIdIssuingAgencyConcept(String deviceIdIssuingAgencyCode) {
        if (!DEVICE_ID_ISSUING_AGENCY_MAPPINGS.containsKey(deviceIdIssuingAgencyCode)) {
            throw new RuntimeException("No concept mapping for issuing agency code: " + deviceIdIssuingAgencyCode);
        }
        PublicId issuingAgencyUuid = DEVICE_ID_ISSUING_AGENCY_MAPPINGS.get(deviceIdIssuingAgencyCode);
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
            return EntityProxy.Concept.make(MEDICAL_SPECIALTY_CONCEPT_UUIDS.get("Unknown Medical Specialty"));
        }

        String parentConceptName = getMedicalSpecialtyFullName(medicalSpecialty);
        PublicId parentUuid = MEDICAL_SPECIALTY_CONCEPT_UUIDS.get(parentConceptName);

        if (parentUuid == null) {
            LOG.warn("No UUID mapping found for medical specialty: '{}', using Unknown Medical Specialty",
                    parentConceptName);
            parentUuid = MEDICAL_SPECIALTY_CONCEPT_UUIDS.get("Unknown Medical Specialty");
        }

        return EntityProxy.Concept.make(parentUuid);
    }

}
