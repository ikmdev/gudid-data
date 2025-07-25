package dev.ikm.maven;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.common.util.uuid.UuidT5Generator;
import dev.ikm.tinkar.composer.Composer;
import dev.ikm.tinkar.composer.Session;
import dev.ikm.tinkar.composer.assembler.ConceptAssembler;
import dev.ikm.tinkar.composer.assembler.SemanticAssembler;
import dev.ikm.tinkar.composer.template.DefinitionConsumer;
import dev.ikm.tinkar.composer.template.FullyQualifiedName;
import dev.ikm.tinkar.composer.template.Identifier;
import dev.ikm.tinkar.composer.template.StatedAxiom;
import dev.ikm.tinkar.terms.EntityProxy;
import dev.ikm.tinkar.terms.State;
import dev.ikm.tinkar.terms.TinkarTerm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Stream;

public class GmdnTermsTransformer extends AbstractTransformer {
    private static final Logger LOG = LoggerFactory.getLogger(GmdnTermsTransformer.class.getSimpleName());

    private static final int PRIMARY_DI = 0;
    private static final int GMDN_PT_NAME = 1;
    private static final int GMDN_PT_DEFINITION = 2;
    private static final int GMDN_CODE = 3;
    private static final int GMDN_CODE_STATUS = 4;
    private static final int IMPLANTABLE = 5;

    private final AtomicInteger identiferCount = new AtomicInteger(0);
    private final LongAdder conceptCount = new LongAdder();
    private String previousGmdnCode = null;

    public GmdnTermsTransformer(GudidUtility gudidUtility) {
        super(gudidUtility);
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

        try (Stream<String> lines = Files.lines(inputFile.toPath())) {
            lines.skip(1) //skip first line, i.e. header line
                    .map(row -> row.split("\\|"))
                    .filter(data -> gudidUtility.isDeviceIncluded(data[PRIMARY_DI]))
                    .sorted(Comparator.comparing(data -> data[GMDN_CODE]))
                    .forEach(data -> {
                        State status = "Active".equals(data[GMDN_CODE_STATUS]) ? State.ACTIVE : State.INACTIVE;
                        String gmdnCode = data[GMDN_CODE];

                        Session session = composer.open(status, GudidTerm.GUDID_AUTHOR,
                                gudidUtility.getModuleConcept(), TinkarTerm.DEVELOPMENT_PATH);

                        if (!gmdnCode.equals(previousGmdnCode)) {
                            createGmdnConcept(session, data);
                            conceptCount.increment();
                        }

                        createDeviceIdentifierSemantic(session, data);

                        if (identiferCount.incrementAndGet() % 100000 == 0) {
                            LOG.info("identiferCount: {}", identiferCount.get());
                        }

                        previousGmdnCode = gmdnCode;

                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            LOG.info("conceptCount: {} identifierCount: {}", conceptCount, identiferCount);
        }
    }

    private EntityProxy.Concept createGmdnConcept(Session session, String[] data) {
        EntityProxy.Concept concept = EntityProxy.Concept.make(PublicIds.of(UuidT5Generator.get(namespace, "GMDN_" + data[GMDN_CODE])));
        session.compose((ConceptAssembler conceptAssembler) -> conceptAssembler
                .concept(concept)
                .attach((Identifier identifier) -> identifier
                        .source(TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER)
                        .identifier(concept.asUuidArray()[0].toString())
                )
                .attach((FullyQualifiedName fqn) -> fqn
                        .language(TinkarTerm.ENGLISH_LANGUAGE)
                        .text(data[GMDN_PT_NAME])
                        .caseSignificance(TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE)
                )
                .attach((DefinitionConsumer) definition -> definition.language(TinkarTerm.ENGLISH_LANGUAGE)
                        .text(data[GMDN_PT_DEFINITION])
                        .caseSignificance(TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE)
                )
                .attach((Identifier identifier) -> identifier
                        .source(GudidTerm.GUDID_GMDN_TERMS)
                        .identifier(data[GMDN_CODE])
                )
                .attach((StatedAxiom statedAxiom) -> statedAxiom
                        .isA(GudidTerm.GUDID_GMDN_TERMS)
                )
        );
        return concept;
    }

    private void createDeviceIdentifierSemantic(Session session, String[] data) {
        EntityProxy.Semantic semantic = EntityProxy.Semantic.make(PublicIds.of(UuidT5Generator.get(namespace, data[PRIMARY_DI] + "_GMDN_" + data[GMDN_CODE])));
        EntityProxy.Concept deviceConcept = EntityProxy.Concept.make(PublicIds.of(UuidT5Generator.get(namespace, data[PRIMARY_DI])));
        session.compose((SemanticAssembler assembler) -> assembler
                .semantic(semantic)
                .pattern(GudidTerm.GUDID_GMDN_TERMS_PATTERN)
                .reference(deviceConcept)
                .fieldValues(fieldValues -> fieldValues
                        .withAll(List.of(data))
                ));
    }

}
