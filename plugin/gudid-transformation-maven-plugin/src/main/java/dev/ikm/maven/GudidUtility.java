package dev.ikm.maven;

import dev.ikm.tinkar.common.util.uuid.UuidT5Generator;
import dev.ikm.tinkar.terms.EntityProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class GudidUtility {
    private static final Logger LOG = LoggerFactory.getLogger(GudidUtility.class);

    private final UUID namespace;

    // Runtime mappings for cross-file references
    private final Map<String, UUID> primaryDIToPublicDeviceRecordKeyMapping = new ConcurrentHashMap<>();
    private final Map<String, UUID> productCodeToConceptMapping = new ConcurrentHashMap<>();
    private final Map<String, UUID> publicDeviceRecordKeyToConceptMapping = new ConcurrentHashMap<>();

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

        // Initialize device ID issuing agency mappings (these may need to be expanded based on actual data)
        DEVICE_ID_ISSUING_AGENCY_MAPPINGS.put("FDA", "FDA Device Identifier");
        DEVICE_ID_ISSUING_AGENCY_MAPPINGS.put("HIBCC", "HIBCC Device Identifier");
        DEVICE_ID_ISSUING_AGENCY_MAPPINGS.put("ICCBBA", "ICCBBA Device Identifier");
        DEVICE_ID_ISSUING_AGENCY_MAPPINGS.put("GS1", "GS1 Device Identifier");
    }

    public GudidUtility(UUID namespace) {
        this.namespace = namespace;
    }

    public UUID getNamespace() {
        return namespace;
    }

    // Medical Specialty Mappings
    public String getMedicalSpecialtyFullName(String abbreviation) {
        String fullName = MEDICAL_SPECIALTY_MAPPINGS.get(abbreviation == null ? "" : abbreviation.trim());
        if (fullName == null) {
            LOG.warn("Unknown medical specialty abbreviation: '{}', defaulting to Unknown Medical Specialty", abbreviation);
            return MEDICAL_SPECIALTY_MAPPINGS.get("");
        }
        return fullName;
    }

    // Device ID Issuing Agency Mappings
    public String getDeviceIdIssuingAgencyName(String agency) {
        String agencyName = DEVICE_ID_ISSUING_AGENCY_MAPPINGS.get(agency == null ? "" : agency.trim());
        if (agencyName == null) {
            LOG.warn("Unknown device ID issuing agency: '{}', using as-is", agency);
            return agency == null ? "Unknown Agency" : agency.trim();
        }
        return agencyName;
    }

    // Runtime mapping management for PrimaryDI to PublicDeviceRecordKey
    public void addPrimaryDIMapping(String primaryDI, String publicDeviceRecordKey, UUID conceptUuid) {
        if (primaryDI != null && !primaryDI.trim().isEmpty() &&
                publicDeviceRecordKey != null && !publicDeviceRecordKey.trim().isEmpty()) {
            primaryDIToPublicDeviceRecordKeyMapping.put(primaryDI.trim(), conceptUuid);
            publicDeviceRecordKeyToConceptMapping.put(publicDeviceRecordKey.trim(), conceptUuid);
            LOG.debug("Added mapping: PrimaryDI '{}' -> PublicDeviceRecordKey '{}' -> Concept '{}'",
                    primaryDI, publicDeviceRecordKey, conceptUuid);
        } else {
            LOG.warn("Attempted to add invalid PrimaryDI mapping - primaryDI: '{}', publicDeviceRecordKey: '{}'",
                    primaryDI, publicDeviceRecordKey);
        }
    }

    public UUID getConceptByPrimaryDI(String primaryDI) {
        if (primaryDI == null || primaryDI.trim().isEmpty()) {
            return null;
        }
        return primaryDIToPublicDeviceRecordKeyMapping.get(primaryDI.trim());
    }

    public UUID getConceptByPublicDeviceRecordKey(String publicDeviceRecordKey) {
        if (publicDeviceRecordKey == null || publicDeviceRecordKey.trim().isEmpty()) {
            return null;
        }
        return publicDeviceRecordKeyToConceptMapping.get(publicDeviceRecordKey.trim());
    }

    // Product Code mappings
    public void addProductCodeMapping(String productCode, UUID conceptUuid) {
        if (productCode != null && !productCode.trim().isEmpty()) {
            productCodeToConceptMapping.put(productCode.trim(), conceptUuid);
            LOG.debug("Added product code mapping: '{}' -> '{}'", productCode, conceptUuid);
        } else {
            LOG.warn("Attempted to add invalid product code mapping - productCode: '{}'", productCode);
        }
    }

    public UUID getConceptByProductCode(String productCode) {
        if (productCode == null || productCode.trim().isEmpty()) {
            return null;
        }
        return productCodeToConceptMapping.get(productCode.trim());
    }

    // OWL Syntax generation
    public String generateOwlSyntax(String primaryDI, String[] productCodes) {
        UUID deviceConcept = getConceptByPrimaryDI(primaryDI);
        if (deviceConcept == null) {
            throw new IllegalArgumentException("No device concept found for PrimaryDI: " + primaryDI);
        }

        if (productCodes == null || productCodes.length == 0) {
            throw new IllegalArgumentException("No product codes provided for PrimaryDI: " + primaryDI);
        }

        // Single product code case
        if (productCodes.length == 1) {
            UUID productCodeConcept = getConceptByProductCode(productCodes[0]);
            if (productCodeConcept == null) {
                throw new IllegalArgumentException("No concept found for product code: " + productCodes[0]);
            }
            return String.format("SubClassOf(:%s :%s)", deviceConcept, productCodeConcept);
        }

        // Multiple product codes case
        StringBuilder owlBuilder = new StringBuilder();
        owlBuilder.append("SubClassOf(:").append(deviceConcept).append(" ObjectIntersectionOf(");

        for (int i = 0; i < productCodes.length; i++) {
            UUID productCodeConcept = getConceptByProductCode(productCodes[i]);
            if (productCodeConcept == null) {
                LOG.warn("No concept found for product code: '{}', skipping", productCodes[i]);
                continue;
            }

            if (i > 0) {
                owlBuilder.append(" ");
            }
            owlBuilder.append(":").append(productCodeConcept);
        }

        owlBuilder.append("))");
        return owlBuilder.toString();
    }

    // Utility methods for data validation and cleaning
    public String cleanAndValidate(String value, String fieldName) {
        if (value == null) {
            return null;
        }

        String cleaned = value.trim();
        if (cleaned.isEmpty()) {
            LOG.debug("Empty value found for field: {}", fieldName);
            return null;
        }

        return cleaned;
    }

    public String[] splitAndClean(String value, String delimiter) {
        if (value == null || value.trim().isEmpty()) {
            return new String[0];
        }

        return java.util.Arrays.stream(value.split(delimiter))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toArray(String[]::new);
    }

    // Mapping status methods for debugging
    public int getPrimaryDIMappingCount() {
        return primaryDIToPublicDeviceRecordKeyMapping.size();
    }

    public int getProductCodeMappingCount() {
        return productCodeToConceptMapping.size();
    }

    public void logMappingStatus() {
        LOG.info("GUDID Utility Mapping Status:");
        LOG.info("  PrimaryDI mappings: {}", getPrimaryDIMappingCount());
        LOG.info("  Product Code mappings: {}", getProductCodeMappingCount());
    }

    public EntityProxy.Concept getUserConcept() {
        return EntityProxy.Concept.make("AccessGUDID Author", UuidT5Generator.get(namespace, "AccessGUDID Author"));
    }

}
