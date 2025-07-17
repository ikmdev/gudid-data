package dev.ikm.tinkar.gudid.integration;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.coordinate.Calculators;
import dev.ikm.tinkar.coordinate.Coordinates;
import dev.ikm.tinkar.coordinate.stamp.StampCoordinateRecord;
import dev.ikm.tinkar.coordinate.stamp.StateSet;
import dev.ikm.tinkar.coordinate.stamp.calculator.Latest;
import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculator;
import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculatorWithCache;
import dev.ikm.tinkar.entity.EntityService;
import dev.ikm.tinkar.entity.PatternEntityVersion;
import dev.ikm.tinkar.entity.SemanticEntityVersion;
import dev.ikm.tinkar.entity.graph.DiTreeEntity;
import dev.ikm.tinkar.entity.graph.EntityVertex;
import dev.ikm.tinkar.terms.EntityProxy;
import dev.ikm.tinkar.terms.TinkarTerm;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GudidStatedDefinitionFoiClassSemanticIT extends AbstractIntegrationTest {

    /**
     * Test GudidConcepts Semantics.
     *
     * @result Reads content from file and validates Axiom of Semantics by calling
     * private method assertLine().
     */
    @Test
    public void testGudidStatedDefinitionFoiClassSemantics() throws IOException {
        String sourceFilePath = "../gudid-origin/target/origin-sources";
        String errorFile = "target/failsafe-reports/gudid_foi_axiom_not_found.txt";

        String absolutePath = findFilePath(sourceFilePath, "foiclass.txt");

        int notFound = processFile(absolutePath, errorFile);

        assertEquals(0, notFound,
                "Unable to find " + notFound + " Gudid Axiom semantics for Devices. Details written to " + errorFile);
    }

    @Override
    protected boolean assertLine(String[] columns) {
        AtomicBoolean matched = new AtomicBoolean(true);
        AtomicInteger innerCount = new AtomicInteger(0);

        String medicalSpecialtyColumn = columns[1];
        String productCodeColumn = columns[2];

        if (!gudidUtility.isMedicalSpecialtyIncluded(medicalSpecialtyColumn, productCodeColumn)) {
            return true;
        }

        StateSet stateActive = StateSet.ACTIVE;

        PatternEntityVersion latestAxiomPattern = (PatternEntityVersion) Calculators.Stamp.DevelopmentLatest()
                .latest(TinkarTerm.EL_PLUS_PLUS_STATED_AXIOMS_PATTERN).get();

        StampCalculator stampCalcActive = StampCalculatorWithCache
                .getCalculator(StampCoordinateRecord.make(stateActive, Coordinates.Position.LatestOnDevelopment()));

        UUID conceptUuid = conceptUuid(productCodeColumn);

        EntityProxy.Concept concept = EntityProxy.Concept.make(PublicIds.of(conceptUuid));

        // Get parent concept based on medical specialty
        EntityProxy.Concept parentConcept = gudidUtility.getMedicalSpecialtyParentConcept(medicalSpecialtyColumn);

        EntityService.get().forEachSemanticForComponentOfPattern(concept.nid(),
                TinkarTerm.EL_PLUS_PLUS_STATED_AXIOMS_PATTERN.nid(), semanticEntity -> {
                    Latest<SemanticEntityVersion> latestActive = stampCalcActive.latest(semanticEntity);

                    if (latestActive.isPresent()) {
                        innerCount.incrementAndGet();
                        if (parentConcept != null) {
                            DiTreeEntity fieldValue = latestAxiomPattern.getFieldWithMeaning(
                                    TinkarTerm.EL_PLUS_PLUS_STATED_TERMINOLOGICAL_AXIOMS, latestActive.get());

                            EntityVertex vertex = fieldValue.firstVertexWithMeaning(TinkarTerm.CONCEPT_REFERENCE).get();
                            if (!vertex.properties().containsValue(parentConcept)) {
                                matched.set(false);
                            }
                        } else {
                            matched.set(false);
                        }
                    }
                });

        return matched.get() && innerCount.get() == 1;
    }

}
