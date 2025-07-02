package dev.ikm.maven;

import dev.ikm.tinkar.common.id.PublicId;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.common.util.uuid.UuidT5Generator;
import dev.ikm.tinkar.entity.EntityService;
import dev.ikm.tinkar.terms.EntityProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class GudidUtility {
    private static final Logger LOG = LoggerFactory.getLogger(GudidUtility.class);

    private static EntityProxy.Concept CONCEPT_GUDID_AUTHOR = EntityProxy.Concept.make(PublicIds.of("6ba0e420-bc2d-4461-882e-d3822ba1f768"));
    private static EntityProxy.Concept CONCEPT_GUDID_MODULE = EntityProxy.Concept.make(PublicIds.of("8449f4f5-1a96-478a-864a-232f3afa0ee6"));
    private static EntityProxy.Concept CONCEPT_PUBLIC_DEVICE_RECORD_KEY = EntityProxy.Concept.make(PublicIds.of("9af79099-e708-41d7-ac64-5b6e6addb67f"));

    private final UUID namespace;

    private final Map<String, Optional<UUID>> productCodeToConceptMapping = new ConcurrentHashMap<>();

    // Static mappings for medical specialties (abbreviation -> full name)
    private static final Map<String, String> MEDICAL_SPECIALTY_MAPPINGS = new HashMap<>();

    // Static mappings for device ID issuing agencies
    private static final Map<String, String> DEVICE_ID_ISSUING_AGENCY_MAPPINGS = new HashMap<>();

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

        DEVICE_ID_ISSUING_AGENCY_MAPPINGS.put("HIBCC", "3d9e2e17-210c-446f-9e72-cb7668e4909d");
        DEVICE_ID_ISSUING_AGENCY_MAPPINGS.put("ICCBBA", "63a52e8e-36cd-467b-bcce-a94b2e69ae67");
        DEVICE_ID_ISSUING_AGENCY_MAPPINGS.put("GS1", "9c887c19-dcdc-44ea-9851-75930669d192");
        DEVICE_ID_ISSUING_AGENCY_MAPPINGS.put("NDC/NHRIC", "b9142e18-ccbd-426f-820b-2cd33b7680ea");
    }

    public GudidUtility(UUID namespace) {
        this.namespace = namespace;
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

}
