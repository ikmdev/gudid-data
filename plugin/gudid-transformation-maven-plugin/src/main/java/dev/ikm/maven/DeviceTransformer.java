package dev.ikm.maven;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.common.util.time.DateTimeUtil;
import dev.ikm.tinkar.common.util.uuid.UuidT5Generator;
import dev.ikm.tinkar.composer.Composer;
import dev.ikm.tinkar.composer.Session;
import dev.ikm.tinkar.composer.assembler.ConceptAssembler;
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
import java.util.stream.Stream;

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

        try (Stream<String> lines = Files.lines(inputFile.toPath())) {
            lines.skip(1) //skip first line, i.e. header line
                    .limit(10000)
                    .map(row -> row.split("\\|"))
                    .forEach(data -> {
                        State status = "Published".equals(data[DEVICE_RECORD_STATUS]) ? State.ACTIVE : State.INACTIVE;
                        long time = LocalDate.parse(data[PUBLIC_VERSION_DATE]).atStartOfDay().atZone(ZoneOffset.UTC).toInstant().toEpochMilli();
                        EntityProxy.Concept concept = EntityProxy.Concept.make(PublicIds.of(UuidT5Generator.get(namespace, data[PUBLIC_DEVICE_RECORD_KEY])));

                        Session session = composer.open(status, time, author, module, path);

                        session.compose((ConceptAssembler conceptAssembler) -> conceptAssembler
                                .concept(concept)
                                .attach((Identifier identifier) -> identifier
                                        .source(TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER)
                                        .identifier(concept.asUuidArray()[0].toString())
                                )
//                                .attach((Identifier identifier) -> identifier
//                                        .source(TinkarTerm.SCTID)
//                                        .identifier(data[ID])
//                                )
                        );
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
