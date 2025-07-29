package dev.ikm.maven;

import dev.ikm.tinkar.common.id.IntIdSet;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.common.id.impl.IntIdSetArray;
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
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GmdnTermsTransformer extends AbstractTransformer {
    private static final Logger LOG = LoggerFactory.getLogger(GmdnTermsTransformer.class.getSimpleName());

    private static final int PRIMARY_DI = 0;
    private static final int GMDN_PT_NAME = 1;
    private static final int GMDN_PT_DEFINITION = 2;
    private static final int GMDN_CODE = 3;
    private static final int GMDN_CODE_STATUS = 4;

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

        AtomicInteger conceptCount = new AtomicInteger();

        try (Stream<String> lines = Files.lines(inputFile.toPath())) {
            Map<GmdnTerm, Set<GmdnDevice>> gmdnDeviceMap = lines
                    .skip(1) //skip first line, i.e. header line
                    .map(row -> row.split("\\|"))
                    .filter(data -> gudidUtility.isDeviceIncluded(data[PRIMARY_DI]))
                    .sorted(Comparator.comparing(data -> data[GMDN_CODE]))
                    .collect(Collectors.groupingBy(GmdnTerm::fromCsv, Collectors.mapping(GmdnDevice::fromCsv, Collectors.toSet())));

            gmdnDeviceMap.forEach((gmdnTerm, devices) -> {

                boolean isAllDevicesInactive = devices.stream().map(GmdnDevice::state).allMatch(state -> state == State.INACTIVE);
                State status = isAllDevicesInactive ? State.INACTIVE : State.ACTIVE;

                Session session = composer.open(status, GudidTerm.GUDID_AUTHOR,
                        gudidUtility.getModuleConcept(), TinkarTerm.DEVELOPMENT_PATH);

                EntityProxy.Concept concept = createGmdnConcept(session, gmdnTerm);

                IntIdSet deviceNids = IntIdSetArray.newIntIdSet(devices.stream()
                        .mapToInt(device -> device.nid(namespace)).toArray());

                createDevicesIdentifierSemantic(session, gmdnTerm.gmdnCode(), concept, deviceNids);

                if (conceptCount.incrementAndGet() % 10000 == 0) {
                    LOG.debug("conceptCount: {} componentsInSessionCount: {}", conceptCount.get(), session.componentsInSessionCount());
                }
            });

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            LOG.info("conceptCount: {}", conceptCount.get());
        }
    }

    private EntityProxy.Concept createGmdnConcept(Session session, GmdnTerm data) {
        EntityProxy.Concept concept = EntityProxy.Concept.make(PublicIds.of(UuidT5Generator.get(namespace, "GMDN_" + data.gmdnCode())));
        session.compose((ConceptAssembler conceptAssembler) -> conceptAssembler
                .concept(concept)
                .attach((Identifier identifier) -> identifier
                        .source(TinkarTerm.UNIVERSALLY_UNIQUE_IDENTIFIER)
                        .identifier(concept.asUuidArray()[0].toString())
                )
                .attach((FullyQualifiedName fqn) -> fqn
                        .language(TinkarTerm.ENGLISH_LANGUAGE)
                        .text(data.gmdnPTName())
                        .caseSignificance(TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE)
                )
                .attach((DefinitionConsumer) definition -> definition.language(TinkarTerm.ENGLISH_LANGUAGE)
                        .text(data.gmdnPTDefinition())
                        .caseSignificance(TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE)
                )
                .attach((Identifier identifier) -> identifier
                        .source(GudidTerm.GUDID_GMDN_TERMS)
                        .identifier(data.gmdnCode())
                )
                .attach((StatedAxiom statedAxiom) -> statedAxiom
                        .isA(GudidTerm.GUDID_GMDN_TERMS)
                )
        );
        return concept;
    }

    private void createDevicesIdentifierSemantic(Session session, String gmdnCode, EntityProxy.Concept gmdnConcept, IntIdSet deviceNids) {
        EntityProxy.Semantic semantic = EntityProxy.Semantic.make(PublicIds.of(UuidT5Generator.get(namespace, "GMDN_IDENTIFIER_" + gmdnCode)));
        session.compose((SemanticAssembler assembler) -> assembler
                .semantic(semantic)
                .pattern(GudidTerm.GUDID_GMDN_TERMS_PATTERN)
                .reference(gmdnConcept)
                .fieldValues(fieldValues -> fieldValues
                        .with(deviceNids)
                ));
    }

    record GmdnTerm(String gmdnPTName, String gmdnPTDefinition, String gmdnCode, String gmdnCodeStatus) {
        static GmdnTerm fromCsv(String[] data) {
            return new GmdnTerm(data[GMDN_PT_NAME], data[GMDN_PT_DEFINITION], data[GMDN_CODE], data[GMDN_CODE_STATUS]);
        }
    }

    record GmdnDevice(String primaryDI, String gmdnCodeStatus) {
        static GmdnDevice fromCsv(String[] data) {
            return new GmdnDevice(data[PRIMARY_DI], data[GMDN_CODE_STATUS]);
        }

        int nid(UUID namespace) {
            return EntityProxy.Concept.make(PublicIds.of(UuidT5Generator.get(namespace, primaryDI))).nid();
        }

        State state() {
            return "Active".equals(gmdnCodeStatus) ? State.ACTIVE : State.INACTIVE;
        }
    }

}
