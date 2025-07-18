package dev.ikm.maven;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.terms.EntityProxy.Concept;
import dev.ikm.tinkar.terms.EntityProxy.Pattern;

import java.util.UUID;

/**
 * Tinkar Term Binding class to enable programmatic access to tinkar data elements known to be stored in an Komet database.
 * @author  GUDID Author
 */
public class GudidTerm {

    /**
     * Namespace used in the UUID creation process for tinkar components (e.g., Concept, Pattern, Semantic, and STAMP)
     */
    public static final UUID NAMESPACE = UUID.fromString("3094dbd1-60cf-44a6-92e3-0bb32ca4d3de");

    /**
     * Java binding for the pattern described as Concept pattern and identified by the following as UUID(s):
     * <ul>
     * <li>8e9a8888-9d06-45c8-af47-aacc78ed66ee
     * </ul>
     * <p>
     * Pattern contains the following fields
     * <ul>
     * <li>Field 0 is a Component field that represents Public ID field.
     * <li>Field 1 is a Component Id set that represents Concept version field.
     * </ul>
     */
    public static final Pattern CONCEPT_PATTERN = Pattern.make("Concept pattern", UUID.fromString("8e9a8888-9d06-45c8-af47-aacc78ed66ee"));

    /**
     * Java binding for the pattern described as STAMP pattern and identified by the following as UUID(s):
     * <ul>
     * <li>15687f5d-6028-4491-b005-7bb6f9f6ebad
     * </ul>
     * <p>
     * Pattern contains the following fields
     * <ul>
     * <li>Field 0 is a Component field that represents Public ID field.
     * <li>Field 1 is a Component Id set that represents STAMP version field.
     * </ul>
     */
    public static final Pattern STAMP_PATTERN = Pattern.make("STAMP pattern", UUID.fromString("15687f5d-6028-4491-b005-7bb6f9f6ebad"));

    /**
     * Java binding for the pattern described as Pattern pattern and identified by the following as UUID(s):
     * <ul>
     * <li>8521a438-f84f-4f84-9f99-35aab5b10bd9
     * </ul>
     * <p>
     * Pattern contains the following fields
     * <ul>
     * <li>Field 0 is a Component field that represents Public ID field.
     * <li>Field 1 is a Component Id set that represents Pattern version field.
     * </ul>
     */
    public static final Pattern PATTERN_PATTERN = Pattern.make("Pattern pattern", UUID.fromString("8521a438-f84f-4f84-9f99-35aab5b10bd9"));

    /**
     * Java binding for the pattern described as Semantic pattern and identified by the following as UUID(s):
     * <ul>
     * <li>2e97cc13-2994-4f0e-bcb3-0739e9109bf6
     * </ul>
     * <p>
     * Pattern contains the following fields
     * <ul>
     * <li>Field 0 is a Component field that represents Public ID field.
     * <li>Field 1 is a Component field that represents Semantic pattern field.
     * <li>Field 2 is a Component field that represents Semantic referenced component field.
     * <li>Field 3 is a Component Id set that represents Semantic version field.
     * </ul>
     */
    public static final Pattern SEMANTIC_PATTERN = Pattern.make("Semantic pattern", UUID.fromString("2e97cc13-2994-4f0e-bcb3-0739e9109bf6"));

    /**
     * Java binding for the pattern described as Component Version pattern and identified by the following as UUID(s):
     * <ul>
     * <li>95ebfa49-3ca7-4a86-ab91-bcc2081ab265
     * </ul>
     * <p>
     * Pattern contains the following fields
     * <ul>
     * <li>Field 0 is a Component field that represents STAMP field.
     * </ul>
     */
    public static final Pattern COMPONENT_VERSION_PATTERN = Pattern.make("Component Version pattern", UUID.fromString("95ebfa49-3ca7-4a86-ab91-bcc2081ab265"));

    /**
     * Java binding for the pattern described as Description Pattern and identified by the following as UUID(s):
     * <ul>
     * <li>a4de0039-2625-5842-8a4c-d1ce6aebf021
     * </ul>
     * <p>
     * Pattern contains the following fields
     * <ul>
     * <li>Field 0 is a Component field that represents Language for description.
     * <li>Field 1 is a String that represents Text.
     * <li>Field 2 is a Component field that represents Description case significance.
     * <li>Field 3 is a Component field that represents Description type.
     * </ul>
     */
    public static final Pattern DESCRIPTION_PATTERN = Pattern.make("Description Pattern", UUID.fromString("a4de0039-2625-5842-8a4c-d1ce6aebf021"));

    /**
     * Java binding for the pattern described as Concept Version pattern and identified by the following as UUID(s):
     * <ul>
     * <li>c20dbe3e-3b5e-40cf-a96d-68e9b95e7a90
     * </ul>
     * <p>
     * Pattern contains the following fields
     * <ul>
     * <li>Field 0 is a Component field that represents STAMP field.
     * </ul>
     */
    public static final Pattern CONCEPT_VERSION_PATTERN = Pattern.make("Concept Version pattern", UUID.fromString("c20dbe3e-3b5e-40cf-a96d-68e9b95e7a90"));

    /**
     * Java binding for the pattern described as US Dialect Pattern and identified by the following as UUID(s):
     * <ul>
     * <li>08f9112c-c041-56d3-b89b-63258f070074
     * </ul>
     * <p>
     * Pattern contains the following fields
     * <ul>
     * <li>Field 0 is a Component field that represents US English dialect.
     * </ul>
     */
    public static final Pattern US_DIALECT_PATTERN = Pattern.make("US Dialect Pattern", UUID.fromString("08f9112c-c041-56d3-b89b-63258f070074"));

    /**
     * Java binding for the pattern described as STAMP Version pattern and identified by the following as UUID(s):
     * <ul>
     * <li>fcf637ce-63fe-4f52-a4f3-401f46f71a60
     * </ul>
     * <p>
     * Pattern contains the following fields
     * <ul>
     * <li>Field 0 is a Component field that represents Status field.
     * <li>Field 1 is a Instant literal that represents Time field.
     * <li>Field 2 is a Component field that represents Author field.
     * <li>Field 3 is a Component field that represents Module field.
     * <li>Field 4 is a Component field that represents Path field.
     * </ul>
     */
    public static final Pattern STAMP_VERSION_PATTERN = Pattern.make("STAMP Version pattern", UUID.fromString("fcf637ce-63fe-4f52-a4f3-401f46f71a60"));

    /**
     * Java binding for the pattern described as Pattern Version pattern and identified by the following as UUID(s):
     * <ul>
     * <li>fd84d158-8877-47d7-b7dc-17d97f2d8207
     * </ul>
     * <p>
     * Pattern contains the following fields
     * <ul>
     * <li>Field 0 is a Component field that represents STAMP field.
     * <li>Field 1 is a Component field that represents Pattern meaning field.
     * <li>Field 2 is a Component field that represents Pattern purpose field.
     * <li>Field 3 is a Component Id set that represents Field definition field.
     * </ul>
     */
    public static final Pattern PATTERN_VERSION_PATTERN = Pattern.make("Pattern Version pattern", UUID.fromString("fd84d158-8877-47d7-b7dc-17d97f2d8207"));

    /**
     * Java binding for the pattern described as GB Dialect Pattern and identified by the following as UUID(s):
     * <ul>
     * <li>561f817a-130e-5e56-984d-910e9991558c
     * </ul>
     * <p>
     * Pattern contains the following fields
     * <ul>
     * <li>Field 0 is a Component field that represents GB English dialect / GB English.
     * </ul>
     */
    public static final Pattern GB_DIALECT_PATTERN = Pattern.make("GB Dialect Pattern", UUID.fromString("561f817a-130e-5e56-984d-910e9991558c"));

    /**
     * Java binding for the pattern described as Pattern Field definition pattern and identified by the following as UUID(s):
     * <ul>
     * <li>c43d3fcc-85ae-45c9-96e2-46a1f7b74299
     * </ul>
     * <p>
     * Pattern contains the following fields
     * <ul>
     * <li>Field 0 is a Component field that represents Field definition meaning field.
     * <li>Field 1 is a Component field that represents Field definition purpose field.
     * <li>Field 2 is a Component field that represents Field definition data type field.
     * <li>Field 3 is a Integer field that represents Field definition index field.
     * </ul>
     */
    public static final Pattern PATTERN_FIELD_DEFINITION_PATTERN = Pattern.make("Pattern Field definition pattern", UUID.fromString("c43d3fcc-85ae-45c9-96e2-46a1f7b74299"));

    /**
     * Java binding for the pattern described as Semantic Version pattern and identified by the following as UUID(s):
     * <ul>
     * <li>368d1ff5-017e-46ca-90ba-e82f25c2c5fa
     * </ul>
     * <p>
     * Pattern contains the following fields
     * <ul>
     * <li>Field 0 is a Component field that represents STAMP field.
     * <li>Field 1 is a Component Id set that represents Semantic field field.
     * </ul>
     */
    public static final Pattern SEMANTIC_VERSION_PATTERN = Pattern.make("Semantic Version pattern", UUID.fromString("368d1ff5-017e-46ca-90ba-e82f25c2c5fa"));

    /**
     * Java binding for the pattern described as Semantic Field Value pattern and identified by the following as UUID(s):
     * <ul>
     * <li>44f84a1c-acf3-41f6-bfd8-031b42d16536
     * </ul>
     * <p>
     * Pattern contains the following fields
     * <ul>
     * <li>Field 0 is a String that represents Field value field.
     * <li>Field 1 is a Integer field that represents Field index field.
     * </ul>
     */
    public static final Pattern SEMANTIC_FIELD_VALUE_PATTERN = Pattern.make("Semantic Field Value pattern", UUID.fromString("44f84a1c-acf3-41f6-bfd8-031b42d16536"));

    /**
     * Java binding for the pattern described as OWL Axiom Syntax Pattern and identified by the following as UUID(s):
     * <ul>
     * <li>c0ca180b-aae2-5fa1-9ab7-4a24f2dfe16b
     * </ul>
     * <p>
     * Pattern contains the following fields
     * <ul>
     * <li>Field 0 is a String that represents Axiom Syntax.
     * </ul>
     */
    public static final Pattern OWL_AXIOM_SYNTAX_PATTERN = Pattern.make("OWL Axiom Syntax Pattern", UUID.fromString("c0ca180b-aae2-5fa1-9ab7-4a24f2dfe16b"));

    /**
     * Java binding for the pattern described as Identifier Pattern and identified by the following as UUID(s):
     * <ul>
     * <li>5d60e14b-c410-5172-9559-3c4253278ae2
     * </ul>
     * <p>
     * Pattern contains the following fields
     * <ul>
     * <li>Field 0 is a Component field that represents Identifier source.
     * <li>Field 1 is a String that represents Identifier Value.
     * </ul>
     */
    public static final Pattern IDENTIFIER_PATTERN = Pattern.make("Identifier Pattern", UUID.fromString("5d60e14b-c410-5172-9559-3c4253278ae2"));

    /**
     * Java binding for the pattern described as Inferred definition pattern and identified by the following as UUID(s):
     * <ul>
     * <li>9f011812-15c9-5b1b-85f8-bb262bc1b2a2
     * </ul>
     * <p>
     * Pattern contains the following fields
     * <ul>
     * <li>Field 0 is a DiTree that represents EL++ Inferred terminological axioms.
     * </ul>
     */
    public static final Pattern INFERRED_DEFINITION_PATTERN = Pattern.make("Inferred definition pattern", UUID.fromString("9f011812-15c9-5b1b-85f8-bb262bc1b2a2"));

    /**
     * Java binding for the pattern described as Stated Navigation Pattern and identified by the following as UUID(s):
     * <ul>
     * <li>d02957d6-132d-5b3c-adba-505f5778d998
     * </ul>
     * <p>
     * Pattern contains the following fields
     * <ul>
     * <li>Field 0 is a Component Id set that represents Relationship destination.
     * <li>Field 1 is a Component Id set that represents Relationship origin.
     * </ul>
     */
    public static final Pattern STATED_NAVIGATION_PATTERN = Pattern.make("Stated Navigation Pattern", UUID.fromString("d02957d6-132d-5b3c-adba-505f5778d998"));

    /**
     * Java binding for the pattern described as Version control path pattern and identified by the following as UUID(s):
     * <ul>
     * <li>add1db57-72fe-53c8-a528-1614bda20ec6
     * </ul>
     */
    public static final Pattern VERSION_CONTROL_PATH_PATTERN = Pattern.make("Version control path pattern", UUID.fromString("add1db57-72fe-53c8-a528-1614bda20ec6"));

    /**
     * Java binding for the pattern described as SOLOR concept assemblage (SOLOR) and identified by the following as UUID(s):
     * <ul>
     * <li>d39b3ecd-9a80-5009-a8ac-0b947f95ca7c
     * </ul>
     */
    public static final Pattern SOLOR_CONCEPT_ASSEMBLAGE = Pattern.make("SOLOR concept assemblage (SOLOR)", UUID.fromString("d39b3ecd-9a80-5009-a8ac-0b947f95ca7c"));

    /**
     * Java binding for the pattern described as Stated definition pattern and identified by the following as UUID(s):
     * <ul>
     * <li>e813eb92-7d07-5035-8d43-e81249f5b36e
     * </ul>
     * <p>
     * Pattern contains the following fields
     * <ul>
     * <li>Field 0 is a DiTree that represents EL++ Stated terminological axioms.
     * </ul>
     */
    public static final Pattern STATED_DEFINITION_PATTERN = Pattern.make("Stated definition pattern", UUID.fromString("e813eb92-7d07-5035-8d43-e81249f5b36e"));

    /**
     * Java binding for the pattern described as Tinkar base model component pattern and identified by the following as UUID(s):
     * <ul>
     * <li>6070f6f5-893d-5144-adce-7d305c391cf9
     * </ul>
     */
    public static final Pattern TINKAR_BASE_MODEL_COMPONENT_PATTERN = Pattern.make("Tinkar base model component pattern", UUID.fromString("6070f6f5-893d-5144-adce-7d305c391cf9"));

    /**
     * Java binding for the pattern described as STAMP pattern and identified by the following as UUID(s):
     * <ul>
     * <li>9fd67fee-abf9-551d-9d0e-76a4b1e8b4ee
     * </ul>
     * <p>
     * Pattern contains the following fields
     * <ul>
     * <li>Field 0 is a Component field that represents Status.
     * <li>Field 1 is a Long that represents Time for version.
     * <li>Field 2 is a Component field that represents Author.
     * <li>Field 3 is a Component field that represents Module.
     * <li>Field 4 is a Component field that represents Path.
     * </ul>
     */
    public static final Pattern STAMP_PATTERN = Pattern.make("STAMP pattern", UUID.fromString("9fd67fee-abf9-551d-9d0e-76a4b1e8b4ee"));

    /**
     * Java binding for the pattern described as Path origins pattern and identified by the following as UUID(s):
     * <ul>
     * <li>70f89dd5-2cdb-59bb-bbaa-98527513547c
     * </ul>
     * <p>
     * Pattern contains the following fields
     * <ul>
     * <li>Field 0 is a Component field that represents Path concept.
     * <li>Field 1 is a Instant literal that represents Path origins.
     * </ul>
     */
    public static final Pattern PATH_ORIGINS_PATTERN = Pattern.make("Path origins pattern", UUID.fromString("70f89dd5-2cdb-59bb-bbaa-98527513547c"));

    /**
     * Java binding for the pattern described as Module origins pattern and identified by the following as UUID(s):
     * <ul>
     * <li>536b0ec4-4974-47ae-93a6-ae6c4d169780
     * </ul>
     * <p>
     * Pattern contains the following fields
     * <ul>
     * <li>Field 0 is a Component Id set that represents Module origins.
     * </ul>
     */
    public static final Pattern MODULE_ORIGINS_PATTERN = Pattern.make("Module origins pattern", UUID.fromString("536b0ec4-4974-47ae-93a6-ae6c4d169780"));

    /**
     * Java binding for the pattern described as Comment Pattern and identified by the following as UUID(s):
     * <ul>
     * <li>3734fb0a-4c14-5831-9a61-4743af609e7a
     * </ul>
     * <p>
     * Pattern contains the following fields
     * <ul>
     * <li>Field 0 is a String that represents Comment.
     * </ul>
     */
    public static final Pattern COMMENT_PATTERN = Pattern.make("Comment Pattern", UUID.fromString("3734fb0a-4c14-5831-9a61-4743af609e7a"));

    /**
     * Java binding for the pattern described as Komet base model component pattern and identified by the following as UUID(s):
     * <ul>
     * <li>bbbbf1fe-00f0-55e0-a19c-6300dbaab9b2
     * </ul>
     */
    public static final Pattern KOMET_BASE_MODEL_COMPONENT_PATTERN = Pattern.make("Komet base model component pattern", UUID.fromString("bbbbf1fe-00f0-55e0-a19c-6300dbaab9b2"));

    /**
     * Java binding for the pattern described as Component field pattern and identified by the following as UUID(s):
     * <ul>
     * <li>e5d91cfb-ce2c-49e2-b522-0a3f285f1c53
     * </ul>
     * <p>
     * Pattern contains the following fields
     * <ul>
     * <li>Field 0 is a Component field that represents Public ID field.
     * <li>Field 1 is a Component Id set that represents Component version field.
     * </ul>
     */
    public static final Pattern COMPONENT_FIELD_PATTERN = Pattern.make("Component field pattern", UUID.fromString("e5d91cfb-ce2c-49e2-b522-0a3f285f1c53"));

    /**
     * Java binding for the pattern described as Value Constraint Pattern and identified by the following as UUID(s):
     * <ul>
     * <li>922697f7-36ba-4afc-9dd5-f29d54b0fdec
     * </ul>
     * <p>
     * Pattern contains the following fields
     * <ul>
     * <li>Field 0 is a Concept field that represents Value Constraint Source.
     * <li>Field 1 is a Concept field that represents Minimum Value Operator; Minimum Domain Operator.
     * <li>Field 2 is a Float field that represents Minimum Value; Min Value.
     * <li>Field 3 is a Component field that represents Maximum Value Operator; Maximum Domain Operator.
     * <li>Field 4 is a Float field that represents Maximum Value; Max Value.
     * <li>Field 5 is a String that represents Example UCUM Units.
     * </ul>
     */
    public static final Pattern VALUE_CONSTRAINT_PATTERN = Pattern.make("Value Constraint Pattern", UUID.fromString("922697f7-36ba-4afc-9dd5-f29d54b0fdec"));

    /**
     * Java binding for the pattern described as Inferred Navigation Pattern and identified by the following as UUID(s):
     * <ul>
     * <li>a53cc42d-c07e-5934-96b3-2ede3264474e
     * </ul>
     * <p>
     * Pattern contains the following fields
     * <ul>
     * <li>Field 0 is a Component Id set that represents Relationship destination.
     * <li>Field 1 is a Component Id set that represents Relationship origin.
     * </ul>
     */
    public static final Pattern INFERRED_NAVIGATION_PATTERN = Pattern.make("Inferred Navigation Pattern", UUID.fromString("a53cc42d-c07e-5934-96b3-2ede3264474e"));

    /**
     * Java binding for the concept described as Physical Medicine and identified by the following UUID(s):
     * <ul>
     * <li>08fec815-1598-42c2-99cf-90dd69f0dfdc
     * </ul>
     */
    public static final Concept PHYSICAL_MEDICINE = Concept.make("Physical Medicine", UUID.fromString("08fec815-1598-42c2-99cf-90dd69f0dfdc"));

    /**
     * Java binding for the concept described as Radiology and identified by the following UUID(s):
     * <ul>
     * <li>ccc82d08-561a-4e11-9084-083300760957
     * </ul>
     */
    public static final Concept RADIOLOGY = Concept.make("Radiology", UUID.fromString("ccc82d08-561a-4e11-9084-083300760957"));

    /**
     * Java binding for the concept described as Primordial and identified by the following UUID(s):
     * <ul>
     * <li>b17bde5d-98ed-5416-97cf-2d837d75159d
     * </ul>
     */
    public static final Concept PRIMORDIAL = Concept.make("Primordial", UUID.fromString("b17bde5d-98ed-5416-97cf-2d837d75159d"));

    /**
     * Java binding for the concept described as Author and identified by the following UUID(s):
     * <ul>
     * <li>4eb9de0d-7486-5f18-a9b4-82e3432f4103
     * </ul>
     */
    public static final Concept AUTHOR = Concept.make("Author", UUID.fromString("4eb9de0d-7486-5f18-a9b4-82e3432f4103"));

    /**
     * Java binding for the concept described as General & Plastic Surgery and identified by the following UUID(s):
     * <ul>
     * <li>4f79eeba-874a-4b6c-93d4-82f6f49b5815
     * </ul>
     */
    public static final Concept GENERAL_AMPERSAND_PLASTIC_SURGERY = Concept.make("General & Plastic Surgery", UUID.fromString("4f79eeba-874a-4b6c-93d4-82f6f49b5815"));

    /**
     * Java binding for the concept described as Uninitialized and identified by the following UUID(s):
     * <ul>
     * <li>55f74246-0a25-57ac-9473-a788d08fb656
     * </ul>
     */
    public static final Concept UNINITIALIZED = Concept.make("Uninitialized", UUID.fromString("55f74246-0a25-57ac-9473-a788d08fb656"));

    /**
     * Java binding for the concept described as Active and identified by the following UUID(s):
     * <ul>
     * <li>09f12001-0e4f-51e2-9852-44862a4a0db4
     * </ul>
     */
    public static final Concept ACTIVE = Concept.make("Active", UUID.fromString("09f12001-0e4f-51e2-9852-44862a4a0db4"));

    /**
     * Java binding for the concept described as EL++ digraph and identified by the following UUID(s):
     * <ul>
     * <li>ee04d7db-3407-568f-9b93-7b1f9f5bb0fc
     * </ul>
     */
    public static final Concept EL_PLUS_PLUS_DIGRAPH = Concept.make("EL++ digraph", UUID.fromString("ee04d7db-3407-568f-9b93-7b1f9f5bb0fc"));

    /**
     * Java binding for the concept described as Clinical Toxicology and identified by the following UUID(s):
     * <ul>
     * <li>e6026812-6a34-4d28-abad-3db727ea9cfc
     * </ul>
     */
    public static final Concept CLINICAL_TOXICOLOGY = Concept.make("Clinical Toxicology", UUID.fromString("e6026812-6a34-4d28-abad-3db727ea9cfc"));

    /**
     * Java binding for the concept described as Tinkar Starter Data Author and identified by the following UUID(s):
     * <ul>
     * <li>dd96b2ea-6d7b-3791-ad74-bbdc67c493c1
     * </ul>
     */
    public static final Concept TINKAR_STARTER_DATA_AUTHOR = Concept.make("Tinkar Starter Data Author", UUID.fromString("dd96b2ea-6d7b-3791-ad74-bbdc67c493c1"));

    /**
     * Java binding for the concept described as Primordial module and identified by the following UUID(s):
     * <ul>
     * <li>c2012321-3903-532e-8a5f-b13e4ca46e86
     * </ul>
     */
    public static final Concept PRIMORDIAL_MODULE = Concept.make("Primordial module", UUID.fromString("c2012321-3903-532e-8a5f-b13e4ca46e86"));

    /**
     * Java binding for the concept described as Unknown Medical Specialty and identified by the following UUID(s):
     * <ul>
     * <li>a2daa52b-7f15-404e-adfe-f30959817d04
     * </ul>
     */
    public static final Concept UNKNOWN_MEDICAL_SPECIALTY = Concept.make("Unknown Medical Specialty", UUID.fromString("a2daa52b-7f15-404e-adfe-f30959817d04"));

    /**
     * Java binding for the concept described as Primordial path and identified by the following UUID(s):
     * <ul>
     * <li>e95b6718-f824-5540-817b-8e79544eb97a
     * </ul>
     */
    public static final Concept PRIMORDIAL_PATH = Concept.make("Primordial path", UUID.fromString("e95b6718-f824-5540-817b-8e79544eb97a"));

    /**
     * Java binding for the concept described as Canceled and identified by the following UUID(s):
     * <ul>
     * <li>b42c1948-7645-5da8-a888-de6ec020ab98
     * </ul>
     */
    public static final Concept CANCELED = Concept.make("Canceled", UUID.fromString("b42c1948-7645-5da8-a888-de6ec020ab98"));

    /**
     * Java binding for the concept described as GUDID Module and identified by the following UUID(s):
     * <ul>
     * <li>7d48d128-83bc-4831-a00a-56dbf1d2a812
     * </ul>
     */
    public static final Concept GUDID_MODULE = Concept.make("GUDID Module", UUID.fromString("7d48d128-83bc-4831-a00a-56dbf1d2a812"));

    /**
     * Java binding for the concept described as GUDID Author and identified by the following UUID(s):
     * <ul>
     * <li>abcc8d16-6c3a-4d74-a83e-e766dcd6fe3d
     * </ul>
     */
    public static final Concept GUDID_AUTHOR = Concept.make("GUDID Author", UUID.fromString("abcc8d16-6c3a-4d74-a83e-e766dcd6fe3d"));

    /**
     * Java binding for the concept described as Dun and Bradstreet Number and identified by the following UUID(s):
     * <ul>
     * <li>2c3fb6aa-ed70-495c-8440-c06677d73629
     * </ul>
     */
    public static final Concept DUN_AND_BRADSTREET_NUMBER = Concept.make("Dun and Bradstreet Number", UUID.fromString("2c3fb6aa-ed70-495c-8440-c06677d73629"));

    /**
     * Java binding for the concept described as Preferred and identified by the following UUID(s):
     * <ul>
     * <li>266f1bc3-3361-39f3-bffe-69db9daea56e
     * </ul>
     */
    public static final Concept PREFERRED = Concept.make("Preferred", UUID.fromString("266f1bc3-3361-39f3-bffe-69db9daea56e"));

    /**
     * Java binding for the concept described as English language and identified by the following UUID(s):
     * <ul>
     * <li>02018e5a-46ba-5297-92f1-6931b9f98a12
     * <li>06d905ea-c647-3af9-bfe5-2514e135b558
     * <li>45021920-9567-11e5-8994-feff819cdc9f
     * </ul>
     */
    public static final Concept ENGLISH_LANGUAGE = Concept.make("English language", UUID.fromString("02018e5a-46ba-5297-92f1-6931b9f98a12"), UUID.fromString("06d905ea-c647-3af9-bfe5-2514e135b558"), UUID.fromString("45021920-9567-11e5-8994-feff819cdc9f"));

    /**
     * Java binding for the concept described as FDA Product Code and identified by the following UUID(s):
     * <ul>
     * <li>f9e9fadd-1870-4eaf-85f2-a694740ec47a
     * </ul>
     */
    public static final Concept FDA_PRODUCT_CODE = Concept.make("FDA Product Code", UUID.fromString("f9e9fadd-1870-4eaf-85f2-a694740ec47a"));

    /**
     * Java binding for the concept described as Case insensitive and identified by the following UUID(s):
     * <ul>
     * <li>ecea41a2-f596-3d98-99d1-771b667e55b8
     * </ul>
     */
    public static final Concept CASE_INSENSITIVE = Concept.make("Case insensitive", UUID.fromString("ecea41a2-f596-3d98-99d1-771b667e55b8"));

    /**
     * Java binding for the concept described as Fully qualified name and identified by the following UUID(s):
     * <ul>
     * <li>00791270-77c9-32b6-b34f-d932569bd2bf
     * <li>5e1fe940-8faf-11db-b606-0800200c9a66
     * </ul>
     */
    public static final Concept FULLY_QUALIFIED_NAME = Concept.make("Fully qualified name", UUID.fromString("00791270-77c9-32b6-b34f-d932569bd2bf"), UUID.fromString("5e1fe940-8faf-11db-b606-0800200c9a66"));

    /**
     * Java binding for the concept described as GS1 and identified by the following UUID(s):
     * <ul>
     * <li>bd5c11e4-b0eb-4971-b5bf-7d1ccc778a73
     * </ul>
     */
    public static final Concept GS1 = Concept.make("GS1", UUID.fromString("bd5c11e4-b0eb-4971-b5bf-7d1ccc778a73"));

    /**
     * Java binding for the concept described as HIBCC and identified by the following UUID(s):
     * <ul>
     * <li>5bc619bd-1080-413c-86b7-0c696605532c
     * </ul>
     */
    public static final Concept HIBCC = Concept.make("HIBCC", UUID.fromString("5bc619bd-1080-413c-86b7-0c696605532c"));

    /**
     * Java binding for the concept described as Regular name description type and identified by the following UUID(s):
     * <ul>
     * <li>8bfba944-3965-3946-9bcb-1e80a5da63a2
     * <li>d6fad981-7df6-3388-94d8-238cc0465a79
     * </ul>
     */
    public static final Concept REGULAR_NAME_DESCRIPTION_TYPE = Concept.make("Regular name description type", UUID.fromString("8bfba944-3965-3946-9bcb-1e80a5da63a2"), UUID.fromString("d6fad981-7df6-3388-94d8-238cc0465a79"));

    /**
     * Java binding for the concept described as ICCBBA and identified by the following UUID(s):
     * <ul>
     * <li>8cf247be-cc9e-4a0e-9ab9-77330209a398
     * </ul>
     */
    public static final Concept ICCBBA = Concept.make("ICCBBA", UUID.fromString("8cf247be-cc9e-4a0e-9ab9-77330209a398"));

    /**
     * Java binding for the concept described as Definition and identified by the following UUID(s):
     * <ul>
     * <li>700546a3-09c7-3fc2-9eb9-53d318659a09
     * </ul>
     */
    public static final Concept DEFINITION = Concept.make("Definition", UUID.fromString("700546a3-09c7-3fc2-9eb9-53d318659a09"));

    /**
     * Java binding for the concept described as NDC/NHRIC and identified by the following UUID(s):
     * <ul>
     * <li>f363ef10-4c50-410f-9aa0-95ceef14c658
     * </ul>
     */
    public static final Concept NDC_FORWARDSLASH_NHRIC = Concept.make("NDC/NHRIC", UUID.fromString("f363ef10-4c50-410f-9aa0-95ceef14c658"));

    /**
     * Java binding for the concept described as Public Device Record Key and identified by the following UUID(s):
     * <ul>
     * <li>4595a20d-22fa-45c6-9197-966ccd4b6a2b
     * </ul>
     */
    public static final Concept PUBLIC_DEVICE_RECORD_KEY = Concept.make("Public Device Record Key", UUID.fromString("4595a20d-22fa-45c6-9197-966ccd4b6a2b"));

    /**
     * Java binding for the concept described as UUID and identified by the following UUID(s):
     * <ul>
     * <li>845274b5-9644-3799-94c6-e0ea37e7d1a4
     * </ul>
     */
    public static final Concept UUID = Concept.make("UUID", UUID.fromString("845274b5-9644-3799-94c6-e0ea37e7d1a4"));

    /**
     * Java binding for the concept described as Float field and identified by the following UUID(s):
     * <ul>
     * <li>6efe7087-3e3c-5b45-8109-90d7652b1506
     * </ul>
     */
    public static final Concept FLOAT_FIELD = Concept.make("Float field", UUID.fromString("6efe7087-3e3c-5b45-8109-90d7652b1506"));

    /**
     * Java binding for the concept described as Integer field and identified by the following UUID(s):
     * <ul>
     * <li>ff59c300-9c4e-5e77-a35d-6a133eb3440f
     * </ul>
     */
    public static final Concept INTEGER_FIELD = Concept.make("Integer field", UUID.fromString("ff59c300-9c4e-5e77-a35d-6a133eb3440f"));

    /**
     * Java binding for the concept described as FDA Premarket Submission Number and identified by the following UUID(s):
     * <ul>
     * <li>8c0fd617-7cd8-4498-8aca-428c5361890b
     * </ul>
     */
    public static final Concept FDA_PREMARKET_SUBMISSION_NUMBER = Concept.make("FDA Premarket Submission Number", UUID.fromString("8c0fd617-7cd8-4498-8aca-428c5361890b"));

    /**
     * Java binding for the concept described as Semantic field type and identified by the following UUID(s):
     * <ul>
     * <li>9c3dfc88-51e4-5e51-a59a-88dd580162b7
     * </ul>
     */
    public static final Concept SEMANTIC_FIELD_TYPE = Concept.make("Semantic field type", UUID.fromString("9c3dfc88-51e4-5e51-a59a-88dd580162b7"));

    /**
     * Java binding for the concept described as Author and identified by the following UUID(s):
     * <ul>
     * <li>f7495b58-6630-3499-a44e-2052b5fcf06c
     * </ul>
     */
    public static final Concept AUTHOR = Concept.make("Author", UUID.fromString("f7495b58-6630-3499-a44e-2052b5fcf06c"));

    /**
     * Java binding for the concept described as String and identified by the following UUID(s):
     * <ul>
     * <li>a46aaf11-b37a-32d6-abdc-707f084ec8f5
     * </ul>
     */
    public static final Concept STRING = Concept.make("String", UUID.fromString("a46aaf11-b37a-32d6-abdc-707f084ec8f5"));

    /**
     * Java binding for the concept described as GUDID Model Concepts and identified by the following UUID(s):
     * <ul>
     * <li>0cc45825-79d1-445d-ba47-cbf9e4edc57a
     * </ul>
     */
    public static final Concept GUDID_MODEL_CONCEPTS = Concept.make("GUDID Model Concepts", UUID.fromString("0cc45825-79d1-445d-ba47-cbf9e4edc57a"));

    /**
     * Java binding for the concept described as Concept reference and identified by the following UUID(s):
     * <ul>
     * <li>e89148c7-4fe2-52f8-abb9-6a53605d20cb
     * </ul>
     */
    public static final Concept CONCEPT_REFERENCE = Concept.make("Concept reference", UUID.fromString("e89148c7-4fe2-52f8-abb9-6a53605d20cb"));

    /**
     * Java binding for the concept described as Decimal field and identified by the following UUID(s):
     * <ul>
     * <li>b413fe94-4ada-4aee-96f9-22be19699d40
     * </ul>
     */
    public static final Concept DECIMAL_FIELD = Concept.make("Decimal field", UUID.fromString("b413fe94-4ada-4aee-96f9-22be19699d40"));

    /**
     * Java binding for the concept described as Brand Name and identified by the following UUID(s):
     * <ul>
     * <li>0dfba6a6-50bc-4b9c-818b-68ce6854b433
     * </ul>
     */
    public static final Concept BRAND_NAME = Concept.make("Brand Name", UUID.fromString("0dfba6a6-50bc-4b9c-818b-68ce6854b433"));

    /**
     * Java binding for the concept described as Definition root and identified by the following UUID(s):
     * <ul>
     * <li>e7271c01-6ed4-5240-963f-34d1f24153b0
     * </ul>
     */
    public static final Concept DEFINITION_ROOT = Concept.make("Definition root", UUID.fromString("e7271c01-6ed4-5240-963f-34d1f24153b0"));

    /**
     * Java binding for the concept described as And and identified by the following UUID(s):
     * <ul>
     * <li>fa113d51-07d2-587c-8930-0bce207d506d
     * </ul>
     */
    public static final Concept AND = Concept.make("And", UUID.fromString("fa113d51-07d2-587c-8930-0bce207d506d"));

    /**
     * Java binding for the concept described as Double field and identified by the following UUID(s):
     * <ul>
     * <li>85ff6e8f-9151-5428-a5f0-e07844b69260
     * </ul>
     */
    public static final Concept DOUBLE_FIELD = Concept.make("Double field", UUID.fromString("85ff6e8f-9151-5428-a5f0-e07844b69260"));

    /**
     * Java binding for the concept described as Sandbox path and identified by the following UUID(s):
     * <ul>
     * <li>80710ea6-983c-5fa0-8908-e479f1f03ea9
     * </ul>
     */
    public static final Concept SANDBOX_PATH = Concept.make("Sandbox path", UUID.fromString("80710ea6-983c-5fa0-8908-e479f1f03ea9"));

    /**
     * Java binding for the concept described as Device Combination Product and identified by the following UUID(s):
     * <ul>
     * <li>bf3e9a89-8f75-414b-b111-c749ff7d8994
     * </ul>
     */
    public static final Concept DEVICE_COMBINATION_PRODUCT = Concept.make("Device Combination Product", UUID.fromString("bf3e9a89-8f75-414b-b111-c749ff7d8994"));

    /**
     * Java binding for the concept described as Necessary set and identified by the following UUID(s):
     * <ul>
     * <li>acaa2eba-8364-5493-b24c-b3884d34bb60
     * </ul>
     */
    public static final Concept NECESSARY_SET = Concept.make("Necessary set", UUID.fromString("acaa2eba-8364-5493-b24c-b3884d34bb60"));

    /**
     * Java binding for the concept described as Device HCTP and identified by the following UUID(s):
     * <ul>
     * <li>968b5c1e-652d-4dc8-88c1-0f882184f8ec
     * </ul>
     */
    public static final Concept DEVICE_HCTP = Concept.make("Device HCTP", UUID.fromString("968b5c1e-652d-4dc8-88c1-0f882184f8ec"));

    /**
     * Java binding for the concept described as Device ID Type and identified by the following UUID(s):
     * <ul>
     * <li>68ea75dc-b5fa-4bd7-98fd-86b43c20ee8b
     * </ul>
     */
    public static final Concept DEVICE_ID_TYPE = Concept.make("Device ID Type", UUID.fromString("68ea75dc-b5fa-4bd7-98fd-86b43c20ee8b"));

    /**
     * Java binding for the concept described as Gretel and identified by the following UUID(s):
     * <ul>
     * <li>1c0023ed-559e-3311-9e55-bd4bd9e5628f
     * </ul>
     */
    public static final Concept GRETEL = Concept.make("Gretel", UUID.fromString("1c0023ed-559e-3311-9e55-bd4bd9e5628f"));

    /**
     * Java binding for the concept described as Direct Marketing DI and identified by the following UUID(s):
     * <ul>
     * <li>7742aebf-e5ee-47be-8e71-131668bec2c1
     * </ul>
     */
    public static final Concept DIRECT_MARKETING_DI = Concept.make("Direct Marketing DI", UUID.fromString("7742aebf-e5ee-47be-8e71-131668bec2c1"));

    /**
     * Java binding for the concept described as Package DI and identified by the following UUID(s):
     * <ul>
     * <li>323c2061-0f4c-4f04-81b4-dd03ef55f1e2
     * </ul>
     */
    public static final Concept PACKAGE_DI = Concept.make("Package DI", UUID.fromString("323c2061-0f4c-4f04-81b4-dd03ef55f1e2"));

    /**
     * Java binding for the concept described as Previous DI and identified by the following UUID(s):
     * <ul>
     * <li>9087a24c-4ecd-49d6-9ebb-a7e9eb87c9df
     * </ul>
     */
    public static final Concept PREVIOUS_DI = Concept.make("Previous DI", UUID.fromString("9087a24c-4ecd-49d6-9ebb-a7e9eb87c9df"));

    /**
     * Java binding for the concept described as Dutch language and identified by the following UUID(s):
     * <ul>
     * <li>21d11bd1-3dab-5034-9625-81b9ae2bd8e7
     * <li>45022280-9567-11e5-8994-feff819cdc9f
     * <li>674ad858-0224-3f90-bcf0-bc4cab753d2d
     * </ul>
     */
    public static final Concept DUTCH_LANGUAGE = Concept.make("Dutch language", UUID.fromString("21d11bd1-3dab-5034-9625-81b9ae2bd8e7"), UUID.fromString("45022280-9567-11e5-8994-feff819cdc9f"), UUID.fromString("674ad858-0224-3f90-bcf0-bc4cab753d2d"));

    /**
     * Java binding for the concept described as Primary DI and identified by the following UUID(s):
     * <ul>
     * <li>125c52b0-b882-4bb6-875b-e56c8005b455
     * </ul>
     */
    public static final Concept PRIMARY_DI = Concept.make("Primary DI", UUID.fromString("125c52b0-b882-4bb6-875b-e56c8005b455"));

    /**
     * Java binding for the concept described as Path coordinate name and identified by the following UUID(s):
     * <ul>
     * <li>a293a9a0-eb1e-5418-83c7-bec376b62245
     * </ul>
     */
    public static final Concept PATH_COORDINATE_NAME = Concept.make("Path coordinate name", UUID.fromString("a293a9a0-eb1e-5418-83c7-bec376b62245"));

    /**
     * Java binding for the concept described as Secondary DI and identified by the following UUID(s):
     * <ul>
     * <li>4c139414-fe34-40d0-a8a8-d3f96d79b79f
     * </ul>
     */
    public static final Concept SECONDARY_DI = Concept.make("Secondary DI", UUID.fromString("4c139414-fe34-40d0-a8a8-d3f96d79b79f"));

    /**
     * Java binding for the concept described as English dialect and identified by the following UUID(s):
     * <ul>
     * <li>c0836284-f631-3c86-8cfc-56a67814efab
     * </ul>
     */
    public static final Concept ENGLISH_DIALECT = Concept.make("English dialect", UUID.fromString("c0836284-f631-3c86-8cfc-56a67814efab"));

    /**
     * Java binding for the concept described as Unit of Use DI and identified by the following UUID(s):
     * <ul>
     * <li>5e718a54-574b-43c0-a190-21b0349b5e15
     * </ul>
     */
    public static final Concept UNIT_OF_USE_DI = Concept.make("Unit of Use DI", UUID.fromString("5e718a54-574b-43c0-a190-21b0349b5e15"));

    /**
     * Java binding for the concept described as Device Identifier and identified by the following UUID(s):
     * <ul>
     * <li>1d382f32-e0b1-4789-8f44-b80041e4fc3f
     * </ul>
     */
    public static final Concept DEVICE_IDENTIFIER = Concept.make("Device Identifier", UUID.fromString("1d382f32-e0b1-4789-8f44-b80041e4fc3f"));

    /**
     * Java binding for the concept described as Device Information and identified by the following UUID(s):
     * <ul>
     * <li>42a19730-5c17-4aee-af74-939cb77b0cbf
     * </ul>
     */
    public static final Concept DEVICE_INFORMATION = Concept.make("Device Information", UUID.fromString("42a19730-5c17-4aee-af74-939cb77b0cbf"));

    /**
     * Java binding for the concept described as EL profile set operator and identified by the following UUID(s):
     * <ul>
     * <li>2352b7a2-11fd-5a68-8ece-fcb3b36570da
     * </ul>
     */
    public static final Concept EL_PROFILE_SET_OPERATOR = Concept.make("EL profile set operator", UUID.fromString("2352b7a2-11fd-5a68-8ece-fcb3b36570da"));

    /**
     * Java binding for the concept described as Catalog Number and identified by the following UUID(s):
     * <ul>
     * <li>6a9c54ad-8ce6-4e3e-bcee-5732859fae8b
     * </ul>
     */
    public static final Concept CATALOG_NUMBER = Concept.make("Catalog Number", UUID.fromString("6a9c54ad-8ce6-4e3e-bcee-5732859fae8b"));

    /**
     * Java binding for the concept described as Commercial Distribution Status and identified by the following UUID(s):
     * <ul>
     * <li>49a30bf3-a0db-4a75-8218-0c68b3a3709e
     * </ul>
     */
    public static final Concept COMMERCIAL_DISTRIBUTION_STATUS = Concept.make("Commercial Distribution Status", UUID.fromString("49a30bf3-a0db-4a75-8218-0c68b3a3709e"));

    /**
     * Java binding for the concept described as GB English dialect / GB English and identified by the following UUID(s):
     * <ul>
     * <li>eb9a5e42-3cba-356d-b623-3ed472e20b30
     * </ul>
     */
    public static final Concept GB_ENGLISH_DIALECT_FORWARDSLASH_GB_ENGLISH = Concept.make("GB English dialect / GB English", UUID.fromString("eb9a5e42-3cba-356d-b623-3ed472e20b30"));

    /**
     * Java binding for the concept described as US English dialect and identified by the following UUID(s):
     * <ul>
     * <li>bca0a686-3516-3daf-8fcf-fe396d13cfad
     * </ul>
     */
    public static final Concept US_ENGLISH_DIALECT = Concept.make("US English dialect", UUID.fromString("bca0a686-3516-3daf-8fcf-fe396d13cfad"));

    /**
     * Java binding for the concept described as Device Commercial Distribution End Date and identified by the following UUID(s):
     * <ul>
     * <li>9678787e-b6ed-4ad1-8f1d-7bedbc90d545
     * </ul>
     */
    public static final Concept DEVICE_COMMERCIAL_DISTRIBUTION_END_DATE = Concept.make("Device Commercial Distribution End Date", UUID.fromString("9678787e-b6ed-4ad1-8f1d-7bedbc90d545"));

    /**
     * Java binding for the concept described as Dialect and identified by the following UUID(s):
     * <ul>
     * <li>b9c34574-c9ac-503b-aa24-456a0ec949a2
     * </ul>
     */
    public static final Concept DIALECT = Concept.make("Dialect", UUID.fromString("b9c34574-c9ac-503b-aa24-456a0ec949a2"));

    /**
     * Java binding for the concept described as Device Count and identified by the following UUID(s):
     * <ul>
     * <li>a26cdba1-86a2-4d25-baa5-b051e962caf5
     * </ul>
     */
    public static final Concept DEVICE_COUNT = Concept.make("Device Count", UUID.fromString("a26cdba1-86a2-4d25-baa5-b051e962caf5"));

    /**
     * Java binding for the concept described as Text comparison and identified by the following UUID(s):
     * <ul>
     * <li>b1531e68-4e7a-5194-b1f9-9aaace269372
     * </ul>
     */
    public static final Concept TEXT_COMPARISON = Concept.make("Text comparison", UUID.fromString("b1531e68-4e7a-5194-b1f9-9aaace269372"));

    /**
     * Java binding for the concept described as Version Model Number and identified by the following UUID(s):
     * <ul>
     * <li>196a08b6-e119-43e0-a5d4-514932744af5
     * </ul>
     */
    public static final Concept VERSION_MODEL_NUMBER = Concept.make("Version Model Number", UUID.fromString("196a08b6-e119-43e0-a5d4-514932744af5"));

    /**
     * Java binding for the concept described as Sufficient set and identified by the following UUID(s):
     * <ul>
     * <li>8aa48cfd-485b-5140-beb9-0d122f7812d9
     * </ul>
     */
    public static final Concept SUFFICIENT_SET = Concept.make("Sufficient set", UUID.fromString("8aa48cfd-485b-5140-beb9-0d122f7812d9"));

    /**
     * Java binding for the concept described as Path origins and identified by the following UUID(s):
     * <ul>
     * <li>6e6a112e-7d8c-53c7-aaf1-c46e2d69743c
     * </ul>
     */
    public static final Concept PATH_ORIGINS = Concept.make("Path origins", UUID.fromString("6e6a112e-7d8c-53c7-aaf1-c46e2d69743c"));

    /**
     * Java binding for the concept described as Device Kit and identified by the following UUID(s):
     * <ul>
     * <li>22b9c5d9-e19b-420d-89e4-8feb45b26365
     * </ul>
     */
    public static final Concept DEVICE_KIT = Concept.make("Device Kit", UUID.fromString("22b9c5d9-e19b-420d-89e4-8feb45b26365"));

    /**
     * Java binding for the concept described as EL++ terminological axioms and identified by the following UUID(s):
     * <ul>
     * <li>b3ec50c4-e8cf-4720-b192-31374705f3b7
     * </ul>
     */
    public static final Concept EL_PLUS_PLUS_TERMINOLOGICAL_AXIOMS = Concept.make("EL++ terminological axioms", UUID.fromString("b3ec50c4-e8cf-4720-b192-31374705f3b7"));

    /**
     * Java binding for the concept described as Device Package Identifier and identified by the following UUID(s):
     * <ul>
     * <li>eaabd52e-e9da-479c-9969-d5a1b341ac11
     * </ul>
     */
    public static final Concept DEVICE_PACKAGE_IDENTIFIER = Concept.make("Device Package Identifier", UUID.fromString("eaabd52e-e9da-479c-9969-d5a1b341ac11"));

    /**
     * Java binding for the concept described as Path and identified by the following UUID(s):
     * <ul>
     * <li>748e073c-fea7-58dd-8aa3-f18fdd82ddfc
     * </ul>
     */
    public static final Concept PATH = Concept.make("Path", UUID.fromString("748e073c-fea7-58dd-8aa3-f18fdd82ddfc"));

    /**
     * Java binding for the concept described as Concepts to classify and identified by the following UUID(s):
     * <ul>
     * <li>16486419-5d1c-574f-bde6-21910ad66f44
     * </ul>
     */
    public static final Concept CONCEPTS_TO_CLASSIFY = Concept.make("Concepts to classify", UUID.fromString("16486419-5d1c-574f-bde6-21910ad66f44"));

    /**
     * Java binding for the concept described as Contains DI Number and identified by the following UUID(s):
     * <ul>
     * <li>22d22b15-067b-4604-b980-4374e6a94d9f
     * </ul>
     */
    public static final Concept CONTAINS_DI_NUMBER = Concept.make("Contains DI Number", UUID.fromString("22d22b15-067b-4604-b980-4374e6a94d9f"));

    /**
     * Java binding for the concept described as Package Discontinue Date and identified by the following UUID(s):
     * <ul>
     * <li>59b0807d-7d1c-4892-87f6-ce8ad17a9d25
     * </ul>
     */
    public static final Concept PACKAGE_DISCONTINUE_DATE = Concept.make("Package Discontinue Date", UUID.fromString("59b0807d-7d1c-4892-87f6-ce8ad17a9d25"));

    /**
     * Java binding for the concept described as Ignore case and identified by the following UUID(s):
     * <ul>
     * <li>74bbdaff-f061-5807-b334-3c88ac3e9421
     * </ul>
     */
    public static final Concept IGNORE_CASE = Concept.make("Ignore case", UUID.fromString("74bbdaff-f061-5807-b334-3c88ac3e9421"));

    /**
     * Java binding for the concept described as Compare case and identified by the following UUID(s):
     * <ul>
     * <li>a95e5dbc-a179-57f9-9cdd-6de8c026396d
     * </ul>
     */
    public static final Concept COMPARE_CASE = Concept.make("Compare case", UUID.fromString("a95e5dbc-a179-57f9-9cdd-6de8c026396d"));

    /**
     * Java binding for the concept described as Package Quantity and identified by the following UUID(s):
     * <ul>
     * <li>a74295b3-8284-43c0-8e16-9fb730574284
     * </ul>
     */
    public static final Concept PACKAGE_QUANTITY = Concept.make("Package Quantity", UUID.fromString("a74295b3-8284-43c0-8e16-9fb730574284"));

    /**
     * Java binding for the concept described as Meaning and identified by the following UUID(s):
     * <ul>
     * <li>a06158ff-e08a-5d7d-bcfa-6cbfdb138910
     * </ul>
     */
    public static final Concept MEANING = Concept.make("Meaning", UUID.fromString("a06158ff-e08a-5d7d-bcfa-6cbfdb138910"));

    /**
     * Java binding for the concept described as Package Status and identified by the following UUID(s):
     * <ul>
     * <li>436c708a-9b67-43b6-a35f-7cdf759ca116
     * </ul>
     */
    public static final Concept PACKAGE_STATUS = Concept.make("Package Status", UUID.fromString("436c708a-9b67-43b6-a35f-7cdf759ca116"));

    /**
     * Java binding for the concept described as EL++ Inferred terminological axioms and identified by the following UUID(s):
     * <ul>
     * <li>b6d3be7d-1d7f-5c44-a425-5357f878c212
     * </ul>
     */
    public static final Concept EL_PLUS_PLUS_INFERRED_TERMINOLOGICAL_AXIOMS = Concept.make("EL++ Inferred terminological axioms", UUID.fromString("b6d3be7d-1d7f-5c44-a425-5357f878c212"));

    /**
     * Java binding for the concept described as Metadata Authoring and identified by the following UUID(s):
     * <ul>
     * <li>070deb74-acc5-46bf-b9c6-eaee1b58ef52
     * </ul>
     */
    public static final Concept METADATA_AUTHORING = Concept.make("Metadata Authoring", UUID.fromString("070deb74-acc5-46bf-b9c6-eaee1b58ef52"));

    /**
     * Java binding for the concept described as EL++ Stated terminological axioms and identified by the following UUID(s):
     * <ul>
     * <li>1412bd09-eb0c-5107-9756-10c1c417d385
     * </ul>
     */
    public static final Concept EL_PLUS_PLUS_STATED_TERMINOLOGICAL_AXIOMS = Concept.make("EL++ Stated terminological axioms", UUID.fromString("1412bd09-eb0c-5107-9756-10c1c417d385"));

    /**
     * Java binding for the concept described as Package Type and identified by the following UUID(s):
     * <ul>
     * <li>51659769-790b-486b-90a9-1609208e7fe8
     * </ul>
     */
    public static final Concept PACKAGE_TYPE = Concept.make("Package Type", UUID.fromString("51659769-790b-486b-90a9-1609208e7fe8"));

    /**
     * Java binding for the concept described as Path for user and identified by the following UUID(s):
     * <ul>
     * <li>12131382-1535-5a77-928b-6eacad221ea2
     * </ul>
     */
    public static final Concept PATH_FOR_USER = Concept.make("Path for user", UUID.fromString("12131382-1535-5a77-928b-6eacad221ea2"));

    /**
     * Java binding for the concept described as Device Sterile and identified by the following UUID(s):
     * <ul>
     * <li>6dc15cbf-e21c-4997-8bf6-60304a1ab862
     * </ul>
     */
    public static final Concept DEVICE_STERILE = Concept.make("Device Sterile", UUID.fromString("6dc15cbf-e21c-4997-8bf6-60304a1ab862"));

    /**
     * Java binding for the concept described as EL++ Inferred Concept Definition and identified by the following UUID(s):
     * <ul>
     * <li>b2897aa0-a697-5bf2-9156-7a437c6a5057
     * </ul>
     */
    public static final Concept EL_PLUS_PLUS_INFERRED_CONCEPT_DEFINITION = Concept.make("EL++ Inferred Concept Definition", UUID.fromString("b2897aa0-a697-5bf2-9156-7a437c6a5057"));

    /**
     * Java binding for the concept described as Distribution Status and identified by the following UUID(s):
     * <ul>
     * <li>e71354c5-3e0b-484b-8bca-3f01c198a47f
     * </ul>
     */
    public static final Concept DISTRIBUTION_STATUS = Concept.make("Distribution Status", UUID.fromString("e71354c5-3e0b-484b-8bca-3f01c198a47f"));

    /**
     * Java binding for the concept described as In Commercial Distribution and identified by the following UUID(s):
     * <ul>
     * <li>3e64db9f-2c20-45d3-9290-331cf335806d
     * </ul>
     */
    public static final Concept IN_COMMERCIAL_DISTRIBUTION = Concept.make("In Commercial Distribution", UUID.fromString("3e64db9f-2c20-45d3-9290-331cf335806d"));

    /**
     * Java binding for the concept described as Not In Commercial Distribution and identified by the following UUID(s):
     * <ul>
     * <li>34b0d085-4d03-4a05-bba0-5d176c1e1a8a
     * </ul>
     */
    public static final Concept NOT_IN_COMMERCIAL_DISTRIBUTION = Concept.make("Not In Commercial Distribution", UUID.fromString("34b0d085-4d03-4a05-bba0-5d176c1e1a8a"));

    /**
     * Java binding for the concept described as DM Exempt and identified by the following UUID(s):
     * <ul>
     * <li>57379f0a-b6a0-4f09-b939-123b57763932
     * </ul>
     */
    public static final Concept DM_EXEMPT = Concept.make("DM Exempt", UUID.fromString("57379f0a-b6a0-4f09-b939-123b57763932"));

    /**
     * Java binding for the concept described as Axiom Syntax and identified by the following UUID(s):
     * <ul>
     * <li>8da1c508-c2a2-4899-b26d-87f8b98a7558
     * </ul>
     */
    public static final Concept AXIOM_SYNTAX = Concept.make("Axiom Syntax", UUID.fromString("8da1c508-c2a2-4899-b26d-87f8b98a7558"));

    /**
     * Java binding for the concept described as Logical Definition and identified by the following UUID(s):
     * <ul>
     * <li>7dccd042-b0b8-5cec-a1bc-6de676b92f4b
     * </ul>
     */
    public static final Concept LOGICAL_DEFINITION = Concept.make("Logical Definition", UUID.fromString("7dccd042-b0b8-5cec-a1bc-6de676b92f4b"));

    /**
     * Java binding for the concept described as Jurisdiction and identified by the following UUID(s):
     * <ul>
     * <li>581a9546-abb8-4772-826f-97858b3e21f7
     * </ul>
     */
    public static final Concept JURISDICTION = Concept.make("Jurisdiction", UUID.fromString("581a9546-abb8-4772-826f-97858b3e21f7"));

    /**
     * Java binding for the concept described as Path and identified by the following UUID(s):
     * <ul>
     * <li>ad3dd2dd-ddb0-584c-bea4-c6d9b91d461f
     * </ul>
     */
    public static final Concept PATH = Concept.make("Path", UUID.fromString("ad3dd2dd-ddb0-584c-bea4-c6d9b91d461f"));

    /**
     * Java binding for the concept described as USA and identified by the following UUID(s):
     * <ul>
     * <li>b3a01247-bc8b-4be6-9bb0-cd8bcf3e751a
     * </ul>
     */
    public static final Concept USA = Concept.make("USA", UUID.fromString("b3a01247-bc8b-4be6-9bb0-cd8bcf3e751a"));

    /**
     * Java binding for the concept described as Labeled By and identified by the following UUID(s):
     * <ul>
     * <li>87198382-0952-423c-885b-b86ba827df87
     * </ul>
     */
    public static final Concept LABELED_BY = Concept.make("Labeled By", UUID.fromString("87198382-0952-423c-885b-b86ba827df87"));

    /**
     * Java binding for the concept described as Labeled Contains NRL and identified by the following UUID(s):
     * <ul>
     * <li>3ae4e461-790e-4fa2-a90a-7b21454f9e48
     * </ul>
     */
    public static final Concept LABELED_CONTAINS_NRL = Concept.make("Labeled Contains NRL", UUID.fromString("3ae4e461-790e-4fa2-a90a-7b21454f9e48"));

    /**
     * Java binding for the concept described as Tinkar Model concept and identified by the following UUID(s):
     * <ul>
     * <li>bc59d656-83d3-47d8-9507-0e656ea95463
     * </ul>
     */
    public static final Concept TINKAR_MODEL_CONCEPT = Concept.make("Tinkar Model concept", UUID.fromString("bc59d656-83d3-47d8-9507-0e656ea95463"));

    /**
     * Java binding for the concept described as Labeled No NRL and identified by the following UUID(s):
     * <ul>
     * <li>2574c89d-bb4b-45ed-9103-7d3ff60bba4f
     * </ul>
     */
    public static final Concept LABELED_NO_NRL = Concept.make("Labeled No NRL", UUID.fromString("2574c89d-bb4b-45ed-9103-7d3ff60bba4f"));

    /**
     * Java binding for the concept described as MRI Safety Status and identified by the following UUID(s):
     * <ul>
     * <li>c4bee651-e4c0-44a0-813b-82a869c2a7af
     * </ul>
     */
    public static final Concept MRI_SAFETY_STATUS = Concept.make("MRI Safety Status", UUID.fromString("c4bee651-e4c0-44a0-813b-82a869c2a7af"));

    /**
     * Java binding for the concept described as Express Axiom and identified by the following UUID(s):
     * <ul>
     * <li>db55557c-e9ee-4504-aae3-df695b6d6c57
     * </ul>
     */
    public static final Concept EXPRESS_AXIOM = Concept.make("Express Axiom", UUID.fromString("db55557c-e9ee-4504-aae3-df695b6d6c57"));

    /**
     * Java binding for the concept described as Inclusion set and identified by the following UUID(s):
     * <ul>
     * <li>def77c09-e1eb-40f2-931a-e7cf2ce0e597
     * </ul>
     */
    public static final Concept INCLUSION_SET = Concept.make("Inclusion set", UUID.fromString("def77c09-e1eb-40f2-931a-e7cf2ce0e597"));

    /**
     * Java binding for the concept described as SOLOR overlay module and identified by the following UUID(s):
     * <ul>
     * <li>9ecc154c-e490-5cf8-805d-d2865d62aef3
     * <li>1f2016a6-960e-11e5-8994-feff819cdc9f
     * </ul>
     */
    public static final Concept SOLOR_OVERLAY_MODULE = Concept.make("SOLOR overlay module", UUID.fromString("9ecc154c-e490-5cf8-805d-d2865d62aef3"), UUID.fromString("1f2016a6-960e-11e5-8994-feff819cdc9f"));

    /**
     * Java binding for the concept described as Role and identified by the following UUID(s):
     * <ul>
     * <li>46ae9325-dd24-5008-8fda-80cf1f0977c7
     * </ul>
     */
    public static final Concept ROLE = Concept.make("Role", UUID.fromString("46ae9325-dd24-5008-8fda-80cf1f0977c7"));

    /**
     * Java binding for the concept described as Path options and identified by the following UUID(s):
     * <ul>
     * <li>2110c10c-9174-55aa-8ffe-91650c77d0b3
     * </ul>
     */
    public static final Concept PATH_OPTIONS = Concept.make("Path options", UUID.fromString("2110c10c-9174-55aa-8ffe-91650c77d0b3"));

    /**
     * Java binding for the concept described as Labeling Does Not Contain MRI Safety Information and identified by the following UUID(s):
     * <ul>
     * <li>12e886ab-4cbf-40ff-981e-b728aabedb47
     * </ul>
     */
    public static final Concept LABELING_DOES_NOT_CONTAIN_MRI_SAFETY_INFORMATION = Concept.make("Labeling Does Not Contain MRI Safety Information", UUID.fromString("12e886ab-4cbf-40ff-981e-b728aabedb47"));

    /**
     * Java binding for the concept described as Role group and identified by the following UUID(s):
     * <ul>
     * <li>a63f4bf2-a040-11e5-8994-feff819cdc9f
     * <li>f97abff6-a221-57a1-9cd6-e79e723bfe2a
     * <li>051fbfed-3c40-3130-8c09-889cb7b7b5b6
     * </ul>
     */
    public static final Concept ROLE_GROUP = Concept.make("Role group", UUID.fromString("a63f4bf2-a040-11e5-8994-feff819cdc9f"), UUID.fromString("f97abff6-a221-57a1-9cd6-e79e723bfe2a"), UUID.fromString("051fbfed-3c40-3130-8c09-889cb7b7b5b6"));

    /**
     * Java binding for the concept described as MR Conditional and identified by the following UUID(s):
     * <ul>
     * <li>9741d440-e708-4522-8aa5-755f7942d618
     * </ul>
     */
    public static final Concept MR_CONDITIONAL = Concept.make("MR Conditional", UUID.fromString("9741d440-e708-4522-8aa5-755f7942d618"));

    /**
     * Java binding for the concept described as EL++ Stated Concept Definition and identified by the following UUID(s):
     * <ul>
     * <li>0c464a4a-a0bc-53ef-9c01-ef5a049f2656
     * </ul>
     */
    public static final Concept EL_PLUS_PLUS_STATED_CONCEPT_DEFINITION = Concept.make("EL++ Stated Concept Definition", UUID.fromString("0c464a4a-a0bc-53ef-9c01-ef5a049f2656"));

    /**
     * Java binding for the concept described as MR Safe and identified by the following UUID(s):
     * <ul>
     * <li>25c434c9-bf25-4d6e-9950-fc0cf0b0a286
     * </ul>
     */
    public static final Concept MR_SAFE = Concept.make("MR Safe", UUID.fromString("25c434c9-bf25-4d6e-9950-fc0cf0b0a286"));

    /**
     * Java binding for the concept described as MR Unsafe and identified by the following UUID(s):
     * <ul>
     * <li>eeec0f05-c2cf-4f50-af7a-6262ede6bba9
     * </ul>
     */
    public static final Concept MR_UNSAFE = Concept.make("MR Unsafe", UUID.fromString("eeec0f05-c2cf-4f50-af7a-6262ede6bba9"));

    /**
     * Java binding for the concept described as OTC and identified by the following UUID(s):
     * <ul>
     * <li>4e77f0a3-ec07-4656-854e-8d9d37657fc0
     * </ul>
     */
    public static final Concept OTC = Concept.make("OTC", UUID.fromString("4e77f0a3-ec07-4656-854e-8d9d37657fc0"));

    /**
     * Java binding for the concept described as Acceptable and identified by the following UUID(s):
     * <ul>
     * <li>12b9e103-060e-3256-9982-18c1191af60e
     * </ul>
     */
    public static final Concept ACCEPTABLE = Concept.make("Acceptable", UUID.fromString("12b9e103-060e-3256-9982-18c1191af60e"));

    /**
     * Java binding for the concept described as SOLOR module and identified by the following UUID(s):
     * <ul>
     * <li>f680c868-f7e5-5d0e-91f2-615eca8f8fd2
     * </ul>
     */
    public static final Concept SOLOR_MODULE = Concept.make("SOLOR module", UUID.fromString("f680c868-f7e5-5d0e-91f2-615eca8f8fd2"));

    /**
     * Java binding for the concept described as Description acceptability and identified by the following UUID(s):
     * <ul>
     * <li>96b61063-0d29-5aea-9652-3f5f328aadc3
     * </ul>
     */
    public static final Concept DESCRIPTION_ACCEPTABILITY = Concept.make("Description acceptability", UUID.fromString("96b61063-0d29-5aea-9652-3f5f328aadc3"));

    /**
     * Java binding for the concept described as Module origins and identified by the following UUID(s):
     * <ul>
     * <li>462862d4-5df9-426e-b785-a1264e24769f
     * </ul>
     */
    public static final Concept MODULE_ORIGINS = Concept.make("Module origins", UUID.fromString("462862d4-5df9-426e-b785-a1264e24769f"));

    /**
     * Java binding for the concept described as Status and identified by the following UUID(s):
     * <ul>
     * <li>10b873e2-8247-5ab5-9dec-4edef37fc219
     * </ul>
     */
    public static final Concept STATUS = Concept.make("Status", UUID.fromString("10b873e2-8247-5ab5-9dec-4edef37fc219"));

    /**
     * Java binding for the concept described as Path origins and identified by the following UUID(s):
     * <ul>
     * <li>f33e1668-34dd-53dd-8728-31b29934b482
     * </ul>
     */
    public static final Concept PATH_ORIGINS = Concept.make("Path origins", UUID.fromString("f33e1668-34dd-53dd-8728-31b29934b482"));

    /**
     * Java binding for the concept described as Allowed states and identified by the following UUID(s):
     * <ul>
     * <li>23f69f6f-a502-5876-a835-2b1b4d5ce91e
     * </ul>
     */
    public static final Concept ALLOWED_STATES = Concept.make("Allowed states", UUID.fromString("23f69f6f-a502-5876-a835-2b1b4d5ce91e"));

    /**
     * Java binding for the concept described as ImmutableCoordinate properties and identified by the following UUID(s):
     * <ul>
     * <li>ab41a788-8a83-5452-8dc0-2d8375e0bfe6
     * </ul>
     */
    public static final Concept IMMUTABLECOORDINATE_PROPERTIES = Concept.make("ImmutableCoordinate properties", UUID.fromString("ab41a788-8a83-5452-8dc0-2d8375e0bfe6"));

    /**
     * Java binding for the concept described as Promotion Path for Edit Coordinate and identified by the following UUID(s):
     * <ul>
     * <li>db124d3b-c1bb-530e-8fd4-577f570355be
     * </ul>
     */
    public static final Concept PROMOTION_PATH_FOR_EDIT_COORDINATE = Concept.make("Promotion Path for Edit Coordinate", UUID.fromString("db124d3b-c1bb-530e-8fd4-577f570355be"));

    /**
     * Java binding for the concept described as Connective operator and identified by the following UUID(s):
     * <ul>
     * <li>3fdcaadc-d972-58e9-84f1-b3a39903b076
     * </ul>
     */
    public static final Concept CONNECTIVE_OPERATOR = Concept.make("Connective operator", UUID.fromString("3fdcaadc-d972-58e9-84f1-b3a39903b076"));

    /**
     * Java binding for the concept described as Annotation type and identified by the following UUID(s):
     * <ul>
     * <li>3fe77951-58c9-51b3-8e7e-65edcf7ace0a
     * </ul>
     */
    public static final Concept ANNOTATION_TYPE = Concept.make("Annotation type", UUID.fromString("3fe77951-58c9-51b3-8e7e-65edcf7ace0a"));

    /**
     * Java binding for the concept described as Example UCUM Units and identified by the following UUID(s):
     * <ul>
     * <li>80cd4978-314d-46e3-bc13-9980280ae955
     * </ul>
     */
    public static final Concept EXAMPLE_UCUM_UNITS = Concept.make("Example UCUM Units", UUID.fromString("80cd4978-314d-46e3-bc13-9980280ae955"));

    /**
     * Java binding for the concept described as Comment and identified by the following UUID(s):
     * <ul>
     * <li>147832d4-b9b8-5062-8891-19f9c4e4760a
     * </ul>
     */
    public static final Concept COMMENT = Concept.make("Comment", UUID.fromString("147832d4-b9b8-5062-8891-19f9c4e4760a"));

    /**
     * Java binding for the concept described as Exact and identified by the following UUID(s):
     * <ul>
     * <li>8aa6421d-4966-5230-ae5f-aca96ee9c2c1
     * </ul>
     */
    public static final Concept EXACT = Concept.make("Exact", UUID.fromString("8aa6421d-4966-5230-ae5f-aca96ee9c2c1"));

    /**
     * Java binding for the concept described as Polish dialect and identified by the following UUID(s):
     * <ul>
     * <li>315cd879-1557-5a30-b325-a5d3df9e1c2b
     * </ul>
     */
    public static final Concept POLISH_DIALECT = Concept.make("Polish dialect", UUID.fromString("315cd879-1557-5a30-b325-a5d3df9e1c2b"));

    /**
     * Java binding for the concept described as Komet issue and identified by the following UUID(s):
     * <ul>
     * <li>e1dd7bf2-224d-53a5-a5fb-7b25b05d17a6
     * </ul>
     */
    public static final Concept KOMET_ISSUE = Concept.make("Komet issue", UUID.fromString("e1dd7bf2-224d-53a5-a5fb-7b25b05d17a6"));

    /**
     * Java binding for the concept described as Tinkar root concept and identified by the following UUID(s):
     * <ul>
     * <li>7c21b6c5-cf11-5af9-893b-743f004c97f5
     * </ul>
     */
    public static final Concept TINKAR_ROOT_CONCEPT = Concept.make("Tinkar root concept", UUID.fromString("7c21b6c5-cf11-5af9-893b-743f004c97f5"));

    /**
     * Java binding for the concept described as Anonymous concept and identified by the following UUID(s):
     * <ul>
     * <li>f8f936d4-3ac7-5629-9f65-9452608056a1
     * </ul>
     */
    public static final Concept ANONYMOUS_CONCEPT = Concept.make("Anonymous concept", UUID.fromString("f8f936d4-3ac7-5629-9f65-9452608056a1"));

    /**
     * Java binding for the concept described as Unmodeled role concept and identified by the following UUID(s):
     * <ul>
     * <li>4be7118f-e6ab-5dc7-bcba-b2cc8b028492
     * </ul>
     */
    public static final Concept UNMODELED_ROLE_CONCEPT = Concept.make("Unmodeled role concept", UUID.fromString("4be7118f-e6ab-5dc7-bcba-b2cc8b028492"));

    /**
     * Java binding for the concept described as Grouping and identified by the following UUID(s):
     * <ul>
     * <li>8d76ead7-6c75-5d25-84d4-ca76d928f8a6
     * </ul>
     */
    public static final Concept GROUPING = Concept.make("Grouping", UUID.fromString("8d76ead7-6c75-5d25-84d4-ca76d928f8a6"));

    /**
     * Java binding for the concept described as Polish language and identified by the following UUID(s):
     * <ul>
     * <li>c924b887-da88-3a72-b8ea-fa86990467c9
     * <li>45022140-9567-11e5-8994-feff819cdc9f
     * </ul>
     */
    public static final Concept POLISH_LANGUAGE = Concept.make("Polish language", UUID.fromString("c924b887-da88-3a72-b8ea-fa86990467c9"), UUID.fromString("45022140-9567-11e5-8994-feff819cdc9f"));

    /**
     * Java binding for the concept described as Extended description type and identified by the following UUID(s):
     * <ul>
     * <li>5a2e7786-3e41-11dc-8314-0800200c9a66
     * </ul>
     */
    public static final Concept EXTENDED_DESCRIPTION_TYPE = Concept.make("Extended description type", UUID.fromString("5a2e7786-3e41-11dc-8314-0800200c9a66"));

    /**
     * Java binding for the concept described as Concept type and identified by the following UUID(s):
     * <ul>
     * <li>106f3ba1-63b8-5596-8dbe-524fa2e89fc0
     * </ul>
     */
    public static final Concept CONCEPT_TYPE = Concept.make("Concept type", UUID.fromString("106f3ba1-63b8-5596-8dbe-524fa2e89fc0"));

    /**
     * Java binding for the concept described as Any component and identified by the following UUID(s):
     * <ul>
     * <li>927da7ac-3403-5ccc-b07b-88f60cc3a5f8
     * </ul>
     */
    public static final Concept ANY_COMPONENT = Concept.make("Any component", UUID.fromString("927da7ac-3403-5ccc-b07b-88f60cc3a5f8"));

    /**
     * Java binding for the concept described as Dynamic referenced component restriction and identified by the following UUID(s):
     * <ul>
     * <li>0d94ceeb-e24f-5f1a-84b2-1ac35f671db5
     * </ul>
     */
    public static final Concept DYNAMIC_REFERENCED_COMPONENT_RESTRICTION = Concept.make("Dynamic referenced component restriction", UUID.fromString("0d94ceeb-e24f-5f1a-84b2-1ac35f671db5"));

    /**
     * Java binding for the concept described as Extended relationship type and identified by the following UUID(s):
     * <ul>
     * <li>d41d928f-8a97-55c1-aa6c-a289b413fbfd
     * </ul>
     */
    public static final Concept EXTENDED_RELATIONSHIP_TYPE = Concept.make("Extended relationship type", UUID.fromString("d41d928f-8a97-55c1-aa6c-a289b413fbfd"));

    /**
     * Java binding for the concept described as Object and identified by the following UUID(s):
     * <ul>
     * <li>72765109-6b53-3814-9b05-34ebddd16592
     * </ul>
     */
    public static final Concept OBJECT = Concept.make("Object", UUID.fromString("72765109-6b53-3814-9b05-34ebddd16592"));

    /**
     * Java binding for the concept described as Array and identified by the following UUID(s):
     * <ul>
     * <li>318622e6-dd7a-5651-851d-2d5c2af85767
     * </ul>
     */
    public static final Concept ARRAY = Concept.make("Array", UUID.fromString("318622e6-dd7a-5651-851d-2d5c2af85767"));

    /**
     * Java binding for the concept described as Presentation unit different and identified by the following UUID(s):
     * <ul>
     * <li>e86d3887-717b-545f-b6b5-611210913b23
     * </ul>
     */
    public static final Concept PRESENTATION_UNIT_DIFFERENT = Concept.make("Presentation unit different", UUID.fromString("e86d3887-717b-545f-b6b5-611210913b23"));

    /**
     * Java binding for the concept described as Dynamic column data types and identified by the following UUID(s):
     * <ul>
     * <li>61da7e50-f606-5ba0-a0df-83fd524951e7
     * </ul>
     */
    public static final Concept DYNAMIC_COLUMN_DATA_TYPES = Concept.make("Dynamic column data types", UUID.fromString("61da7e50-f606-5ba0-a0df-83fd524951e7"));

    /**
     * Java binding for the concept described as Intrinsic role and identified by the following UUID(s):
     * <ul>
     * <li>a2d37d2d-ac49-589f-ba36-ac9b8808b00b
     * </ul>
     */
    public static final Concept INTRINSIC_ROLE = Concept.make("Intrinsic role", UUID.fromString("a2d37d2d-ac49-589f-ba36-ac9b8808b00b"));

    /**
     * Java binding for the concept described as Array field and identified by the following UUID(s):
     * <ul>
     * <li>b168ad04-f814-5036-b886-fd4913de88c8
     * </ul>
     */
    public static final Concept ARRAY_FIELD = Concept.make("Array field", UUID.fromString("b168ad04-f814-5036-b886-fd4913de88c8"));

    /**
     * Java binding for the concept described as Property pattern implication and identified by the following UUID(s):
     * <ul>
     * <li>e0de0d09-6e27-5738-bc8f-0fc94bb115fc
     * </ul>
     */
    public static final Concept PROPERTY_PATTERN_IMPLICATION = Concept.make("Property pattern implication", UUID.fromString("e0de0d09-6e27-5738-bc8f-0fc94bb115fc"));

    /**
     * Java binding for the concept described as Display fields and identified by the following UUID(s):
     * <ul>
     * <li>4e627b9c-cecb-5563-82fc-cb0ee25113b1
     * </ul>
     */
    public static final Concept DISPLAY_FIELDS = Concept.make("Display fields", UUID.fromString("4e627b9c-cecb-5563-82fc-cb0ee25113b1"));

    /**
     * Java binding for the concept described as Author and identified by the following UUID(s):
     * <ul>
     * <li>337e93ba-531b-59a4-8153-57dca00e58d2
     * </ul>
     */
    public static final Concept AUTHOR = Concept.make("Author", UUID.fromString("337e93ba-531b-59a4-8153-57dca00e58d2"));

    /**
     * Java binding for the concept described as Float literal and identified by the following UUID(s):
     * <ul>
     * <li>da754dd9-9961-5819-91f5-8245d49850b4
     * </ul>
     */
    public static final Concept FLOAT_LITERAL = Concept.make("Float literal", UUID.fromString("da754dd9-9961-5819-91f5-8245d49850b4"));

    /**
     * Java binding for the concept described as SnoRocket classifier and identified by the following UUID(s):
     * <ul>
     * <li>1f201fac-960e-11e5-8994-feff819cdc9f
     * </ul>
     */
    public static final Concept SNOROCKET_CLASSIFIER = Concept.make("SnoRocket classifier", UUID.fromString("1f201fac-960e-11e5-8994-feff819cdc9f"));

    /**
     * Java binding for the concept described as Float substitution and identified by the following UUID(s):
     * <ul>
     * <li>cf18fe25-bd21-586e-9da4-da6cb335fd12
     * </ul>
     */
    public static final Concept FLOAT_SUBSTITUTION = Concept.make("Float substitution", UUID.fromString("cf18fe25-bd21-586e-9da4-da6cb335fd12"));

    /**
     * Java binding for the concept described as Property set and identified by the following UUID(s):
     * <ul>
     * <li>e273b5c0-c012-5e53-990c-aec5c2cb33a7
     * </ul>
     */
    public static final Concept PROPERTY_SET = Concept.make("Property set", UUID.fromString("e273b5c0-c012-5e53-990c-aec5c2cb33a7"));

    /**
     * Java binding for the concept described as Version properties and identified by the following UUID(s):
     * <ul>
     * <li>93f844df-38e5-5167-ba94-2c948b8bd07c
     * </ul>
     */
    public static final Concept VERSION_PROPERTIES = Concept.make("Version properties", UUID.fromString("93f844df-38e5-5167-ba94-2c948b8bd07c"));

    /**
     * Java binding for the concept described as Authors and identified by the following UUID(s):
     * <ul>
     * <li>4fda23b8-b016-5d2a-97d5-7ff779d60701
     * </ul>
     */
    public static final Concept AUTHORS = Concept.make("Authors", UUID.fromString("4fda23b8-b016-5d2a-97d5-7ff779d60701"));

    /**
     * Java binding for the concept described as French dialect and identified by the following UUID(s):
     * <ul>
     * <li>75d00a0d-8e46-5e42-ad34-3e46269b28a3
     * </ul>
     */
    public static final Concept FRENCH_DIALECT = Concept.make("French dialect", UUID.fromString("75d00a0d-8e46-5e42-ad34-3e46269b28a3"));

    /**
     * Java binding for the concept described as Feature and identified by the following UUID(s):
     * <ul>
     * <li>5e76a88e-794a-5fdd-8eb2-4a9e4b1386b6
     * </ul>
     */
    public static final Concept FEATURE = Concept.make("Feature", UUID.fromString("5e76a88e-794a-5fdd-8eb2-4a9e4b1386b6"));

    /**
     * Java binding for the concept described as Referenced component id and identified by the following UUID(s):
     * <ul>
     * <li>a9ba4749-c11f-5f35-a991-21796fb89ddc
     * </ul>
     */
    public static final Concept REFERENCED_COMPONENT_ID = Concept.make("Referenced component id", UUID.fromString("a9ba4749-c11f-5f35-a991-21796fb89ddc"));

    /**
     * Java binding for the concept described as Axiom focus and identified by the following UUID(s):
     * <ul>
     * <li>9c6fbddd-58bd-5881-b926-c813bbff849b
     * </ul>
     */
    public static final Concept AXIOM_FOCUS = Concept.make("Axiom focus", UUID.fromString("9c6fbddd-58bd-5881-b926-c813bbff849b"));

    /**
     * Java binding for the concept described as French language and identified by the following UUID(s):
     * <ul>
     * <li>8b23e636-a0bd-30fb-b8e2-1f77eaa3a87e
     * <li>01707e47-5f6d-555e-80af-3c1ffb297eaa
     * <li>45021dbc-9567-11e5-8994-feff819cdc9f
     * </ul>
     */
    public static final Concept FRENCH_LANGUAGE = Concept.make("French language", UUID.fromString("8b23e636-a0bd-30fb-b8e2-1f77eaa3a87e"), UUID.fromString("01707e47-5f6d-555e-80af-3c1ffb297eaa"), UUID.fromString("45021dbc-9567-11e5-8994-feff819cdc9f"));

    /**
     * Java binding for the concept described as Referenced component subtype restriction and identified by the following UUID(s):
     * <ul>
     * <li>8af1045e-1122-5072-9f29-ce7da9337915
     * </ul>
     */
    public static final Concept REFERENCED_COMPONENT_SUBTYPE_RESTRICTION = Concept.make("Referenced component subtype restriction", UUID.fromString("8af1045e-1122-5072-9f29-ce7da9337915"));

    /**
     * Java binding for the concept described as Component type focus and identified by the following UUID(s):
     * <ul>
     * <li>f1f179d0-26af-5123-9b29-9fc6cd01dd29
     * </ul>
     */
    public static final Concept COMPONENT_TYPE_FOCUS = Concept.make("Component type focus", UUID.fromString("f1f179d0-26af-5123-9b29-9fc6cd01dd29"));

    /**
     * Java binding for the concept described as Axiom origin and identified by the following UUID(s):
     * <ul>
     * <li>b868bd83-5cd4-5d84-9cf7-b08674fbc79b
     * </ul>
     */
    public static final Concept AXIOM_ORIGIN = Concept.make("Axiom origin", UUID.fromString("b868bd83-5cd4-5d84-9cf7-b08674fbc79b"));

    /**
     * Java binding for the concept described as Role operator and identified by the following UUID(s):
     * <ul>
     * <li>f9860cb8-a7c7-5743-9d7c-ffc6e8a24a0f
     * </ul>
     */
    public static final Concept ROLE_OPERATOR = Concept.make("Role operator", UUID.fromString("f9860cb8-a7c7-5743-9d7c-ffc6e8a24a0f"));

    /**
     * Java binding for the concept described as Referenced component type restriction and identified by the following UUID(s):
     * <ul>
     * <li>902f97b6-2ef4-59d7-b6f9-01278a00061c
     * </ul>
     */
    public static final Concept REFERENCED_COMPONENT_TYPE_RESTRICTION = Concept.make("Referenced component type restriction", UUID.fromString("902f97b6-2ef4-59d7-b6f9-01278a00061c"));

    /**
     * Java binding for the concept described as Stated and identified by the following UUID(s):
     * <ul>
     * <li>3b0dbd3b-2e53-3a30-8576-6c7fa7773060
     * <li>3fde38f6-e079-3cdc-a819-eda3ec74732d
     * </ul>
     */
    public static final Concept STATED = Concept.make("Stated", UUID.fromString("3b0dbd3b-2e53-3a30-8576-6c7fa7773060"), UUID.fromString("3fde38f6-e079-3cdc-a819-eda3ec74732d"));

    /**
     * Java binding for the concept described as Inferred relationship / Inferred and identified by the following UUID(s):
     * <ul>
     * <li>a4c6bf72-8fb6-11db-b606-0800200c9a66
     * <li>1290e6ba-48d0-31d2-8d62-e133373c63f5
     * </ul>
     */
    public static final Concept INFERRED_RELATIONSHIP_FORWARDSLASH_INFERRED = Concept.make("Inferred relationship / Inferred", UUID.fromString("a4c6bf72-8fb6-11db-b606-0800200c9a66"), UUID.fromString("1290e6ba-48d0-31d2-8d62-e133373c63f5"));

    /**
     * Java binding for the concept described as Boolean field and identified by the following UUID(s):
     * <ul>
     * <li>d6b9e2cc-31c6-5e80-91b7-7537690aae32
     * </ul>
     */
    public static final Concept BOOLEAN_FIELD = Concept.make("Boolean field", UUID.fromString("d6b9e2cc-31c6-5e80-91b7-7537690aae32"));

    /**
     * Java binding for the concept described as German language and identified by the following UUID(s):
     * <ul>
     * <li>5f144b18-76a8-5c7e-8480-55a5030d707f
     * </ul>
     */
    public static final Concept GERMAN_LANGUAGE = Concept.make("German language", UUID.fromString("5f144b18-76a8-5c7e-8480-55a5030d707f"));

    /**
     * Java binding for the concept described as Boolean literal and identified by the following UUID(s):
     * <ul>
     * <li>49f41695-66a7-5471-846d-21c168f54c19
     * </ul>
     */
    public static final Concept BOOLEAN_LITERAL = Concept.make("Boolean literal", UUID.fromString("49f41695-66a7-5471-846d-21c168f54c19"));

    /**
     * Java binding for the concept described as Literal value and identified by the following UUID(s):
     * <ul>
     * <li>208a40a7-e615-5efa-9de0-2e2a5a8488b7
     * </ul>
     */
    public static final Concept LITERAL_VALUE = Concept.make("Literal value", UUID.fromString("208a40a7-e615-5efa-9de0-2e2a5a8488b7"));

    /**
     * Java binding for the concept described as Boolean reference and identified by the following UUID(s):
     * <ul>
     * <li>de49d207-a26e-5f8a-b905-953a4dd13c21
     * </ul>
     */
    public static final Concept BOOLEAN_REFERENCE = Concept.make("Boolean reference", UUID.fromString("de49d207-a26e-5f8a-b905-953a4dd13c21"));

    /**
     * Java binding for the concept described as Query clauses and identified by the following UUID(s):
     * <ul>
     * <li>4905348c-ba1d-58ae-821f-52877d9acee3
     * </ul>
     */
    public static final Concept QUERY_CLAUSES = Concept.make("Query clauses", UUID.fromString("4905348c-ba1d-58ae-821f-52877d9acee3"));

    /**
     * Java binding for the concept described as Boolean substitution and identified by the following UUID(s):
     * <ul>
     * <li>03559f9d-f1e4-5485-894b-4d457f145d54
     * </ul>
     */
    public static final Concept BOOLEAN_SUBSTITUTION = Concept.make("Boolean substitution", UUID.fromString("03559f9d-f1e4-5485-894b-4d457f145d54"));

    /**
     * Java binding for the concept described as Maximum Value; Max Value and identified by the following UUID(s):
     * <ul>
     * <li>72d58983-b1e1-4ca9-833f-0e40c1defd39
     * </ul>
     */
    public static final Concept MAXIMUM_VALUE_SEMICOLON_MAX_VALUE = Concept.make("Maximum Value; Max Value", UUID.fromString("72d58983-b1e1-4ca9-833f-0e40c1defd39"));

    /**
     * Java binding for the concept described as Minimum Value; Min Value and identified by the following UUID(s):
     * <ul>
     * <li>37c35a88-9e27-42ca-b626-186773c4b612
     * </ul>
     */
    public static final Concept MINIMUM_VALUE_SEMICOLON_MIN_VALUE = Concept.make("Minimum Value; Min Value", UUID.fromString("37c35a88-9e27-42ca-b626-186773c4b612"));

    /**
     * Java binding for the concept described as Field substitution and identified by the following UUID(s):
     * <ul>
     * <li>8fdce1aa-ca82-5abc-8cfa-230c14688abc
     * </ul>
     */
    public static final Concept FIELD_SUBSTITUTION = Concept.make("Field substitution", UUID.fromString("8fdce1aa-ca82-5abc-8cfa-230c14688abc"));

    /**
     * Java binding for the concept described as Role type and identified by the following UUID(s):
     * <ul>
     * <li>76320274-be2a-5ba0-b3e8-e6d2e383ee6a
     * </ul>
     */
    public static final Concept ROLE_TYPE = Concept.make("Role type", UUID.fromString("76320274-be2a-5ba0-b3e8-e6d2e383ee6a"));

    /**
     * Java binding for the concept described as Role value and identified by the following UUID(s):
     * <ul>
     * <li>988bb02a-9b4a-4ef9-937e-fa8a6afc6c42
     * </ul>
     */
    public static final Concept ROLE_VALUE = Concept.make("Role value", UUID.fromString("988bb02a-9b4a-4ef9-937e-fa8a6afc6c42"));

    /**
     * Java binding for the concept described as Partial and identified by the following UUID(s):
     * <ul>
     * <li>a7f9574c-8e8b-515d-9c21-9896063cc3b8
     * </ul>
     */
    public static final Concept PARTIAL = Concept.make("Partial", UUID.fromString("a7f9574c-8e8b-515d-9c21-9896063cc3b8"));

    /**
     * Java binding for the concept described as Byte array field and identified by the following UUID(s):
     * <ul>
     * <li>dbdd8df2-aec3-596b-88fc-7b83b5594a45
     * </ul>
     */
    public static final Concept BYTE_ARRAY_FIELD = Concept.make("Byte array field", UUID.fromString("dbdd8df2-aec3-596b-88fc-7b83b5594a45"));

    /**
     * Java binding for the concept described as Health concept and identified by the following UUID(s):
     * <ul>
     * <li>a892950a-0847-300c-b477-4e3cbb945225
     * <li>ee9ac5d2-a07c-3981-a57a-f7f26baf38d8
     * <li>f6daf03a-93d6-5bab-8dc9-f60c327cf012
     * </ul>
     */
    public static final Concept HEALTH_CONCEPT = Concept.make("Health concept", UUID.fromString("a892950a-0847-300c-b477-4e3cbb945225"), UUID.fromString("ee9ac5d2-a07c-3981-a57a-f7f26baf38d8"), UUID.fromString("f6daf03a-93d6-5bab-8dc9-f60c327cf012"));

    /**
     * Java binding for the concept described as Phenomenon and identified by the following UUID(s):
     * <ul>
     * <li>c2e8bc47-3353-5e02-b0d1-2a5916efed4d
     * </ul>
     */
    public static final Concept PHENOMENON = Concept.make("Phenomenon", UUID.fromString("c2e8bc47-3353-5e02-b0d1-2a5916efed4d"));

    /**
     * Java binding for the concept described as Image field and identified by the following UUID(s):
     * <ul>
     * <li>cd9ea037-0af9-586b-9369-7bc044cdb8f7
     * </ul>
     */
    public static final Concept IMAGE_FIELD = Concept.make("Image field", UUID.fromString("cd9ea037-0af9-586b-9369-7bc044cdb8f7"));

    /**
     * Java binding for the concept described as Identifier source and identified by the following UUID(s):
     * <ul>
     * <li>5a87935c-d654-548f-82a2-0c06e3801162
     * </ul>
     */
    public static final Concept IDENTIFIER_SOURCE = Concept.make("Identifier source", UUID.fromString("5a87935c-d654-548f-82a2-0c06e3801162"));

    /**
     * Java binding for the concept described as Universal Restriction and identified by the following UUID(s):
     * <ul>
     * <li>fc18c082-c6ad-52d2-b568-cc9568ace6c9
     * </ul>
     */
    public static final Concept UNIVERSAL_RESTRICTION = Concept.make("Universal Restriction", UUID.fromString("fc18c082-c6ad-52d2-b568-cc9568ace6c9"));

    /**
     * Java binding for the concept described as Existential restriction and identified by the following UUID(s):
     * <ul>
     * <li>91e9080f-78f6-5d23-891d-f5b6e77995c8
     * </ul>
     */
    public static final Concept EXISTENTIAL_RESTRICTION = Concept.make("Existential restriction", UUID.fromString("91e9080f-78f6-5d23-891d-f5b6e77995c8"));

    /**
     * Java binding for the concept described as Inactive and identified by the following UUID(s):
     * <ul>
     * <li>03004053-c23e-5206-8514-fb551dd328f4
     * </ul>
     */
    public static final Concept INACTIVE = Concept.make("Inactive", UUID.fromString("03004053-c23e-5206-8514-fb551dd328f4"));

    /**
     * Java binding for the concept described as Role type to add and identified by the following UUID(s):
     * <ul>
     * <li>0c3ca846-0374-5a5c-8da4-67e0e2e28868
     * </ul>
     */
    public static final Concept ROLE_TYPE_TO_ADD = Concept.make("Role type to add", UUID.fromString("0c3ca846-0374-5a5c-8da4-67e0e2e28868"));

    /**
     * Java binding for the concept described as Feature Type and identified by the following UUID(s):
     * <ul>
     * <li>c9120d8b-1acc-5267-9f33-fa716abdb69d
     * </ul>
     */
    public static final Concept FEATURE_TYPE = Concept.make("Feature Type", UUID.fromString("c9120d8b-1acc-5267-9f33-fa716abdb69d"));

    /**
     * Java binding for the concept described as Case significance and identified by the following UUID(s):
     * <ul>
     * <li>57271621-3f3c-58dd-8148-2674bc11b7e5
     * </ul>
     */
    public static final Concept CASE_SIGNIFICANCE = Concept.make("Case significance", UUID.fromString("57271621-3f3c-58dd-8148-2674bc11b7e5"));

    /**
     * Java binding for the concept described as Root and identified by the following UUID(s):
     * <ul>
     * <li>862cc189-bbcb-51a0-89a4-16e1854be247
     * </ul>
     */
    public static final Concept ROOT = Concept.make("Root", UUID.fromString("862cc189-bbcb-51a0-89a4-16e1854be247"));

    /**
     * Java binding for the concept described as Instant literal and identified by the following UUID(s):
     * <ul>
     * <li>1fbf42e2-42b7-591f-b7fd-ba5de659529e
     * </ul>
     */
    public static final Concept INSTANT_LITERAL = Concept.make("Instant literal", UUID.fromString("1fbf42e2-42b7-591f-b7fd-ba5de659529e"));

    /**
     * Java binding for the concept described as Property Sequence and identified by the following UUID(s):
     * <ul>
     * <li>d0d759fd-510f-475a-900e-b1439b4536e1
     * </ul>
     */
    public static final Concept PROPERTY_SEQUENCE = Concept.make("Property Sequence", UUID.fromString("d0d759fd-510f-475a-900e-b1439b4536e1"));

    /**
     * Java binding for the concept described as Description version properties and identified by the following UUID(s):
     * <ul>
     * <li>732aad24-4add-59d6-bbc9-840a8b9dc754
     * </ul>
     */
    public static final Concept DESCRIPTION_VERSION_PROPERTIES = Concept.make("Description version properties", UUID.fromString("732aad24-4add-59d6-bbc9-840a8b9dc754"));

    /**
     * Java binding for the concept described as Chinese language and identified by the following UUID(s):
     * <ul>
     * <li>aacbc859-e9a0-5e01-b6a9-9a255a47b0c9
     * <li>ba2efe6b-fe56-3d91-ae0f-3b389628f74c
     * <li>45022532-9567-11e5-8994-feff819cdc9f
     * </ul>
     */
    public static final Concept CHINESE_LANGUAGE = Concept.make("Chinese language", UUID.fromString("aacbc859-e9a0-5e01-b6a9-9a255a47b0c9"), UUID.fromString("ba2efe6b-fe56-3d91-ae0f-3b389628f74c"), UUID.fromString("45022532-9567-11e5-8994-feff819cdc9f"));

    /**
     * Java binding for the concept described as Russian dialect and identified by the following UUID(s):
     * <ul>
     * <li>300126d1-2604-579f-a59b-e3c1179a173a
     * </ul>
     */
    public static final Concept RUSSIAN_DIALECT = Concept.make("Russian dialect", UUID.fromString("300126d1-2604-579f-a59b-e3c1179a173a"));

    /**
     * Java binding for the concept described as Instant substitution and identified by the following UUID(s):
     * <ul>
     * <li>56599345-31c5-5817-9d36-57dd3a626b3a
     * </ul>
     */
    public static final Concept INSTANT_SUBSTITUTION = Concept.make("Instant substitution", UUID.fromString("56599345-31c5-5817-9d36-57dd3a626b3a"));

    /**
     * Java binding for the concept described as Stated navigation and identified by the following UUID(s):
     * <ul>
     * <li>614017af-9903-53d9-aab4-15fd02193dce
     * </ul>
     */
    public static final Concept STATED_NAVIGATION = Concept.make("Stated navigation", UUID.fromString("614017af-9903-53d9-aab4-15fd02193dce"));

    /**
     * Java binding for the concept described as Language and identified by the following UUID(s):
     * <ul>
     * <li>f56fa231-10f9-5e7f-a86d-a1d61b5b56e3
     * </ul>
     */
    public static final Concept LANGUAGE = Concept.make("Language", UUID.fromString("f56fa231-10f9-5e7f-a86d-a1d61b5b56e3"));

    /**
     * Java binding for the concept described as Chronicle properties and identified by the following UUID(s):
     * <ul>
     * <li>2ba2ef47-30af-57ec-9073-38693f020d7e
     * </ul>
     */
    public static final Concept CHRONICLE_PROPERTIES = Concept.make("Chronicle properties", UUID.fromString("2ba2ef47-30af-57ec-9073-38693f020d7e"));

    /**
     * Java binding for the concept described as Russian language and identified by the following UUID(s):
     * <ul>
     * <li>0818dbb7-3fe1-59d7-99c2-c8dc42ff2cce
     * </ul>
     */
    public static final Concept RUSSIAN_LANGUAGE = Concept.make("Russian language", UUID.fromString("0818dbb7-3fe1-59d7-99c2-c8dc42ff2cce"));

    /**
     * Java binding for the concept described as Inferred navigation and identified by the following UUID(s):
     * <ul>
     * <li>4bc6c333-7fc9-52f1-942d-f8decba19dc2
     * </ul>
     */
    public static final Concept INFERRED_NAVIGATION = Concept.make("Inferred navigation", UUID.fromString("4bc6c333-7fc9-52f1-942d-f8decba19dc2"));

    /**
     * Java binding for the concept described as Primordial UUID and identified by the following UUID(s):
     * <ul>
     * <li>e0fcafbc-7191-5cdc-b14a-19d4d97f71bd
     * </ul>
     */
    public static final Concept PRIMORDIAL_UUID = Concept.make("Primordial UUID", UUID.fromString("e0fcafbc-7191-5cdc-b14a-19d4d97f71bd"));

    /**
     * Java binding for the concept described as Versions and identified by the following UUID(s):
     * <ul>
     * <li>d6f27f80-8e20-58fe-8d69-66ad4644f969
     * </ul>
     */
    public static final Concept VERSIONS = Concept.make("Versions", UUID.fromString("d6f27f80-8e20-58fe-8d69-66ad4644f969"));

    /**
     * Java binding for the concept described as Semantic list for chronicle and identified by the following UUID(s):
     * <ul>
     * <li>c809b2c0-9235-5f64-bbda-34210d91bdf8
     * </ul>
     */
    public static final Concept SEMANTIC_LIST_FOR_CHRONICLE = Concept.make("Semantic list for chronicle", UUID.fromString("c809b2c0-9235-5f64-bbda-34210d91bdf8"));

    /**
     * Java binding for the concept described as UUIDs and identified by the following UUID(s):
     * <ul>
     * <li>f8e3238e-7424-5a40-8649-a8d164382fec
     * </ul>
     */
    public static final Concept UUIDS = Concept.make("UUIDs", UUID.fromString("f8e3238e-7424-5a40-8649-a8d164382fec"));

    /**
     * Java binding for the concept described as Inverse name and identified by the following UUID(s):
     * <ul>
     * <li>c342d18a-ec1c-5583-bfe3-59e6324ae189
     * </ul>
     */
    public static final Concept INVERSE_NAME = Concept.make("Inverse name", UUID.fromString("c342d18a-ec1c-5583-bfe3-59e6324ae189"));

    /**
     * Java binding for the concept described as Object properties and identified by the following UUID(s):
     * <ul>
     * <li>3ef4311c-70c0-5149-9e06-53d745f85b15
     * </ul>
     */
    public static final Concept OBJECT_PROPERTIES = Concept.make("Object properties", UUID.fromString("3ef4311c-70c0-5149-9e06-53d745f85b15"));

    /**
     * Java binding for the concept described as Sandbox module and identified by the following UUID(s):
     * <ul>
     * <li>c5daf0e9-30dc-5b3e-a521-d6e6e72c8a95
     * </ul>
     */
    public static final Concept SANDBOX_MODULE = Concept.make("Sandbox module", UUID.fromString("c5daf0e9-30dc-5b3e-a521-d6e6e72c8a95"));

    /**
     * Java binding for the concept described as Inverse tree list and identified by the following UUID(s):
     * <ul>
     * <li>45167fb6-e01d-53a8-8be3-768aae18729d
     * </ul>
     */
    public static final Concept INVERSE_TREE_LIST = Concept.make("Inverse tree list", UUID.fromString("45167fb6-e01d-53a8-8be3-768aae18729d"));

    /**
     * Java binding for the concept described as Component Id list and identified by the following UUID(s):
     * <ul>
     * <li>e553d3f1-63e1-4292-a3a9-af646fe44292
     * </ul>
     */
    public static final Concept COMPONENT_ID_LIST = Concept.make("Component Id list", UUID.fromString("e553d3f1-63e1-4292-a3a9-af646fe44292"));

    /**
     * Java binding for the concept described as Sandbox Path module and identified by the following UUID(s):
     * <ul>
     * <li>715bd36d-6090-5b37-8ae7-88c9e532010e
     * </ul>
     */
    public static final Concept SANDBOX_PATH_MODULE = Concept.make("Sandbox Path module", UUID.fromString("715bd36d-6090-5b37-8ae7-88c9e532010e"));

    /**
     * Java binding for the concept described as Tree amalgam properties and identified by the following UUID(s):
     * <ul>
     * <li>d6151a47-4610-5a5c-abd0-42c82be9b633
     * </ul>
     */
    public static final Concept TREE_AMALGAM_PROPERTIES = Concept.make("Tree amalgam properties", UUID.fromString("d6151a47-4610-5a5c-abd0-42c82be9b633"));

    /**
     * Java binding for the concept described as Irish dialect and identified by the following UUID(s):
     * <ul>
     * <li>c0f77638-6274-5b40-b832-ac1cba7ec515
     * </ul>
     */
    public static final Concept IRISH_DIALECT = Concept.make("Irish dialect", UUID.fromString("c0f77638-6274-5b40-b832-ac1cba7ec515"));

    /**
     * Java binding for the concept described as Component Id set and identified by the following UUID(s):
     * <ul>
     * <li>e283af51-2e8f-44fa-9bf1-89a99a7c7631
     * </ul>
     */
    public static final Concept COMPONENT_ID_SET = Concept.make("Component Id set", UUID.fromString("e283af51-2e8f-44fa-9bf1-89a99a7c7631"));

    /**
     * Java binding for the concept described as Irish language and identified by the following UUID(s):
     * <ul>
     * <li>58e82fc4-1492-5cf8-8997-43800360bbd6
     * </ul>
     */
    public static final Concept IRISH_LANGUAGE = Concept.make("Irish language", UUID.fromString("58e82fc4-1492-5cf8-8997-43800360bbd6"));

    /**
     * Java binding for the concept described as Component field and identified by the following UUID(s):
     * <ul>
     * <li>fb00d132-fcc3-5cbf-881d-4bcc4b4c91b3
     * </ul>
     */
    public static final Concept COMPONENT_FIELD = Concept.make("Component field", UUID.fromString("fb00d132-fcc3-5cbf-881d-4bcc4b4c91b3"));

    /**
     * Java binding for the concept described as Component and identified by the following UUID(s):
     * <ul>
     * <li>0bc32c16-698e-5719-8bd5-efa099c7d782
     * </ul>
     */
    public static final Concept COMPONENT = Concept.make("Component", UUID.fromString("0bc32c16-698e-5719-8bd5-efa099c7d782"));

    /**
     * Java binding for the concept described as Field name and identified by the following UUID(s):
     * <ul>
     * <li>15489c68-673d-503e-bff7-e9d59e5dc15c
     * </ul>
     */
    public static final Concept FIELD_NAME = Concept.make("Field name", UUID.fromString("15489c68-673d-503e-bff7-e9d59e5dc15c"));

    /**
     * Java binding for the concept described as Is-a inferred navigation and identified by the following UUID(s):
     * <ul>
     * <li>b620768f-1479-5afa-a027-5a9ae6caf0d5
     * </ul>
     */
    public static final Concept IS_DASH_A_INFERRED_NAVIGATION = Concept.make("Is-a inferred navigation", UUID.fromString("b620768f-1479-5afa-a027-5a9ae6caf0d5"));

    /**
     * Java binding for the concept described as Semantic properties and identified by the following UUID(s):
     * <ul>
     * <li>b717ae48-5488-5dda-a980-97855001cc99
     * </ul>
     */
    public static final Concept SEMANTIC_PROPERTIES = Concept.make("Semantic properties", UUID.fromString("b717ae48-5488-5dda-a980-97855001cc99"));

    /**
     * Java binding for the concept described as Component Semantic and identified by the following UUID(s):
     * <ul>
     * <li>127e7274-0b88-5519-a9db-85d4b9ce6a4a
     * </ul>
     */
    public static final Concept COMPONENT_SEMANTIC = Concept.make("Component Semantic", UUID.fromString("127e7274-0b88-5519-a9db-85d4b9ce6a4a"));

    /**
     * Java binding for the concept described as Navigation and identified by the following UUID(s):
     * <ul>
     * <li>4d9707d8-adf0-5b15-89fc-039e4ff6fec8
     * </ul>
     */
    public static final Concept NAVIGATION = Concept.make("Navigation", UUID.fromString("4d9707d8-adf0-5b15-89fc-039e4ff6fec8"));

    /**
     * Java binding for the concept described as Is-a stated navigation and identified by the following UUID(s):
     * <ul>
     * <li>d555dde9-c97e-5480-819a-7472eda3dbfa
     * </ul>
     */
    public static final Concept IS_DASH_A_STATED_NAVIGATION = Concept.make("Is-a stated navigation", UUID.fromString("d555dde9-c97e-5480-819a-7472eda3dbfa"));

    /**
     * Java binding for the concept described as Semantic type and identified by the following UUID(s):
     * <ul>
     * <li>3daac6c4-78c5-5271-9c63-6e28f80e0c52
     * </ul>
     */
    public static final Concept SEMANTIC_TYPE = Concept.make("Semantic type", UUID.fromString("3daac6c4-78c5-5271-9c63-6e28f80e0c52"));

    /**
     * Java binding for the concept described as Italian language and identified by the following UUID(s):
     * <ul>
     * <li>bdd59458-381a-5818-8577-60525f11ac6c
     * </ul>
     */
    public static final Concept ITALIAN_LANGUAGE = Concept.make("Italian language", UUID.fromString("bdd59458-381a-5818-8577-60525f11ac6c"));

    /**
     * Java binding for the concept described as Concept focus and identified by the following UUID(s):
     * <ul>
     * <li>dca9854d-9e4c-5e8a-8b30-6c1af6901bb8
     * </ul>
     */
    public static final Concept CONCEPT_FOCUS = Concept.make("Concept focus", UUID.fromString("dca9854d-9e4c-5e8a-8b30-6c1af6901bb8"));

    /**
     * Java binding for the concept described as Description focus and identified by the following UUID(s):
     * <ul>
     * <li>6edf734d-7f57-5430-9164-6ee0824fd94b
     * </ul>
     */
    public static final Concept DESCRIPTION_FOCUS = Concept.make("Description focus", UUID.fromString("6edf734d-7f57-5430-9164-6ee0824fd94b"));

    /**
     * Java binding for the concept described as Logic graph and identified by the following UUID(s):
     * <ul>
     * <li>fc2a0662-2396-575b-95f0-e9b38a418620
     * </ul>
     */
    public static final Concept LOGIC_GRAPH = Concept.make("Logic graph", UUID.fromString("fc2a0662-2396-575b-95f0-e9b38a418620"));

    /**
     * Java binding for the concept described as Concept constraints and identified by the following UUID(s):
     * <ul>
     * <li>081273cd-92dd-593c-9d9b-63d33838e70b
     * </ul>
     */
    public static final Concept CONCEPT_CONSTRAINTS = Concept.make("Concept constraints", UUID.fromString("081273cd-92dd-593c-9d9b-63d33838e70b"));

    /**
     * Java binding for the concept described as KOMET module and identified by the following UUID(s):
     * <ul>
     * <li>34a6dae3-e5e9-50db-a9ee-69c1067911d8
     * </ul>
     */
    public static final Concept KOMET_MODULE = Concept.make("KOMET module", UUID.fromString("34a6dae3-e5e9-50db-a9ee-69c1067911d8"));

    /**
     * Java binding for the concept described as Action properties and identified by the following UUID(s):
     * <ul>
     * <li>80ba281c-7d47-57cf-8100-82b69bce998b
     * </ul>
     */
    public static final Concept ACTION_PROPERTIES = Concept.make("Action properties", UUID.fromString("80ba281c-7d47-57cf-8100-82b69bce998b"));

    /**
     * Java binding for the concept described as Signed integer and identified by the following UUID(s):
     * <ul>
     * <li>1d1c2073-d98b-3dd3-8aad-a19c65aa5a0c
     * </ul>
     */
    public static final Concept SIGNED_INTEGER = Concept.make("Signed integer", UUID.fromString("1d1c2073-d98b-3dd3-8aad-a19c65aa5a0c"));

    /**
     * Java binding for the concept described as Concept details tree table and identified by the following UUID(s):
     * <ul>
     * <li>1655edd8-7b73-52c5-98b0-263d1ab3a90b
     * </ul>
     */
    public static final Concept CONCEPT_DETAILS_TREE_TABLE = Concept.make("Concept details tree table", UUID.fromString("1655edd8-7b73-52c5-98b0-263d1ab3a90b"));

    /**
     * Java binding for the concept described as KOMET user and identified by the following UUID(s):
     * <ul>
     * <li>61c1a544-2acf-58cd-8cc0-9ac581d4227e
     * </ul>
     */
    public static final Concept KOMET_USER = Concept.make("KOMET user", UUID.fromString("61c1a544-2acf-58cd-8cc0-9ac581d4227e"));

    /**
     * Java binding for the concept described as Concept field and identified by the following UUID(s):
     * <ul>
     * <li>ac8f1f54-c7c6-5fc7-b1a8-ebb04b918557
     * </ul>
     */
    public static final Concept CONCEPT_FIELD = Concept.make("Concept field", UUID.fromString("ac8f1f54-c7c6-5fc7-b1a8-ebb04b918557"));

    /**
     * Java binding for the concept described as KOMET user list and identified by the following UUID(s):
     * <ul>
     * <li>5e77558d-97d0-52b6-adf0-d54beb97b3a6
     * </ul>
     */
    public static final Concept KOMET_USER_LIST = Concept.make("KOMET user list", UUID.fromString("5e77558d-97d0-52b6-adf0-d54beb97b3a6"));

    /**
     * Java binding for the concept described as Korean dialect and identified by the following UUID(s):
     * <ul>
     * <li>6fb2eb9c-fb9e-5959-802c-fb17bcba3079
     * </ul>
     */
    public static final Concept KOREAN_DIALECT = Concept.make("Korean dialect", UUID.fromString("6fb2eb9c-fb9e-5959-802c-fb17bcba3079"));

    /**
     * Java binding for the concept described as Status for version and identified by the following UUID(s):
     * <ul>
     * <li>0608e233-d79d-5076-985b-9b1ea4e14b4c
     * </ul>
     */
    public static final Concept STATUS_FOR_VERSION = Concept.make("Status for version", UUID.fromString("0608e233-d79d-5076-985b-9b1ea4e14b4c"));

    /**
     * Java binding for the concept described as Concept semantic and identified by the following UUID(s):
     * <ul>
     * <li>fbf054fb-ceaf-5ab8-b946-bbcc4835ce07
     * </ul>
     */
    public static final Concept CONCEPT_SEMANTIC = Concept.make("Concept semantic", UUID.fromString("fbf054fb-ceaf-5ab8-b946-bbcc4835ce07"));

    /**
     * Java binding for the concept described as Standard Korean Dialect and identified by the following UUID(s):
     * <ul>
     * <li>f90722cc-5e40-5b9b-a2a6-f4dfa312a6a9
     * </ul>
     */
    public static final Concept STANDARD_KOREAN_DIALECT = Concept.make("Standard Korean Dialect", UUID.fromString("f90722cc-5e40-5b9b-a2a6-f4dfa312a6a9"));

    /**
     * Java binding for the concept described as Korean language and identified by the following UUID(s):
     * <ul>
     * <li>1464f995-d658-5e9d-86e0-8308a6fa57eb
     * </ul>
     */
    public static final Concept KOREAN_LANGUAGE = Concept.make("Korean language", UUID.fromString("1464f995-d658-5e9d-86e0-8308a6fa57eb"));

    /**
     * Java binding for the concept described as Concept substitution and identified by the following UUID(s):
     * <ul>
     * <li>23483990-b738-5f43-bc03-befd43928a37
     * </ul>
     */
    public static final Concept CONCEPT_SUBSTITUTION = Concept.make("Concept substitution", UUID.fromString("23483990-b738-5f43-bc03-befd43928a37"));

    /**
     * Java binding for the concept described as Withdrawn and identified by the following UUID(s):
     * <ul>
     * <li>35fd4750-6e43-5fa3-ba7f-f2ad376052bc
     * </ul>
     */
    public static final Concept WITHDRAWN = Concept.make("Withdrawn", UUID.fromString("35fd4750-6e43-5fa3-ba7f-f2ad376052bc"));

    /**
     * Java binding for the concept described as Concept to find and identified by the following UUID(s):
     * <ul>
     * <li>91687b29-3bbb-540b-9de6-91246c75afd0
     * </ul>
     */
    public static final Concept CONCEPT_TO_FIND = Concept.make("Concept to find", UUID.fromString("91687b29-3bbb-540b-9de6-91246c75afd0"));

    /**
     * Java binding for the concept described as Spanish language and identified by the following UUID(s):
     * <ul>
     * <li>0fcf44fb-d0a7-3a67-bc9f-eb3065ed3c8e
     * <li>45021c36-9567-11e5-8994-feff819cdc9f
     * </ul>
     */
    public static final Concept SPANISH_LANGUAGE = Concept.make("Spanish language", UUID.fromString("0fcf44fb-d0a7-3a67-bc9f-eb3065ed3c8e"), UUID.fromString("45021c36-9567-11e5-8994-feff819cdc9f"));

    /**
     * Java binding for the concept described as Sufficient concept definition and identified by the following UUID(s):
     * <ul>
     * <li>6d9cd46e-8a8f-310a-a298-3e55dcf7a986
     * </ul>
     */
    public static final Concept SUFFICIENT_CONCEPT_DEFINITION = Concept.make("Sufficient concept definition", UUID.fromString("6d9cd46e-8a8f-310a-a298-3e55dcf7a986"));

    /**
     * Java binding for the concept described as Sufficient concept definition operator and identified by the following UUID(s):
     * <ul>
     * <li>dfa80f36-dbe6-5006-8509-c497a26ceab5
     * </ul>
     */
    public static final Concept SUFFICIENT_CONCEPT_DEFINITION_OPERATOR = Concept.make("Sufficient concept definition operator", UUID.fromString("dfa80f36-dbe6-5006-8509-c497a26ceab5"));

    /**
     * Java binding for the concept described as Language coordinate name and identified by the following UUID(s):
     * <ul>
     * <li>42dff20f-5ed2-559a-91ad-91d44a573c63
     * </ul>
     */
    public static final Concept LANGUAGE_COORDINATE_NAME = Concept.make("Language coordinate name", UUID.fromString("42dff20f-5ed2-559a-91ad-91d44a573c63"));

    /**
     * Java binding for the concept described as Path concept and identified by the following UUID(s):
     * <ul>
     * <li>1b9d9f95-fc0a-55ac-b2e6-7c8b37660046
     * </ul>
     */
    public static final Concept PATH_CONCEPT = Concept.make("Path concept", UUID.fromString("1b9d9f95-fc0a-55ac-b2e6-7c8b37660046"));

    /**
     * Java binding for the concept described as Semantic field concepts and identified by the following UUID(s):
     * <ul>
     * <li>b4316cb8-14fe-5b32-b03b-f5f966c87819
     * </ul>
     */
    public static final Concept SEMANTIC_FIELD_CONCEPTS = Concept.make("Semantic field concepts", UUID.fromString("b4316cb8-14fe-5b32-b03b-f5f966c87819"));

    /**
     * Java binding for the concept described as Version and identified by the following UUID(s):
     * <ul>
     * <li>c202f992-3f4b-5f30-9b32-e376f68367d1
     * </ul>
     */
    public static final Concept VERSION = Concept.make("Version", UUID.fromString("c202f992-3f4b-5f30-9b32-e376f68367d1"));

    /**
     * Java binding for the concept described as Language coordinate properties and identified by the following UUID(s):
     * <ul>
     * <li>ea1a52f7-0305-5487-8766-e846330f167a
     * </ul>
     */
    public static final Concept LANGUAGE_COORDINATE_PROPERTIES = Concept.make("Language coordinate properties", UUID.fromString("ea1a52f7-0305-5487-8766-e846330f167a"));

    /**
     * Java binding for the concept described as Concrete value operator and identified by the following UUID(s):
     * <ul>
     * <li>843b0b55-8785-5544-93f6-581da9cf1ff3
     * </ul>
     */
    public static final Concept CONCRETE_VALUE_OPERATOR = Concept.make("Concrete value operator", UUID.fromString("843b0b55-8785-5544-93f6-581da9cf1ff3"));

    /**
     * Java binding for the concept described as Dialect order and identified by the following UUID(s):
     * <ul>
     * <li>c060ffbf-e95f-5960-b296-8a3255c820ac
     * </ul>
     */
    public static final Concept DIALECT_ORDER = Concept.make("Dialect order", UUID.fromString("c060ffbf-e95f-5960-b296-8a3255c820ac"));

    /**
     * Java binding for the concept described as Swedish language and identified by the following UUID(s):
     * <ul>
     * <li>9784a791-8fdb-32f7-88da-74ab135fe4e3
     * <li>45022848-9567-11e5-8994-feff819cdc9f
     * </ul>
     */
    public static final Concept SWEDISH_LANGUAGE = Concept.make("Swedish language", UUID.fromString("9784a791-8fdb-32f7-88da-74ab135fe4e3"), UUID.fromString("45022848-9567-11e5-8994-feff819cdc9f"));

    /**
     * Java binding for the concept described as Language nid and identified by the following UUID(s):
     * <ul>
     * <li>38e0c7b8-1e33-56a2-9eb2-ee20c4960684
     * </ul>
     */
    public static final Concept LANGUAGE_NID = Concept.make("Language nid", UUID.fromString("38e0c7b8-1e33-56a2-9eb2-ee20c4960684"));

    /**
     * Java binding for the concept described as Equal to and identified by the following UUID(s):
     * <ul>
     * <li>5c9b5844-1434-5111-83d5-cb7cb0be12d9
     * </ul>
     */
    public static final Concept EQUAL_TO = Concept.make("Equal to", UUID.fromString("5c9b5844-1434-5111-83d5-cb7cb0be12d9"));

    /**
     * Java binding for the concept described as Greater than and identified by the following UUID(s):
     * <ul>
     * <li>65af466b-360c-58b2-8b7d-2854150029a8
     * </ul>
     */
    public static final Concept GREATER_THAN = Concept.make("Greater than", UUID.fromString("65af466b-360c-58b2-8b7d-2854150029a8"));

    /**
     * Java binding for the concept described as Greater than or equal to and identified by the following UUID(s):
     * <ul>
     * <li>c1baba19-e918-5d2c-8fa4-b0ad93e03186
     * </ul>
     */
    public static final Concept GREATER_THAN_OR_EQUAL_TO = Concept.make("Greater than or equal to", UUID.fromString("c1baba19-e918-5d2c-8fa4-b0ad93e03186"));

    /**
     * Java binding for the concept described as Less than and identified by the following UUID(s):
     * <ul>
     * <li>6f96e8cf-5568-5e49-8a90-aa6c65125ee9
     * </ul>
     */
    public static final Concept LESS_THAN = Concept.make("Less than", UUID.fromString("6f96e8cf-5568-5e49-8a90-aa6c65125ee9"));

    /**
     * Java binding for the concept described as Less than or equal to and identified by the following UUID(s):
     * <ul>
     * <li>6dfacbd5-8344-5794-9fda-bec95b2aa6c9
     * </ul>
     */
    public static final Concept LESS_THAN_OR_EQUAL_TO = Concept.make("Less than or equal to", UUID.fromString("6dfacbd5-8344-5794-9fda-bec95b2aa6c9"));

    /**
     * Java binding for the concept described as Maximum Value Operator; Maximum Domain Operator and identified by the following UUID(s):
     * <ul>
     * <li>7b8916ab-fd50-41df-8fc2-0b2a7a78be6d
     * </ul>
     */
    public static final Concept MAXIMUM_VALUE_OPERATOR_SEMICOLON_MAXIMUM_DOMAIN_OPERATOR = Concept.make("Maximum Value Operator; Maximum Domain Operator", UUID.fromString("7b8916ab-fd50-41df-8fc2-0b2a7a78be6d"));

    /**
     * Java binding for the concept described as Minimum Value Operator; Minimum Domain Operator and identified by the following UUID(s):
     * <ul>
     * <li>ded98e42-f74a-4432-9ae7-01b94dc2fdea
     * </ul>
     */
    public static final Concept MINIMUM_VALUE_OPERATOR_SEMICOLON_MINIMUM_DOMAIN_OPERATOR = Concept.make("Minimum Value Operator; Minimum Domain Operator", UUID.fromString("ded98e42-f74a-4432-9ae7-01b94dc2fdea"));

    /**
     * Java binding for the concept described as Language and identified by the following UUID(s):
     * <ul>
     * <li>b0ad4d77-e1bc-5fd1-922e-5fad675e9bfd
     * </ul>
     */
    public static final Concept LANGUAGE = Concept.make("Language", UUID.fromString("b0ad4d77-e1bc-5fd1-922e-5fad675e9bfd"));

    /**
     * Java binding for the concept described as Conditional triggers and identified by the following UUID(s):
     * <ul>
     * <li>a3e4ac54-db82-5345-8713-7e0da98bbb0a
     * </ul>
     */
    public static final Concept CONDITIONAL_TRIGGERS = Concept.make("Conditional triggers", UUID.fromString("a3e4ac54-db82-5345-8713-7e0da98bbb0a"));

    /**
     * Java binding for the concept described as Time for version and identified by the following UUID(s):
     * <ul>
     * <li>a9b0dfb2-f463-5dae-8ba8-7f2e8385571b
     * </ul>
     */
    public static final Concept TIME_FOR_VERSION = Concept.make("Time for version", UUID.fromString("a9b0dfb2-f463-5dae-8ba8-7f2e8385571b"));

    /**
     * Java binding for the concept described as Disjoint with and identified by the following UUID(s):
     * <ul>
     * <li>f8433993-9a2d-5377-b564-80a45c7b7824
     * </ul>
     */
    public static final Concept DISJOINT_WITH = Concept.make("Disjoint with", UUID.fromString("f8433993-9a2d-5377-b564-80a45c7b7824"));

    /**
     * Java binding for the concept described as Or and identified by the following UUID(s):
     * <ul>
     * <li>2c940bcf-22a8-5fc9-b232-580021e758ed
     * </ul>
     */
    public static final Concept OR = Concept.make("Or", UUID.fromString("2c940bcf-22a8-5fc9-b232-580021e758ed"));

    /**
     * Java binding for the concept described as Is a and identified by the following UUID(s):
     * <ul>
     * <li>c93a30b9-ba77-3adb-a9b8-4589c9f8fb25
     * <li>46bccdc4-8fb6-11db-b606-0800200c9a66
     * </ul>
     */
    public static final Concept IS_A = Concept.make("Is a", UUID.fromString("c93a30b9-ba77-3adb-a9b8-4589c9f8fb25"), UUID.fromString("46bccdc4-8fb6-11db-b606-0800200c9a66"));

    /**
     * Java binding for the concept described as Part of and identified by the following UUID(s):
     * <ul>
     * <li>b4c3f6f9-6937-30fd-8412-d0c77f8a7f73
     * </ul>
     */
    public static final Concept PART_OF = Concept.make("Part of", UUID.fromString("b4c3f6f9-6937-30fd-8412-d0c77f8a7f73"));

    /**
     * Java binding for the concept described as Correlation expression and identified by the following UUID(s):
     * <ul>
     * <li>1711815f-99a1-5d1a-8f1e-75dc7bf41928
     * </ul>
     */
    public static final Concept CORRELATION_EXPRESSION = Concept.make("Correlation expression", UUID.fromString("1711815f-99a1-5d1a-8f1e-75dc7bf41928"));

    /**
     * Java binding for the concept described as Tree list and identified by the following UUID(s):
     * <ul>
     * <li>c11dd7a1-0ba1-5378-81d6-3efdba1e074b
     * </ul>
     */
    public static final Concept TREE_LIST = Concept.make("Tree list", UUID.fromString("c11dd7a1-0ba1-5378-81d6-3efdba1e074b"));

    /**
     * Java binding for the concept described as Lithuanian Language and identified by the following UUID(s):
     * <ul>
     * <li>8fa63274-70e3-5b11-9669-1b7bdb372b1a
     * <li>e9645d95-8a1f-3825-8feb-0bc2ee825694
     * <li>45022410-9567-11e5-8994-feff819cdc9f
     * </ul>
     */
    public static final Concept LITHUANIAN_LANGUAGE = Concept.make("Lithuanian Language", UUID.fromString("8fa63274-70e3-5b11-9669-1b7bdb372b1a"), UUID.fromString("e9645d95-8a1f-3825-8feb-0bc2ee825694"), UUID.fromString("45022410-9567-11e5-8994-feff819cdc9f"));

    /**
     * Java binding for the concept described as Correlation properties and identified by the following UUID(s):
     * <ul>
     * <li>8f682e00-3d9e-5506-bd19-b2169d6c8752
     * </ul>
     */
    public static final Concept CORRELATION_PROPERTIES = Concept.make("Correlation properties", UUID.fromString("8f682e00-3d9e-5506-bd19-b2169d6c8752"));

    /**
     * Java binding for the concept described as Correlation reference expression and identified by the following UUID(s):
     * <ul>
     * <li>acb73d95-7c96-590c-9f24-23da54f95ff2
     * </ul>
     */
    public static final Concept CORRELATION_REFERENCE_EXPRESSION = Concept.make("Correlation reference expression", UUID.fromString("acb73d95-7c96-590c-9f24-23da54f95ff2"));

    /**
     * Java binding for the concept described as Logic coordinate name and identified by the following UUID(s):
     * <ul>
     * <li>78972f14-e0f6-5f72-bf82-59310b5f7b26
     * </ul>
     */
    public static final Concept LOGIC_COORDINATE_NAME = Concept.make("Logic coordinate name", UUID.fromString("78972f14-e0f6-5f72-bf82-59310b5f7b26"));

    /**
     * Java binding for the concept described as United States English Nursing Dialect and identified by the following UUID(s):
     * <ul>
     * <li>6e447636-1085-32ff-bc36-6748a45255de
     * </ul>
     */
    public static final Concept UNITED_STATES_ENGLISH_NURSING_DIALECT = Concept.make("United States English Nursing Dialect", UUID.fromString("6e447636-1085-32ff-bc36-6748a45255de"));

    /**
     * Java binding for the concept described as Logic coordinate properties and identified by the following UUID(s):
     * <ul>
     * <li>1fa63819-5ac1-5938-95b1-47871a5f2b17
     * </ul>
     */
    public static final Concept LOGIC_COORDINATE_PROPERTIES = Concept.make("Logic coordinate properties", UUID.fromString("1fa63819-5ac1-5938-95b1-47871a5f2b17"));

    /**
     * Java binding for the concept described as Creative Commons BY license and identified by the following UUID(s):
     * <ul>
     * <li>3415a972-7850-57cd-aa86-a572ca1c2ceb
     * </ul>
     */
    public static final Concept CREATIVE_COMMONS_BY_LICENSE = Concept.make("Creative Commons BY license", UUID.fromString("3415a972-7850-57cd-aa86-a572ca1c2ceb"));

    /**
     * Java binding for the concept described as UUID data type and identified by the following UUID(s):
     * <ul>
     * <li>2faa9262-8fb2-11db-b606-0800200c9a66
     * <li>680f3f6c-7a2a-365d-b527-8c9a96dd1a94
     * </ul>
     */
    public static final Concept UUID_DATA_TYPE = Concept.make("UUID data type", UUID.fromString("2faa9262-8fb2-11db-b606-0800200c9a66"), UUID.fromString("680f3f6c-7a2a-365d-b527-8c9a96dd1a94"));

    /**
     * Java binding for the concept described as Czech dialect and identified by the following UUID(s):
     * <ul>
     * <li>6979e268-0b59-542f-bac0-313c5ddf6a2e
     * </ul>
     */
    public static final Concept CZECH_DIALECT = Concept.make("Czech dialect", UUID.fromString("6979e268-0b59-542f-bac0-313c5ddf6a2e"));

    /**
     * Java binding for the concept described as UUID field and identified by the following UUID(s):
     * <ul>
     * <li>dea8cb0f-9bb5-56bb-af27-a14943cb24ba
     * </ul>
     */
    public static final Concept UUID_FIELD = Concept.make("UUID field", UUID.fromString("dea8cb0f-9bb5-56bb-af27-a14943cb24ba"));

    /**
     * Java binding for the concept described as Logical expression field and identified by the following UUID(s):
     * <ul>
     * <li>c16eb414-8840-54f8-9bd2-e2f1ab37e19d
     * </ul>
     */
    public static final Concept LOGICAL_EXPRESSION_FIELD = Concept.make("Logical expression field", UUID.fromString("c16eb414-8840-54f8-9bd2-e2f1ab37e19d"));

    /**
     * Java binding for the concept described as Czech language and identified by the following UUID(s):
     * <ul>
     * <li>33aa2d26-0541-557c-b796-904cbf245101
     * </ul>
     */
    public static final Concept CZECH_LANGUAGE = Concept.make("Czech language", UUID.fromString("33aa2d26-0541-557c-b796-904cbf245101"));

    /**
     * Java binding for the concept described as Logical expression semantic and identified by the following UUID(s):
     * <ul>
     * <li>d19306b1-4744-5028-a715-17ca4a4d657f
     * </ul>
     */
    public static final Concept LOGICAL_EXPRESSION_SEMANTIC = Concept.make("Logical expression semantic", UUID.fromString("d19306b1-4744-5028-a715-17ca4a4d657f"));

    /**
     * Java binding for the concept described as Danish language and identified by the following UUID(s):
     * <ul>
     * <li>987681fb-f3ef-595d-90e2-067baf2bc71f
     * <li>45021f10-9567-11e5-8994-feff819cdc9f
     * <li>7e462e33-6d94-38ae-a044-492a857a6853
     * </ul>
     */
    public static final Concept DANISH_LANGUAGE = Concept.make("Danish language", UUID.fromString("987681fb-f3ef-595d-90e2-067baf2bc71f"), UUID.fromString("45021f10-9567-11e5-8994-feff819cdc9f"), UUID.fromString("7e462e33-6d94-38ae-a044-492a857a6853"));

    /**
     * Java binding for the concept described as Uncategorized phenomenon and identified by the following UUID(s):
     * <ul>
     * <li>722f5ac8-1f5c-5d8f-96bb-370d79596f66
     * </ul>
     */
    public static final Concept UNCATEGORIZED_PHENOMENON = Concept.make("Uncategorized phenomenon", UUID.fromString("722f5ac8-1f5c-5d8f-96bb-370d79596f66"));

    /**
     * Java binding for the concept described as Logically equivalent to and identified by the following UUID(s):
     * <ul>
     * <li>3642d9a3-8e23-5289-836b-366c0b1e2900
     * </ul>
     */
    public static final Concept LOGICALLY_EQUIVALENT_TO = Concept.make("Logically equivalent to", UUID.fromString("3642d9a3-8e23-5289-836b-366c0b1e2900"));

    /**
     * Java binding for the concept described as Default module and identified by the following UUID(s):
     * <ul>
     * <li>e83d322c-e275-5392-a5db-1de5fe98acb5
     * </ul>
     */
    public static final Concept DEFAULT_MODULE = Concept.make("Default module", UUID.fromString("e83d322c-e275-5392-a5db-1de5fe98acb5"));

    /**
     * Java binding for the concept described as Taxonomy operator and identified by the following UUID(s):
     * <ul>
     * <li>e9252365-7a43-57ea-bf94-3f23bab4ef99
     * </ul>
     */
    public static final Concept TAXONOMY_OPERATOR = Concept.make("Taxonomy operator", UUID.fromString("e9252365-7a43-57ea-bf94-3f23bab4ef99"));

    /**
     * Java binding for the concept described as Master path and identified by the following UUID(s):
     * <ul>
     * <li>1f20134a-960e-11e5-8994-feff819cdc9f
     * <li>2faa9260-8fb2-11db-b606-0800200c9a66
     * </ul>
     */
    public static final Concept MASTER_PATH = Concept.make("Master path", UUID.fromString("1f20134a-960e-11e5-8994-feff819cdc9f"), UUID.fromString("2faa9260-8fb2-11db-b606-0800200c9a66"));

    /**
     * Java binding for the concept described as Description type and identified by the following UUID(s):
     * <ul>
     * <li>ad0c19e8-2ccc-59c1-8b7e-c56c03aca8eb
     * </ul>
     */
    public static final Concept DESCRIPTION_TYPE = Concept.make("Description type", UUID.fromString("ad0c19e8-2ccc-59c1-8b7e-c56c03aca8eb"));

    /**
     * Java binding for the concept described as Membership semantic and identified by the following UUID(s):
     * <ul>
     * <li>4fa29287-a80e-5f83-abab-4b587973e7b7
     * </ul>
     */
    public static final Concept MEMBERSHIP_SEMANTIC = Concept.make("Membership semantic", UUID.fromString("4fa29287-a80e-5f83-abab-4b587973e7b7"));

    /**
     * Java binding for the concept described as Description and identified by the following UUID(s):
     * <ul>
     * <li>87118daf-d28c-55fb-8657-cd6bc8425600
     * </ul>
     */
    public static final Concept DESCRIPTION = Concept.make("Description", UUID.fromString("87118daf-d28c-55fb-8657-cd6bc8425600"));

    /**
     * Java binding for the concept described as Model concept and identified by the following UUID(s):
     * <ul>
     * <li>7bbd4210-381c-11e7-9598-0800200c9a66
     * </ul>
     */
    public static final Concept MODEL_CONCEPT = Concept.make("Model concept", UUID.fromString("7bbd4210-381c-11e7-9598-0800200c9a66"));

    /**
     * Java binding for the concept described as Field categories and identified by the following UUID(s):
     * <ul>
     * <li>52cf6efc-f45d-4bfe-ab75-e71d72b0a18f
     * </ul>
     */
    public static final Concept FIELD_CATEGORIES = Concept.make("Field categories", UUID.fromString("52cf6efc-f45d-4bfe-ab75-e71d72b0a18f"));

    /**
     * Java binding for the concept described as Public ID field and identified by the following UUID(s):
     * <ul>
     * <li>665da062-ee17-4a9d-bb72-276d30ca4086
     * </ul>
     */
    public static final Concept PUBLIC_ID_FIELD = Concept.make("Public ID field", UUID.fromString("665da062-ee17-4a9d-bb72-276d30ca4086"));

    /**
     * Java binding for the concept described as Component field and identified by the following UUID(s):
     * <ul>
     * <li>f3a7758e-55e1-4d80-bc3f-947a5ee0a04a
     * </ul>
     */
    public static final Concept COMPONENT_FIELD = Concept.make("Component field", UUID.fromString("f3a7758e-55e1-4d80-bc3f-947a5ee0a04a"));

    /**
     * Java binding for the concept described as Case sensitive and identified by the following UUID(s):
     * <ul>
     * <li>0def37bc-7e1b-384b-a6a3-3e3ceee9c52e
     * </ul>
     */
    public static final Concept CASE_SENSITIVE = Concept.make("Case sensitive", UUID.fromString("0def37bc-7e1b-384b-a6a3-3e3ceee9c52e"));

    /**
     * Java binding for the concept described as Component version field and identified by the following UUID(s):
     * <ul>
     * <li>856282f5-f1c3-4624-a649-5164bbb981be
     * </ul>
     */
    public static final Concept COMPONENT_VERSION_FIELD = Concept.make("Component version field", UUID.fromString("856282f5-f1c3-4624-a649-5164bbb981be"));

    /**
     * Java binding for the concept described as Component versions set and identified by the following UUID(s):
     * <ul>
     * <li>0e9db2e1-3c48-446f-ad1a-123dceea3f7e
     * </ul>
     */
    public static final Concept COMPONENT_VERSIONS_SET = Concept.make("Component versions set", UUID.fromString("0e9db2e1-3c48-446f-ad1a-123dceea3f7e"));

    /**
     * Java binding for the concept described as Concept field and identified by the following UUID(s):
     * <ul>
     * <li>10fc904c-89c9-46ad-915e-100d6e1404c8
     * </ul>
     */
    public static final Concept CONCEPT_FIELD = Concept.make("Concept field", UUID.fromString("10fc904c-89c9-46ad-915e-100d6e1404c8"));

    /**
     * Java binding for the concept described as Identifier Value and identified by the following UUID(s):
     * <ul>
     * <li>b32dd26b-c3fc-487e-987e-16ace71a0d0f
     * </ul>
     */
    public static final Concept IDENTIFIER_VALUE = Concept.make("Identifier Value", UUID.fromString("b32dd26b-c3fc-487e-987e-16ace71a0d0f"));

    /**
     * Java binding for the concept described as Concept version field and identified by the following UUID(s):
     * <ul>
     * <li>caa3c85b-7500-49fe-b450-f3c745306a42
     * </ul>
     */
    public static final Concept CONCEPT_VERSION_FIELD = Concept.make("Concept version field", UUID.fromString("caa3c85b-7500-49fe-b450-f3c745306a42"));

    /**
     * Java binding for the concept described as Inferred Definition and identified by the following UUID(s):
     * <ul>
     * <li>b1abf4dc-9838-4b46-ac55-10c4f92ba10b
     * </ul>
     */
    public static final Concept INFERRED_DEFINITION = Concept.make("Inferred Definition", UUID.fromString("b1abf4dc-9838-4b46-ac55-10c4f92ba10b"));

    /**
     * Java binding for the concept described as Concept versions set and identified by the following UUID(s):
     * <ul>
     * <li>0c897052-1126-418c-b452-570280fc0cf7
     * </ul>
     */
    public static final Concept CONCEPT_VERSIONS_SET = Concept.make("Concept versions set", UUID.fromString("0c897052-1126-418c-b452-570280fc0cf7"));

    /**
     * Java binding for the concept described as Purpose and identified by the following UUID(s):
     * <ul>
     * <li>c3dffc48-6493-54df-a2f0-14be8ba03091
     * </ul>
     */
    public static final Concept PURPOSE = Concept.make("Purpose", UUID.fromString("c3dffc48-6493-54df-a2f0-14be8ba03091"));

    /**
     * Java binding for the concept described as Status field and identified by the following UUID(s):
     * <ul>
     * <li>30e2f18f-cf6a-47b9-8804-e30b5cd99b5a
     * </ul>
     */
    public static final Concept STATUS_FIELD = Concept.make("Status field", UUID.fromString("30e2f18f-cf6a-47b9-8804-e30b5cd99b5a"));

    /**
     * Java binding for the concept described as Relationship destination and identified by the following UUID(s):
     * <ul>
     * <li>a3dd69af-355c-54ce-ba13-2902a7ae9551
     * </ul>
     */
    public static final Concept RELATIONSHIP_DESTINATION = Concept.make("Relationship destination", UUID.fromString("a3dd69af-355c-54ce-ba13-2902a7ae9551"));

    /**
     * Java binding for the concept described as Author field and identified by the following UUID(s):
     * <ul>
     * <li>1ec827a2-4558-4f3f-b330-535cc530b2fa
     * </ul>
     */
    public static final Concept AUTHOR_FIELD = Concept.make("Author field", UUID.fromString("1ec827a2-4558-4f3f-b330-535cc530b2fa"));

    /**
     * Java binding for the concept described as Relationship origin and identified by the following UUID(s):
     * <ul>
     * <li>ad22d43b-3ee7-550b-9660-a6e68af347c2
     * </ul>
     */
    public static final Concept RELATIONSHIP_ORIGIN = Concept.make("Relationship origin", UUID.fromString("ad22d43b-3ee7-550b-9660-a6e68af347c2"));

    /**
     * Java binding for the concept described as STAMP field and identified by the following UUID(s):
     * <ul>
     * <li>c3992399-3fa3-40cf-bcac-69b0c839b001
     * </ul>
     */
    public static final Concept STAMP_FIELD = Concept.make("STAMP field", UUID.fromString("c3992399-3fa3-40cf-bcac-69b0c839b001"));

    /**
     * Java binding for the concept described as Value Range and identified by the following UUID(s):
     * <ul>
     * <li>87ce975b-309b-47f4-a6c6-4ae6df6649a1
     * </ul>
     */
    public static final Concept VALUE_RANGE = Concept.make("Value Range", UUID.fromString("87ce975b-309b-47f4-a6c6-4ae6df6649a1"));

    /**
     * Java binding for the concept described as STAMP version field and identified by the following UUID(s):
     * <ul>
     * <li>90f275b5-10f5-4e21-8b18-bc7af8ed8b3c
     * </ul>
     */
    public static final Concept STAMP_VERSION_FIELD = Concept.make("STAMP version field", UUID.fromString("90f275b5-10f5-4e21-8b18-bc7af8ed8b3c"));

    /**
     * Java binding for the concept described as Description case significance and identified by the following UUID(s):
     * <ul>
     * <li>c3dde9ea-b144-5f49-845a-20cc7d305250
     * <li>f30b0312-2c85-3e65-8609-2d89f8437d34
     * </ul>
     */
    public static final Concept DESCRIPTION_CASE_SIGNIFICANCE = Concept.make("Description case significance", UUID.fromString("c3dde9ea-b144-5f49-845a-20cc7d305250"), UUID.fromString("f30b0312-2c85-3e65-8609-2d89f8437d34"));

    /**
     * Java binding for the concept described as Stated Definition and identified by the following UUID(s):
     * <ul>
     * <li>28608bd3-ac73-4fe8-a5f0-1efe0d6650a8
     * </ul>
     */
    public static final Concept STATED_DEFINITION = Concept.make("Stated Definition", UUID.fromString("28608bd3-ac73-4fe8-a5f0-1efe0d6650a8"));

    /**
     * Java binding for the concept described as Vertex and identified by the following UUID(s):
     * <ul>
     * <li>3e56c6b6-5371-11eb-ae93-0242ac130002
     * </ul>
     */
    public static final Concept VERTEX = Concept.make("Vertex", UUID.fromString("3e56c6b6-5371-11eb-ae93-0242ac130002"));

    /**
     * Java binding for the concept described as STAMP versions set and identified by the following UUID(s):
     * <ul>
     * <li>8478f8a3-ba49-4b9e-bf65-b6b685b226ee
     * </ul>
     */
    public static final Concept STAMP_VERSIONS_SET = Concept.make("STAMP versions set", UUID.fromString("8478f8a3-ba49-4b9e-bf65-b6b685b226ee"));

    /**
     * Java binding for the concept described as Text and identified by the following UUID(s):
     * <ul>
     * <li>8bdcbe5d-e92e-5c10-845e-b585e6061672
     * </ul>
     */
    public static final Concept TEXT = Concept.make("Text", UUID.fromString("8bdcbe5d-e92e-5c10-845e-b585e6061672"));

    /**
     * Java binding for the concept described as Pattern field and identified by the following UUID(s):
     * <ul>
     * <li>09cdb88f-c7d1-4d58-b97e-91886a115425
     * </ul>
     */
    public static final Concept PATTERN_FIELD = Concept.make("Pattern field", UUID.fromString("09cdb88f-c7d1-4d58-b97e-91886a115425"));

    /**
     * Java binding for the concept described as Value Constraint and identified by the following UUID(s):
     * <ul>
     * <li>8c55fb86-92d8-42a9-ad70-1e23abbf7eec
     * </ul>
     */
    public static final Concept VALUE_CONSTRAINT = Concept.make("Value Constraint", UUID.fromString("8c55fb86-92d8-42a9-ad70-1e23abbf7eec"));

    /**
     * Java binding for the concept described as Semantic field and identified by the following UUID(s):
     * <ul>
     * <li>e0a1eae7-c730-4a52-98f3-c28ee457bed5
     * </ul>
     */
    public static final Concept SEMANTIC_FIELD = Concept.make("Semantic field", UUID.fromString("e0a1eae7-c730-4a52-98f3-c28ee457bed5"));

    /**
     * Java binding for the concept described as Value Constraint Source and identified by the following UUID(s):
     * <ul>
     * <li>09aa031a-6290-4ec9-a44c-23928a767da3
     * </ul>
     */
    public static final Concept VALUE_CONSTRAINT_SOURCE = Concept.make("Value Constraint Source", UUID.fromString("09aa031a-6290-4ec9-a44c-23928a767da3"));

    /**
     * Java binding for the concept described as Pattern version field and identified by the following UUID(s):
     * <ul>
     * <li>6f172c94-7ff4-40f9-bccb-c447ee156c5b
     * </ul>
     */
    public static final Concept PATTERN_VERSION_FIELD = Concept.make("Pattern version field", UUID.fromString("6f172c94-7ff4-40f9-bccb-c447ee156c5b"));

    /**
     * Java binding for the concept described as Semantic version field and identified by the following UUID(s):
     * <ul>
     * <li>e258e3d2-8d94-48c9-8be9-18a88f623b3f
     * </ul>
     */
    public static final Concept SEMANTIC_VERSION_FIELD = Concept.make("Semantic version field", UUID.fromString("e258e3d2-8d94-48c9-8be9-18a88f623b3f"));

    /**
     * Java binding for the concept described as Module field and identified by the following UUID(s):
     * <ul>
     * <li>b08984ac-a65b-49c2-8781-9790d59378fc
     * </ul>
     */
    public static final Concept MODULE_FIELD = Concept.make("Module field", UUID.fromString("b08984ac-a65b-49c2-8781-9790d59378fc"));

    /**
     * Java binding for the concept described as Path field and identified by the following UUID(s):
     * <ul>
     * <li>5a52c560-91a0-4d71-ba33-dc9afecf9c1e
     * </ul>
     */
    public static final Concept PATH_FIELD = Concept.make("Path field", UUID.fromString("5a52c560-91a0-4d71-ba33-dc9afecf9c1e"));

    /**
     * Java binding for the concept described as Pattern versions set and identified by the following UUID(s):
     * <ul>
     * <li>127dd369-72b0-422a-9c63-5a52de8903b0
     * </ul>
     */
    public static final Concept PATTERN_VERSIONS_SET = Concept.make("Pattern versions set", UUID.fromString("127dd369-72b0-422a-9c63-5a52de8903b0"));

    /**
     * Java binding for the concept described as Semantic versions set and identified by the following UUID(s):
     * <ul>
     * <li>d95e119e-8d09-46a6-88bb-f0733134d910
     * </ul>
     */
    public static final Concept SEMANTIC_VERSIONS_SET = Concept.make("Semantic versions set", UUID.fromString("d95e119e-8d09-46a6-88bb-f0733134d910"));

    /**
     * Java binding for the concept described as Pattern meaning field and identified by the following UUID(s):
     * <ul>
     * <li>aaa158da-f6ab-4dc3-bb74-694c93fd1f00
     * </ul>
     */
    public static final Concept PATTERN_MEANING_FIELD = Concept.make("Pattern meaning field", UUID.fromString("aaa158da-f6ab-4dc3-bb74-694c93fd1f00"));

    /**
     * Java binding for the concept described as Pattern purpose field and identified by the following UUID(s):
     * <ul>
     * <li>62b0bee6-a0be-43b8-b60e-7653821c1f44
     * </ul>
     */
    public static final Concept PATTERN_PURPOSE_FIELD = Concept.make("Pattern purpose field", UUID.fromString("62b0bee6-a0be-43b8-b60e-7653821c1f44"));

    /**
     * Java binding for the concept described as Vertex states and identified by the following UUID(s):
     * <ul>
     * <li>347cd3f2-8130-5032-8960-091e194e9afe
     * </ul>
     */
    public static final Concept VERTEX_STATES = Concept.make("Vertex states", UUID.fromString("347cd3f2-8130-5032-8960-091e194e9afe"));

    /**
     * Java binding for the concept described as Field definition meaning field and identified by the following UUID(s):
     * <ul>
     * <li>8ece8ca0-f452-4d8c-8ac5-ad616e3a8f84
     * </ul>
     */
    public static final Concept FIELD_DEFINITION_MEANING_FIELD = Concept.make("Field definition meaning field", UUID.fromString("8ece8ca0-f452-4d8c-8ac5-ad616e3a8f84"));

    /**
     * Java binding for the concept described as Field definition purpose field and identified by the following UUID(s):
     * <ul>
     * <li>cd9b682f-52ba-4330-b6f1-95e546765895
     * </ul>
     */
    public static final Concept FIELD_DEFINITION_PURPOSE_FIELD = Concept.make("Field definition purpose field", UUID.fromString("cd9b682f-52ba-4330-b6f1-95e546765895"));

    /**
     * Java binding for the concept described as Description core type and identified by the following UUID(s):
     * <ul>
     * <li>351955ff-30f4-5806-a0a5-5dda79756377
     * </ul>
     */
    public static final Concept DESCRIPTION_CORE_TYPE = Concept.make("Description core type", UUID.fromString("351955ff-30f4-5806-a0a5-5dda79756377"));

    /**
     * Java binding for the concept described as Field definition field and identified by the following UUID(s):
     * <ul>
     * <li>733054e8-92e0-48fd-bf29-406bdbbe48e8
     * </ul>
     */
    public static final Concept FIELD_DEFINITION_FIELD = Concept.make("Field definition field", UUID.fromString("733054e8-92e0-48fd-bf29-406bdbbe48e8"));

    /**
     * Java binding for the concept described as Field definitions set and identified by the following UUID(s):
     * <ul>
     * <li>9c709814-bd05-474f-9817-3b1ed32c0719
     * </ul>
     */
    public static final Concept FIELD_DEFINITIONS_SET = Concept.make("Field definitions set", UUID.fromString("9c709814-bd05-474f-9817-3b1ed32c0719"));

    /**
     * Java binding for the concept described as Semantic field field and identified by the following UUID(s):
     * <ul>
     * <li>ae50f537-ad75-41ac-bbff-9a1fe5948d4e
     * </ul>
     */
    public static final Concept SEMANTIC_FIELD_FIELD = Concept.make("Semantic field field", UUID.fromString("ae50f537-ad75-41ac-bbff-9a1fe5948d4e"));

    /**
     * Java binding for the concept described as Module exclusions and identified by the following UUID(s):
     * <ul>
     * <li>3fe047f0-33b0-5254-91c2-43e65f90d30b
     * </ul>
     */
    public static final Concept MODULE_EXCLUSIONS = Concept.make("Module exclusions", UUID.fromString("3fe047f0-33b0-5254-91c2-43e65f90d30b"));

    /**
     * Java binding for the concept described as Semantic field fields set and identified by the following UUID(s):
     * <ul>
     * <li>21693722-9e48-49d9-9878-a0239fda2dcc
     * </ul>
     */
    public static final Concept SEMANTIC_FIELD_FIELDS_SET = Concept.make("Semantic field fields set", UUID.fromString("21693722-9e48-49d9-9878-a0239fda2dcc"));

    /**
     * Java binding for the concept described as Semantic pattern field and identified by the following UUID(s):
     * <ul>
     * <li>a40e26ae-6164-45b5-a6e7-dc04736df26b
     * </ul>
     */
    public static final Concept SEMANTIC_PATTERN_FIELD = Concept.make("Semantic pattern field", UUID.fromString("a40e26ae-6164-45b5-a6e7-dc04736df26b"));

    /**
     * Java binding for the concept described as Semantic referenced component field and identified by the following UUID(s):
     * <ul>
     * <li>346593b1-db85-47b4-949c-04b0ba2630a8
     * </ul>
     */
    public static final Concept SEMANTIC_REFERENCED_COMPONENT_FIELD = Concept.make("Semantic referenced component field", UUID.fromString("346593b1-db85-47b4-949c-04b0ba2630a8"));

    /**
     * Java binding for the concept described as Field definition data type field and identified by the following UUID(s):
     * <ul>
     * <li>e525f682-bf39-44b2-9b86-c3a747acce02
     * </ul>
     */
    public static final Concept FIELD_DEFINITION_DATA_TYPE_FIELD = Concept.make("Field definition data type field", UUID.fromString("e525f682-bf39-44b2-9b86-c3a747acce02"));

    /**
     * Java binding for the concept described as Integer field and identified by the following UUID(s):
     * <ul>
     * <li>f7b1bf50-3b36-4970-bf29-f1f50aa41222
     * </ul>
     */
    public static final Concept INTEGER_FIELD = Concept.make("Integer field", UUID.fromString("f7b1bf50-3b36-4970-bf29-f1f50aa41222"));

    /**
     * Java binding for the concept described as String field and identified by the following UUID(s):
     * <ul>
     * <li>51bd5e7a-c6ff-4791-870a-2618f346a132
     * </ul>
     */
    public static final Concept STRING_FIELD = Concept.make("String field", UUID.fromString("51bd5e7a-c6ff-4791-870a-2618f346a132"));

    /**
     * Java binding for the concept described as Sort and identified by the following UUID(s):
     * <ul>
     * <li>e973f077-a99d-59e6-b7bd-804e87e0e639
     * </ul>
     */
    public static final Concept SORT = Concept.make("Sort", UUID.fromString("e973f077-a99d-59e6-b7bd-804e87e0e639"));

    /**
     * Java binding for the concept described as Boolean field and identified by the following UUID(s):
     * <ul>
     * <li>bb8486e1-ca0a-4b8e-a09f-6b9356275205
     * </ul>
     */
    public static final Concept BOOLEAN_FIELD = Concept.make("Boolean field", UUID.fromString("bb8486e1-ca0a-4b8e-a09f-6b9356275205"));

    /**
     * Java binding for the concept described as Field definition index field and identified by the following UUID(s):
     * <ul>
     * <li>32a45943-d628-4302-a9a2-4a87693605f5
     * </ul>
     */
    public static final Concept FIELD_DEFINITION_INDEX_FIELD = Concept.make("Field definition index field", UUID.fromString("32a45943-d628-4302-a9a2-4a87693605f5"));

    /**
     * Java binding for the concept described as Description dialect pair and identified by the following UUID(s):
     * <ul>
     * <li>a27bbbf8-57b5-590c-8650-1247f6f963eb
     * </ul>
     */
    public static final Concept DESCRIPTION_DIALECT_PAIR = Concept.make("Description dialect pair", UUID.fromString("a27bbbf8-57b5-590c-8650-1247f6f963eb"));

    /**
     * Java binding for the concept described as Field index field and identified by the following UUID(s):
     * <ul>
     * <li>3615ea54-4c87-42b7-9a2e-9b92b7f5d08d
     * </ul>
     */
    public static final Concept FIELD_INDEX_FIELD = Concept.make("Field index field", UUID.fromString("3615ea54-4c87-42b7-9a2e-9b92b7f5d08d"));

    /**
     * Java binding for the concept described as Field value field and identified by the following UUID(s):
     * <ul>
     * <li>6a830504-5940-4420-a4d3-887d4b3e9e18
     * </ul>
     */
    public static final Concept FIELD_VALUE_FIELD = Concept.make("Field value field", UUID.fromString("6a830504-5940-4420-a4d3-887d4b3e9e18"));

    /**
     * Java binding for the concept described as Instant field and identified by the following UUID(s):
     * <ul>
     * <li>cae34826-dbd1-4570-a6d4-73b4bd2eff77
     * </ul>
     */
    public static final Concept INSTANT_FIELD = Concept.make("Instant field", UUID.fromString("cae34826-dbd1-4570-a6d4-73b4bd2eff77"));

    /**
     * Java binding for the concept described as Module for user and identified by the following UUID(s):
     * <ul>
     * <li>c8fd4f1b-d842-5245-9a7d-a58dc0ac1c11
     * </ul>
     */
    public static final Concept MODULE_FOR_USER = Concept.make("Module for user", UUID.fromString("c8fd4f1b-d842-5245-9a7d-a58dc0ac1c11"));

    /**
     * Java binding for the concept described as Time field and identified by the following UUID(s):
     * <ul>
     * <li>d56eaed0-8966-4338-9e1b-cbdf9a294bab
     * </ul>
     */
    public static final Concept TIME_FIELD = Concept.make("Time field", UUID.fromString("d56eaed0-8966-4338-9e1b-cbdf9a294bab"));

    /**
     * Java binding for the concept described as Description for dialect/description pair and identified by the following UUID(s):
     * <ul>
     * <li>1137767a-ad8b-5bc5-9842-a1f9b09d1ecc
     * </ul>
     */
    public static final Concept DESCRIPTION_FOR_DIALECT_FORWARDSLASH_DESCRIPTION_PAIR = Concept.make("Description for dialect/description pair", UUID.fromString("1137767a-ad8b-5bc5-9842-a1f9b09d1ecc"));

    /**
     * Java binding for the concept described as View Key and identified by the following UUID(s):
     * <ul>
     * <li>4211cf36-bd75-586a-805c-51f059e2eaaa
     * </ul>
     */
    public static final Concept VIEW_KEY = Concept.make("View Key", UUID.fromString("4211cf36-bd75-586a-805c-51f059e2eaaa"));

    /**
     * Java binding for the concept described as Dialect for dialect/description pair and identified by the following UUID(s):
     * <ul>
     * <li>850bc47d-5235-5bce-99f4-c41f8a163d69
     * </ul>
     */
    public static final Concept DIALECT_FOR_DIALECT_FORWARDSLASH_DESCRIPTION_PAIR = Concept.make("Dialect for dialect/description pair", UUID.fromString("850bc47d-5235-5bce-99f4-c41f8a163d69"));

    /**
     * Java binding for the concept described as Module and identified by the following UUID(s):
     * <ul>
     * <li>67cd64f1-96d7-5110-b847-556c055ac063
     * </ul>
     */
    public static final Concept MODULE = Concept.make("Module", UUID.fromString("67cd64f1-96d7-5110-b847-556c055ac063"));

    /**
     * Java binding for the concept described as Module options and identified by the following UUID(s):
     * <ul>
     * <li>19305aff-95d9-55d9-b015-825cc68eadc7
     * </ul>
     */
    public static final Concept MODULE_OPTIONS = Concept.make("Module options", UUID.fromString("19305aff-95d9-55d9-b015-825cc68eadc7"));

    /**
     * Java binding for the concept described as Boolean and identified by the following UUID(s):
     * <ul>
     * <li>08f2fb74-980d-5157-b92c-4ff1eac6a506
     * </ul>
     */
    public static final Concept BOOLEAN = Concept.make("Boolean", UUID.fromString("08f2fb74-980d-5157-b92c-4ff1eac6a506"));

    /**
     * Java binding for the concept described as Initial character case insensitive and identified by the following UUID(s):
     * <ul>
     * <li>17915e0d-ed38-3488-a35c-cda966db306a
     * </ul>
     */
    public static final Concept INITIAL_CHARACTER_CASE_INSENSITIVE = Concept.make("Initial character case insensitive", UUID.fromString("17915e0d-ed38-3488-a35c-cda966db306a"));

    /**
     * Java binding for the concept described as Module Preference list and identified by the following UUID(s):
     * <ul>
     * <li>f56ef2df-6758-5271-a587-317a4fed6c2e
     * </ul>
     */
    public static final Concept MODULE_PREFERENCE_LIST = Concept.make("Module Preference list", UUID.fromString("f56ef2df-6758-5271-a587-317a4fed6c2e"));

    /**
     * Java binding for the concept described as Byte array and identified by the following UUID(s):
     * <ul>
     * <li>9a84fecf-708d-5de4-9c5f-e17973229e0f
     * </ul>
     */
    public static final Concept BYTE_ARRAY = Concept.make("Byte array", UUID.fromString("9a84fecf-708d-5de4-9c5f-e17973229e0f"));

    /**
     * Java binding for the concept described as Logic profile and identified by the following UUID(s):
     * <ul>
     * <li>aef80e34-b2dd-5dca-a989-3e0ee2699be3
     * </ul>
     */
    public static final Concept LOGIC_PROFILE = Concept.make("Logic profile", UUID.fromString("aef80e34-b2dd-5dca-a989-3e0ee2699be3"));

    /**
     * Java binding for the concept described as Module nids and identified by the following UUID(s):
     * <ul>
     * <li>f36e7ca6-34a2-58b5-8b25-736457515f9c
     * </ul>
     */
    public static final Concept MODULE_NIDS = Concept.make("Module nids", UUID.fromString("f36e7ca6-34a2-58b5-8b25-736457515f9c"));

    /**
     * Java binding for the concept described as Description list for concept and identified by the following UUID(s):
     * <ul>
     * <li>ab3e8771-7c7c-5e57-8acf-147b16da36e2
     * </ul>
     */
    public static final Concept DESCRIPTION_LIST_FOR_CONCEPT = Concept.make("Description list for concept", UUID.fromString("ab3e8771-7c7c-5e57-8acf-147b16da36e2"));

    /**
     * Java binding for the concept described as Module order and identified by the following UUID(s):
     * <ul>
     * <li>ddeda759-e89c-5186-aa40-d63070756ab4
     * </ul>
     */
    public static final Concept MODULE_ORDER = Concept.make("Module order", UUID.fromString("ddeda759-e89c-5186-aa40-d63070756ab4"));

    /**
     * Java binding for the concept described as Double and identified by the following UUID(s):
     * <ul>
     * <li>7172e6ac-a05a-5a34-8275-aef430b18207
     * </ul>
     */
    public static final Concept DOUBLE = Concept.make("Double", UUID.fromString("7172e6ac-a05a-5a34-8275-aef430b18207"));

    /**
     * Java binding for the concept described as Description semantic and identified by the following UUID(s):
     * <ul>
     * <li>81487d5f-6115-51e2-a3b3-93d783888eb8
     * </ul>
     */
    public static final Concept DESCRIPTION_SEMANTIC = Concept.make("Description semantic", UUID.fromString("81487d5f-6115-51e2-a3b3-93d783888eb8"));

    /**
     * Java binding for the concept described as Modules and identified by the following UUID(s):
     * <ul>
     * <li>bf69c4f1-95c9-5956-a10a-d3ba9276c019
     * </ul>
     */
    public static final Concept MODULES = Concept.make("Modules", UUID.fromString("bf69c4f1-95c9-5956-a10a-d3ba9276c019"));

    /**
     * Java binding for the concept described as Float and identified by the following UUID(s):
     * <ul>
     * <li>fb591801-7b37-525d-980d-98a1c63ceee0
     * </ul>
     */
    public static final Concept FLOAT = Concept.make("Float", UUID.fromString("fb591801-7b37-525d-980d-98a1c63ceee0"));

    /**
     * Java binding for the concept described as Decimal and identified by the following UUID(s):
     * <ul>
     * <li>dccb0476-3b63-3d48-b5a2-85bd0ad2fa61
     * </ul>
     */
    public static final Concept DECIMAL = Concept.make("Decimal", UUID.fromString("dccb0476-3b63-3d48-b5a2-85bd0ad2fa61"));

    /**
     * Java binding for the concept described as Description type and identified by the following UUID(s):
     * <ul>
     * <li>a00c5ad7-5b8a-5592-a28c-64057dd3caab
     * </ul>
     */
    public static final Concept DESCRIPTION_TYPE = Concept.make("Description type", UUID.fromString("a00c5ad7-5b8a-5592-a28c-64057dd3caab"));

    /**
     * Java binding for the concept described as Navigation set and identified by the following UUID(s):
     * <ul>
     * <li>fc965c5d-ad17-555e-bcb5-b78fd45c8c5f
     * </ul>
     */
    public static final Concept NAVIGATION_SET = Concept.make("Navigation set", UUID.fromString("fc965c5d-ad17-555e-bcb5-b78fd45c8c5f"));

    /**
     * Java binding for the concept described as Navigation vertex and identified by the following UUID(s):
     * <ul>
     * <li>c7f01834-34ca-5f8b-8f80-193fbeb12eae
     * </ul>
     */
    public static final Concept NAVIGATION_VERTEX = Concept.make("Navigation vertex", UUID.fromString("c7f01834-34ca-5f8b-8f80-193fbeb12eae"));

    /**
     * Java binding for the concept described as Type order and identified by the following UUID(s):
     * <ul>
     * <li>44c7eab6-fdb8-5427-9d7a-52ab63f7a6f9
     * </ul>
     */
    public static final Concept TYPE_ORDER = Concept.make("Type order", UUID.fromString("44c7eab6-fdb8-5427-9d7a-52ab63f7a6f9"));

    /**
     * Java binding for the concept described as Long and identified by the following UUID(s):
     * <ul>
     * <li>dea8cdf1-de75-5991-9791-79714e4a964d
     * </ul>
     */
    public static final Concept LONG = Concept.make("Long", UUID.fromString("dea8cdf1-de75-5991-9791-79714e4a964d"));

    /**
     * Java binding for the concept described as Necessary but not sufficient concept definition and identified by the following UUID(s):
     * <ul>
     * <li>e1a12059-3b01-3296-9532-d10e49d0afc3
     * </ul>
     */
    public static final Concept NECESSARY_BUT_NOT_SUFFICIENT_CONCEPT_DEFINITION = Concept.make("Necessary but not sufficient concept definition", UUID.fromString("e1a12059-3b01-3296-9532-d10e49d0afc3"));

    /**
     * Java binding for the concept described as Language for description and identified by the following UUID(s):
     * <ul>
     * <li>cd56cceb-8507-5ae5-a928-16079fe6f832
     * </ul>
     */
    public static final Concept LANGUAGE_FOR_DESCRIPTION = Concept.make("Language for description", UUID.fromString("cd56cceb-8507-5ae5-a928-16079fe6f832"));

    /**
     * Java binding for the concept described as Description-logic profile and identified by the following UUID(s):
     * <ul>
     * <li>14eadb10-fbd0-5999-af37-05728a8503af
     * </ul>
     */
    public static final Concept DESCRIPTION_DASH_LOGIC_PROFILE = Concept.make("Description-logic profile", UUID.fromString("14eadb10-fbd0-5999-af37-05728a8503af"));

    /**
     * Java binding for the concept described as EL ++ logic profile and identified by the following UUID(s):
     * <ul>
     * <li>1f201e12-960e-11e5-8994-feff819cdc9f
     * </ul>
     */
    public static final Concept EL_PLUS_PLUS_LOGIC_PROFILE = Concept.make("EL ++ logic profile", UUID.fromString("1f201e12-960e-11e5-8994-feff819cdc9f"));

    /**
     * Java binding for the concept described as Destination module and identified by the following UUID(s):
     * <ul>
     * <li>349cfd1d-10fd-5f8d-a0a5-d5ef0932b4da
     * </ul>
     */
    public static final Concept DESTINATION_MODULE = Concept.make("Destination module", UUID.fromString("349cfd1d-10fd-5f8d-a0a5-d5ef0932b4da"));

    /**
     * Java binding for the concept described as Not applicable and identified by the following UUID(s):
     * <ul>
     * <li>d4cc29ae-c0c1-563a-985d-5165a768dd44
     * </ul>
     */
    public static final Concept NOT_APPLICABLE = Concept.make("Not applicable", UUID.fromString("d4cc29ae-c0c1-563a-985d-5165a768dd44"));

    /**
     * Java binding for the concept described as User module and identified by the following UUID(s):
     * <ul>
     * <li>349161ba-9a6a-5c9c-a78f-281f19cfc057
     * </ul>
     */
    public static final Concept USER_MODULE = Concept.make("User module", UUID.fromString("349161ba-9a6a-5c9c-a78f-281f19cfc057"));

    /**
     * Java binding for the concept described as Development module and identified by the following UUID(s):
     * <ul>
     * <li>529a7069-bd33-59e6-b2ce-537fa874360a
     * </ul>
     */
    public static final Concept DEVELOPMENT_MODULE = Concept.make("Development module", UUID.fromString("529a7069-bd33-59e6-b2ce-537fa874360a"));

    /**
     * Java binding for the concept described as Module and identified by the following UUID(s):
     * <ul>
     * <li>40d1c869-b509-32f8-b735-836eac577a67
     * </ul>
     */
    public static final Concept MODULE = Concept.make("Module", UUID.fromString("40d1c869-b509-32f8-b735-836eac577a67"));

    /**
     * Java binding for the concept described as Native Identifier and identified by the following UUID(s):
     * <ul>
     * <li>d1a17272-9785-51aa-8bde-cc556ab32ebb
     * </ul>
     */
    public static final Concept NATIVE_IDENTIFIER = Concept.make("Native Identifier", UUID.fromString("d1a17272-9785-51aa-8bde-cc556ab32ebb"));

    /**
     * Java binding for the concept described as Sandbox component and identified by the following UUID(s):
     * <ul>
     * <li>c93829b2-aa78-5a84-ac9a-c34307844166
     * </ul>
     */
    public static final Concept SANDBOX_COMPONENT = Concept.make("Sandbox component", UUID.fromString("c93829b2-aa78-5a84-ac9a-c34307844166"));

    /**
     * Java binding for the concept described as Development path and identified by the following UUID(s):
     * <ul>
     * <li>1f200ca6-960e-11e5-8994-feff819cdc9f
     * </ul>
     */
    public static final Concept DEVELOPMENT_PATH = Concept.make("Development path", UUID.fromString("1f200ca6-960e-11e5-8994-feff819cdc9f"));

    /**
     * Java binding for the concept described as Has Active Ingredient and identified by the following UUID(s):
     * <ul>
     * <li>65bf3b7f-c854-36b5-81c3-4915461020a8
     * </ul>
     */
    public static final Concept HAS_ACTIVE_INGREDIENT = Concept.make("Has Active Ingredient", UUID.fromString("65bf3b7f-c854-36b5-81c3-4915461020a8"));

    /**
     * Java binding for the concept described as Has Dose Form and identified by the following UUID(s):
     * <ul>
     * <li>072e7737-e22e-36b5-89d2-4815f0529c63
     * </ul>
     */
    public static final Concept HAS_DOSE_FORM = Concept.make("Has Dose Form", UUID.fromString("072e7737-e22e-36b5-89d2-4815f0529c63"));

    /**
     * Java binding for the concept described as Laterality and identified by the following UUID(s):
     * <ul>
     * <li>26ca4590-bbe5-327c-a40a-ba56dc86996b
     * </ul>
     */
    public static final Concept LATERALITY = Concept.make("Laterality", UUID.fromString("26ca4590-bbe5-327c-a40a-ba56dc86996b"));

    /**
     * Java binding for the concept described as Premarket Exempt and identified by the following UUID(s):
     * <ul>
     * <li>78cbd04a-09a4-4aaf-b830-3f1967a079de
     * </ul>
     */
    public static final Concept PREMARKET_EXEMPT = Concept.make("Premarket Exempt", UUID.fromString("78cbd04a-09a4-4aaf-b830-3f1967a079de"));

    /**
     * Java binding for the concept described as Production Identifiers in UDI and identified by the following UUID(s):
     * <ul>
     * <li>66665ae6-516f-49ab-9fe2-22a5a6d76af0
     * </ul>
     */
    public static final Concept PRODUCTION_IDENTIFIERS_IN_UDI = Concept.make("Production Identifiers in UDI", UUID.fromString("66665ae6-516f-49ab-9fe2-22a5a6d76af0"));

    /**
     * Java binding for the concept described as Path and identified by the following UUID(s):
     * <ul>
     * <li>4459d8cf-5a6f-3952-9458-6d64324b27b7
     * </ul>
     */
    public static final Concept PATH = Concept.make("Path", UUID.fromString("4459d8cf-5a6f-3952-9458-6d64324b27b7"));

    /**
     * Java binding for the concept described as Donation ID Number and identified by the following UUID(s):
     * <ul>
     * <li>c85b467b-81c7-40da-ab32-3ef2478de0d0
     * </ul>
     */
    public static final Concept DONATION_ID_NUMBER = Concept.make("Donation ID Number", UUID.fromString("c85b467b-81c7-40da-ab32-3ef2478de0d0"));

    /**
     * Java binding for the concept described as DiGraph and identified by the following UUID(s):
     * <ul>
     * <li>60113dfe-2bad-11eb-adc1-0242ac120002
     * </ul>
     */
    public static final Concept DIGRAPH = Concept.make("DiGraph", UUID.fromString("60113dfe-2bad-11eb-adc1-0242ac120002"));

    /**
     * Java binding for the concept described as Expiration Date and identified by the following UUID(s):
     * <ul>
     * <li>9fc96e05-513a-411a-b7a5-76be648fdf4e
     * </ul>
     */
    public static final Concept EXPIRATION_DATE = Concept.make("Expiration Date", UUID.fromString("9fc96e05-513a-411a-b7a5-76be648fdf4e"));

    /**
     * Java binding for the concept described as Path coordinate properties and identified by the following UUID(s):
     * <ul>
     * <li>ec41e427-f009-5e45-a643-6dc658d63d83
     * </ul>
     */
    public static final Concept PATH_COORDINATE_PROPERTIES = Concept.make("Path coordinate properties", UUID.fromString("ec41e427-f009-5e45-a643-6dc658d63d83"));

    /**
     * Java binding for the concept described as Transitive Feature and identified by the following UUID(s):
     * <ul>
     * <li>53f866d0-fd61-5c85-a16c-150bd619a0ac
     * </ul>
     */
    public static final Concept TRANSITIVE_FEATURE = Concept.make("Transitive Feature", UUID.fromString("53f866d0-fd61-5c85-a16c-150bd619a0ac"));

    /**
     * Java binding for the concept described as Lot Batch and identified by the following UUID(s):
     * <ul>
     * <li>d9dd88b0-951c-4570-ab15-6dc3c4ab0478
     * </ul>
     */
    public static final Concept LOT_BATCH = Concept.make("Lot Batch", UUID.fromString("d9dd88b0-951c-4570-ab15-6dc3c4ab0478"));

    /**
     * Java binding for the concept described as Reflexive Feature and identified by the following UUID(s):
     * <ul>
     * <li>7e779e4a-61ed-5c4a-aacc-03cf524b7c73
     * </ul>
     */
    public static final Concept REFLEXIVE_FEATURE = Concept.make("Reflexive Feature", UUID.fromString("7e779e4a-61ed-5c4a-aacc-03cf524b7c73"));

    /**
     * Java binding for the concept described as Annotation property set and identified by the following UUID(s):
     * <ul>
     * <li>cb9e33de-f82c-495d-89fa-69afecbcd47d
     * </ul>
     */
    public static final Concept ANNOTATION_PROPERTY_SET = Concept.make("Annotation property set", UUID.fromString("cb9e33de-f82c-495d-89fa-69afecbcd47d"));

    /**
     * Java binding for the concept described as Manufacturing Date and identified by the following UUID(s):
     * <ul>
     * <li>fe4c805b-c642-424d-8194-5727c7cfa2d5
     * </ul>
     */
    public static final Concept MANUFACTURING_DATE = Concept.make("Manufacturing Date", UUID.fromString("fe4c805b-c642-424d-8194-5727c7cfa2d5"));

    /**
     * Java binding for the concept described as Data property set and identified by the following UUID(s):
     * <ul>
     * <li>6b8ed642-de72-4aee-953d-42e5db92c0ab
     * </ul>
     */
    public static final Concept DATA_PROPERTY_SET = Concept.make("Data property set", UUID.fromString("6b8ed642-de72-4aee-953d-42e5db92c0ab"));

    /**
     * Java binding for the concept described as Property sequence implication and identified by the following UUID(s):
     * <ul>
     * <li>9a47a5db-42a6-49ee-9083-54bc305a9456
     * </ul>
     */
    public static final Concept PROPERTY_SEQUENCE_IMPLICATION = Concept.make("Property sequence implication", UUID.fromString("9a47a5db-42a6-49ee-9083-54bc305a9456"));

    /**
     * Java binding for the concept described as Serial Number and identified by the following UUID(s):
     * <ul>
     * <li>cc2dcf03-c97c-4cdc-b8f4-729f63159a21
     * </ul>
     */
    public static final Concept SERIAL_NUMBER = Concept.make("Serial Number", UUID.fromString("cc2dcf03-c97c-4cdc-b8f4-729f63159a21"));

    /**
     * Java binding for the concept described as Rx and identified by the following UUID(s):
     * <ul>
     * <li>4ba0b6d9-39d2-4782-a796-58c56aa42c6c
     * </ul>
     */
    public static final Concept RX = Concept.make("Rx", UUID.fromString("4ba0b6d9-39d2-4782-a796-58c56aa42c6c"));

    /**
     * Java binding for the concept described as Single Use and identified by the following UUID(s):
     * <ul>
     * <li>6cfeccfd-401b-4569-b781-5b1b0e9bc2ac
     * </ul>
     */
    public static final Concept SINGLE_USE = Concept.make("Single Use", UUID.fromString("6cfeccfd-401b-4569-b781-5b1b0e9bc2ac"));

    /**
     * Java binding for the concept described as DiTree and identified by the following UUID(s):
     * <ul>
     * <li>32f64fc6-5371-11eb-ae93-0242ac130002
     * </ul>
     */
    public static final Concept DITREE = Concept.make("DiTree", UUID.fromString("32f64fc6-5371-11eb-ae93-0242ac130002"));

    /**
     * Java binding for the concept described as Sterilization Prior To Use and identified by the following UUID(s):
     * <ul>
     * <li>69eda8fa-4ebb-44bb-a0b3-b28d9b0a3ba8
     * </ul>
     */
    public static final Concept STERILIZATION_PRIOR_TO_USE = Concept.make("Sterilization Prior To Use", UUID.fromString("69eda8fa-4ebb-44bb-a0b3-b28d9b0a3ba8"));

    /**
     * Java binding for the concept described as Medical Devices and identified by the following UUID(s):
     * <ul>
     * <li>dfc30a34-a99c-4386-9ced-600a96e67c6d
     * </ul>
     */
    public static final Concept MEDICAL_DEVICES = Concept.make("Medical Devices", UUID.fromString("dfc30a34-a99c-4386-9ced-600a96e67c6d"));

    /**
     * Java binding for the concept described as Anesthesiology and identified by the following UUID(s):
     * <ul>
     * <li>eec10bd1-fcd8-4d8c-936c-645f920bcfba
     * </ul>
     */
    public static final Concept ANESTHESIOLOGY = Concept.make("Anesthesiology", UUID.fromString("eec10bd1-fcd8-4d8c-936c-645f920bcfba"));

    /**
     * Java binding for the concept described as Cardiovascular and identified by the following UUID(s):
     * <ul>
     * <li>97cce489-04fb-47ae-abf4-d0cf4185ff36
     * </ul>
     */
    public static final Concept CARDIOVASCULAR = Concept.make("Cardiovascular", UUID.fromString("97cce489-04fb-47ae-abf4-d0cf4185ff36"));

    /**
     * Java binding for the concept described as Axiom attachment order and identified by the following UUID(s):
     * <ul>
     * <li>abcb0946-20e1-5483-8469-3e8fa0ce20c4
     * </ul>
     */
    public static final Concept AXIOM_ATTACHMENT_ORDER = Concept.make("Axiom attachment order", UUID.fromString("abcb0946-20e1-5483-8469-3e8fa0ce20c4"));

    /**
     * Java binding for the concept described as Clinical Chemistry and identified by the following UUID(s):
     * <ul>
     * <li>0cc27ea9-b441-4e4c-8baf-888d936f304c
     * </ul>
     */
    public static final Concept CLINICAL_CHEMISTRY = Concept.make("Clinical Chemistry", UUID.fromString("0cc27ea9-b441-4e4c-8baf-888d936f304c"));

    /**
     * Java binding for the concept described as Dental and identified by the following UUID(s):
     * <ul>
     * <li>49509c1f-fccf-426b-bddb-302f30ff87ab
     * </ul>
     */
    public static final Concept DENTAL = Concept.make("Dental", UUID.fromString("49509c1f-fccf-426b-bddb-302f30ff87ab"));

    /**
     * Java binding for the concept described as Ear, Nose, & Throat and identified by the following UUID(s):
     * <ul>
     * <li>9ccd764f-d64d-408c-8000-ef2d503154bb
     * </ul>
     */
    public static final Concept EAR_COMMA_NOSE_COMMA__AMPERSAND_THROAT = Concept.make("Ear, Nose, & Throat", UUID.fromString("9ccd764f-d64d-408c-8000-ef2d503154bb"));

    /**
     * Java binding for the concept described as Gastroenterology & Urology and identified by the following UUID(s):
     * <ul>
     * <li>eb743737-eb31-4d23-af77-c5fec133273d
     * </ul>
     */
    public static final Concept GASTROENTEROLOGY_AMPERSAND_UROLOGY = Concept.make("Gastroenterology & Urology", UUID.fromString("eb743737-eb31-4d23-af77-c5fec133273d"));

    /**
     * Java binding for the concept described as General Hospital and identified by the following UUID(s):
     * <ul>
     * <li>822682f2-37e5-4a23-a480-490b71f38104
     * </ul>
     */
    public static final Concept GENERAL_HOSPITAL = Concept.make("General Hospital", UUID.fromString("822682f2-37e5-4a23-a480-490b71f38104"));

    /**
     * Java binding for the concept described as Concept attachment order and identified by the following UUID(s):
     * <ul>
     * <li>6167efcb-50e8-534d-9827-fdd60b02ae00
     * </ul>
     */
    public static final Concept CONCEPT_ATTACHMENT_ORDER = Concept.make("Concept attachment order", UUID.fromString("6167efcb-50e8-534d-9827-fdd60b02ae00"));

    /**
     * Java binding for the concept described as Stated assemblage and identified by the following UUID(s):
     * <ul>
     * <li>cfd2a47e-8169-5e71-9122-d5b73efd990a
     * </ul>
     */
    public static final Concept STATED_ASSEMBLAGE = Concept.make("Stated assemblage", UUID.fromString("cfd2a47e-8169-5e71-9122-d5b73efd990a"));

    /**
     * Java binding for the concept described as Hematology and identified by the following UUID(s):
     * <ul>
     * <li>4f4c13df-dc61-420f-bb13-9f59ab26d6a7
     * </ul>
     */
    public static final Concept HEMATOLOGY = Concept.make("Hematology", UUID.fromString("4f4c13df-dc61-420f-bb13-9f59ab26d6a7"));

    /**
     * Java binding for the concept described as Inferred assemblage and identified by the following UUID(s):
     * <ul>
     * <li>9ecf4d76-4346-5e5d-8316-bdff48a5c154
     * </ul>
     */
    public static final Concept INFERRED_ASSEMBLAGE = Concept.make("Inferred assemblage", UUID.fromString("9ecf4d76-4346-5e5d-8316-bdff48a5c154"));

    /**
     * Java binding for the concept described as Digraph and identified by the following UUID(s):
     * <ul>
     * <li>1cdacc80-0dea-580f-a77b-8a6b273eb673
     * </ul>
     */
    public static final Concept DIGRAPH = Concept.make("Digraph", UUID.fromString("1cdacc80-0dea-580f-a77b-8a6b273eb673"));

    /**
     * Java binding for the concept described as Classifier and identified by the following UUID(s):
     * <ul>
     * <li>4b90e89d-2a0e-5ca3-8ae5-7498d148a9d2
     * </ul>
     */
    public static final Concept CLASSIFIER = Concept.make("Classifier", UUID.fromString("4b90e89d-2a0e-5ca3-8ae5-7498d148a9d2"));

    /**
     * Java binding for the concept described as Immunology and identified by the following UUID(s):
     * <ul>
     * <li>86027a36-ac17-462b-b864-d0e3f5bd9a74
     * </ul>
     */
    public static final Concept IMMUNOLOGY = Concept.make("Immunology", UUID.fromString("86027a36-ac17-462b-b864-d0e3f5bd9a74"));

    /**
     * Java binding for the concept described as Position on path (SOLOR) and identified by the following UUID(s):
     * <ul>
     * <li>31173582-a49d-51c6-813f-f42d0976aaea
     * </ul>
     */
    public static final Concept POSITION_ON_PATH = Concept.make("Position on path (SOLOR)", UUID.fromString("31173582-a49d-51c6-813f-f42d0976aaea"));

    /**
     * Java binding for the concept described as Microbiology and identified by the following UUID(s):
     * <ul>
     * <li>04b2404e-5535-4c11-8e5a-5a7201336199
     * </ul>
     */
    public static final Concept MICROBIOLOGY = Concept.make("Microbiology", UUID.fromString("04b2404e-5535-4c11-8e5a-5a7201336199"));

    /**
     * Java binding for the concept described as Neurology and identified by the following UUID(s):
     * <ul>
     * <li>1f45fa9f-ebcd-41d0-b387-da989066cdbe
     * </ul>
     */
    public static final Concept NEUROLOGY = Concept.make("Neurology", UUID.fromString("1f45fa9f-ebcd-41d0-b387-da989066cdbe"));

    /**
     * Java binding for the concept described as Obstetrics/Gynecology and identified by the following UUID(s):
     * <ul>
     * <li>2f7f306c-0e5a-484c-8e97-59f923bc7f56
     * </ul>
     */
    public static final Concept OBSTETRICS_FORWARDSLASH_GYNECOLOGY = Concept.make("Obstetrics/Gynecology", UUID.fromString("2f7f306c-0e5a-484c-8e97-59f923bc7f56"));

    /**
     * Java binding for the concept described as Ophthalmic and identified by the following UUID(s):
     * <ul>
     * <li>4f38386d-b5d9-46a2-8e82-27f429e925e0
     * </ul>
     */
    public static final Concept OPHTHALMIC = Concept.make("Ophthalmic", UUID.fromString("4f38386d-b5d9-46a2-8e82-27f429e925e0"));

    /**
     * Java binding for the concept described as Description attachment order and identified by the following UUID(s):
     * <ul>
     * <li>69ee3f13-e2ba-5a96-9b91-5eecfad8e587
     * </ul>
     */
    public static final Concept DESCRIPTION_ATTACHMENT_ORDER = Concept.make("Description attachment order", UUID.fromString("69ee3f13-e2ba-5a96-9b91-5eecfad8e587"));

    /**
     * Java binding for the concept described as Orthopedic and identified by the following UUID(s):
     * <ul>
     * <li>114c587a-6bda-4036-99bb-ce76a21fce85
     * </ul>
     */
    public static final Concept ORTHOPEDIC = Concept.make("Orthopedic", UUID.fromString("114c587a-6bda-4036-99bb-ce76a21fce85"));

    /**
     * Java binding for the concept described as NavigationCoordinate/Directed graph and identified by the following UUID(s):
     * <ul>
     * <li>47a787a7-bdce-528d-bfcc-fde1add8d599
     * </ul>
     */
    public static final Concept NAVIGATIONCOORDINATE_FORWARDSLASH_DIRECTED_GRAPH = Concept.make("NavigationCoordinate/Directed graph", UUID.fromString("47a787a7-bdce-528d-bfcc-fde1add8d599"));

    /**
     * Java binding for the concept described as Pathology and identified by the following UUID(s):
     * <ul>
     * <li>e443fd71-842b-458b-adc4-2c9015e212d5
     * </ul>
     */
    public static final Concept PATHOLOGY = Concept.make("Pathology", UUID.fromString("e443fd71-842b-458b-adc4-2c9015e212d5"));
}