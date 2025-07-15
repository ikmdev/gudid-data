package dev.ikm.maven;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.common.util.uuid.UuidT5Generator;
import dev.ikm.tinkar.composer.Composer;
import dev.ikm.tinkar.composer.Session;
import dev.ikm.tinkar.composer.assembler.SemanticAssembler;
import dev.ikm.tinkar.terms.EntityProxy;
import dev.ikm.tinkar.terms.State;
import dev.ikm.tinkar.terms.TinkarTerm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class GudidIdentifierTransformer extends AbstractTransformer {
    private static final Logger LOG = LoggerFactory.getLogger(GudidIdentifierTransformer.class.getSimpleName());

    private static final int PRIMARY_DI = 0;
    private static final int DEVICE_ID = 1;
    private static final int DEVICE_ID_ISSUING_AGENCY = 3;

    public GudidIdentifierTransformer(GudidUtility gudidUtility) {
        super(gudidUtility);
    }

    @Override
    public void transform(File inputFile, Composer composer) {
        if (inputFile == null || !inputFile.exists() || !inputFile.isFile()) {
            throw new RuntimeException("Concept input file is either null or invalid.");
        }
        Session session = composer.open(State.ACTIVE, gudidUtility.getAuthorConcept(),
                gudidUtility.getModuleConcept(), TinkarTerm.DEVELOPMENT_PATH);

        AtomicInteger identiferCount = new AtomicInteger();
        try (Stream<String> lines = Files.lines(inputFile.toPath())) {
            lines.skip(1) //skip first line, i.e. header line
                    .map(row -> row.split("\\|"))
                    .filter(data -> gudidUtility.isDeviceIncluded(data[PRIMARY_DI]))
                    .forEach(data -> {
                        EntityProxy.Concept concept = EntityProxy.Concept.make(PublicIds.of(UuidT5Generator.get(namespace, data[PRIMARY_DI])));

                        createIdentifierSemantic(session, concept, data[DEVICE_ID_ISSUING_AGENCY], data[DEVICE_ID]);

                        if (identiferCount.incrementAndGet() % 1000 == 0) {
                            LOG.debug("identiferCount: {} componentsInSessionCount: {}", identiferCount.get(), session.componentsInSessionCount());
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            LOG.info("identiferCount: {}", identiferCount.get());
        }
    }

    private void createIdentifierSemantic(Session session, EntityProxy.Concept concept, String deviceIdIssuingAgency, String deviceId) {
        try {
            EntityProxy.Semantic semantic = EntityProxy.Semantic.make(
                    PublicIds.of(UuidT5Generator.get(namespace, concept.publicId().asUuidArray()[0] + deviceId)));

            session.compose((SemanticAssembler assembler) -> assembler
                    .semantic(semantic)
                    .pattern(TinkarTerm.IDENTIFIER_PATTERN)
                    .reference(concept)
                    .fieldValues(fieldValues -> fieldValues
                            .with(GudidUtility.lookupDeviceIdIssuingAgencyConcept(deviceIdIssuingAgency))
                            .with(deviceId)
                    ));
        } catch (Exception e) {
            LOG.error("Error creating identifier semantic for concept: " + concept, e);
        }
    }

}
