package dev.ikm.tinkar.gudid.integration;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.coordinate.Coordinates;
import dev.ikm.tinkar.coordinate.stamp.StampCoordinateRecord;
import dev.ikm.tinkar.coordinate.stamp.StateSet;
import dev.ikm.tinkar.coordinate.stamp.calculator.Latest;
import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculator;
import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculatorWithCache;
import dev.ikm.tinkar.entity.ConceptRecord;
import dev.ikm.tinkar.entity.ConceptVersionRecord;
import dev.ikm.tinkar.entity.EntityService;
import dev.ikm.tinkar.terms.EntityProxy;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GudidGmdnTermsSemanticIT extends AbstractIntegrationTest {
    /**
     * Test GudidGmdnTerm Semantics.
     *
     * @result Reads content from file and validates Concept of Semantics by calling private method assertLine().
     */
    @Test
    public void testGudidGmdnTermSemantics() throws IOException {
        String sourceFilePath = "../gudid-origin/target/origin-sources";
        String errorFile = "target/failsafe-reports/gudid_gmdn_terms_not_found.txt";

        String absolutePath = findFilePath(sourceFilePath, "gmdnTerms.txt");
        int notFound = processFile(absolutePath, errorFile);

        assertEquals(0, notFound, "Unable to find " + notFound + " Gudid gmdnTerms semantics. Details written to " + errorFile);
    }

    @Override
    protected boolean assertLine(String[] columns) {
        String primaryDi = columns[0];
        String gmdnCode = columns[3];

        if (!gudidUtility.isDeviceIncluded(primaryDi)) {
            return true;
        }

        StateSet stateActive = StateSet.ACTIVE;
        StampCalculator stampCalc = StampCalculatorWithCache
                .getCalculator(StampCoordinateRecord.make(stateActive, Coordinates.Position.LatestOnDevelopment()));

        UUID conceptUuid = conceptUuidForGMDN(gmdnCode);
        EntityProxy.Concept concept = EntityProxy.Concept.make(PublicIds.of(conceptUuid));
        ConceptRecord entity = EntityService.get().getEntityFast(concept);
        Latest<ConceptVersionRecord> latest = stampCalc.latest(entity);

        return latest.isPresent();
    }

}
