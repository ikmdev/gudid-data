package dev.ikm.maven;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.common.util.uuid.UuidT5Generator;
import dev.ikm.tinkar.composer.Composer;
import dev.ikm.tinkar.composer.Session;
import dev.ikm.tinkar.composer.assembler.ConceptAssembler;
import dev.ikm.tinkar.composer.assembler.SemanticAssembler;
import dev.ikm.tinkar.composer.template.Identifier;
import dev.ikm.tinkar.terms.EntityProxy;
import dev.ikm.tinkar.terms.State;
import dev.ikm.tinkar.terms.TinkarTerm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static dev.ikm.tinkar.terms.TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE;

public class DeviceTransformer extends AbstractTransformer {
    private static final Logger LOG = LoggerFactory.getLogger(DeviceTransformer.class.getSimpleName());

    private static final int PRIMARY_DI = 0;
    private static final int PUBLIC_DEVICE_RECORD_KEY = 1;
    private static final int DEVICE_RECORD_STATUS = 3;
    private static final int PUBLIC_VERSION_DATE = 5;
    private static final int BRAND_NAME = 9;
    private static final int VERSION_MODEL_NUMBER = 10;

    public DeviceTransformer(UUID namespace) {
        super(namespace);
    }

    /**
     * transforms concept file into entity
     *
     * @param inputFile concept input txt file
     */
    @Override
    public void transform(File inputFile, Composer composer) {
        if (inputFile == null || !inputFile.exists() || !inputFile.isFile()) {
            throw new RuntimeException("Concept input file is either null or invalid.");
        }
        EntityProxy.Concept author = gudidUtility.getUserConcept();
        EntityProxy.Concept path = TinkarTerm.DEVELOPMENT_PATH;
        EntityProxy.Concept module = gudidUtility.getModuleConcept();

        AtomicInteger conceptCount = new AtomicInteger();
        try (Stream<String> lines = Files.lines(inputFile.toPath())) {
            lines.skip(1) //skip first line, i.e. header line
                    .map(row -> row.split("\\|"))
                    .forEach(data -> {
                        State status = "Published".equals(data[DEVICE_RECORD_STATUS]) ? State.ACTIVE : State.INACTIVE;
                        long time = LocalDate.parse(data[PUBLIC_VERSION_DATE]).atStartOfDay().atZone(ZoneOffset.UTC).toInstant().toEpochMilli();
                        EntityProxy.Concept concept = EntityProxy.Concept.make(PublicIds.of(UuidT5Generator.get(namespace, data[PRIMARY_DI])));

                        Session session = composer.open(status, time, author, module, path);

                        createConcept(session, concept, data[PUBLIC_DEVICE_RECORD_KEY]);
                        createDescriptionSemantic(session, concept, data[BRAND_NAME] + " " + data[VERSION_MODEL_NUMBER], TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE);

                        if (conceptCount.incrementAndGet() % 1000 == 0) {
                            LOG.info("committed concepts: {}", conceptCount.get());
                            composer.commitSession(session);
                        }
                    });

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            LOG.info("committed concepts: {}", conceptCount.get());
        }
    }

    private void createConcept(Session session, EntityProxy.Concept concept, String publicDeviceRecordKey) {
        session.compose((ConceptAssembler conceptAssembler) -> conceptAssembler
                .concept(concept)
                .attach((Identifier identifier) -> identifier
                        .source(TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER)
                        .identifier(concept.asUuidArray()[0].toString())
                )
                .attach((Identifier identifier) -> identifier
                        .source(EntityProxy.Concept.make("Public Device Record Key", UuidT5Generator.get(namespace, publicDeviceRecordKey)))
                        .identifier(publicDeviceRecordKey)
                )
        );
    }

    private void createDescriptionSemantic(Session session, EntityProxy.Concept concept, String description, EntityProxy.Concept descriptionType) {
        String typeStr = descriptionType.equals(FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE) ? "FQN" :
                descriptionType.equals(TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE) ? "Regular" : "Definition";

        EntityProxy.Semantic semantic = EntityProxy.Semantic.make(
                PublicIds.of(UuidT5Generator.get(namespace, concept.publicId().asUuidArray()[0] + description + typeStr + "DESC")));

        try {
            session.compose((SemanticAssembler semanticAssembler) -> semanticAssembler
                    .semantic(semantic)
                    .pattern(TinkarTerm.DESCRIPTION_PATTERN)
                    .reference(concept)
                    .fieldValues(fieldValues -> fieldValues
                            .with(TinkarTerm.ENGLISH_LANGUAGE)
                            .with(description)
                            .with(TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE)
                            .with(descriptionType)
                    ));
        } catch (Exception e) {
            LOG.error("Error creating " + typeStr + " description semantic for concept: " + concept, e);
        }
    }


}
