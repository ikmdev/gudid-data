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
import dev.ikm.tinkar.entity.Entity;
import dev.ikm.tinkar.entity.EntityService;
import dev.ikm.tinkar.entity.EntityVersion;
import dev.ikm.tinkar.terms.EntityProxy;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GudidGmdnTermsSemanticIT extends AbstractIntegrationTest {
    String previousGmdnCode = "";

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
        String gmdnName = columns[1];
        String gmdnDef = columns[2];
        String gmdnCode = columns[3];
        String gmdnCodeStatus = columns[4];

        if (!gudidUtility.isDeviceIncluded(primaryDi)) {
            return true;
        }

        if (previousGmdnCode.equals(gmdnCode)) { //If current gmdnCode is equals to previous line(s), no need to create Concept then return!
            return true;
        }
        previousGmdnCode = gmdnCode; //Assigns to previousGmdnCode

        StateSet state = "Active".equals(gmdnCodeStatus) ? StateSet.ACTIVE : StateSet.INACTIVE;
        StampCalculator stampCalc = StampCalculatorWithCache
                .getCalculator(StampCoordinateRecord.make(state, Coordinates.Position.LatestOnDevelopment()));
//        PatternEntityVersion latestIdentifierPattern = (PatternEntityVersion) Calculators.Stamp.DevelopmentLatest().latest(TinkarTerm.IDENTIFIER_PATTERN).get();

        UUID conceptUuid = conceptUuidForGMDN(gmdnCode);
//        Optional<Entity<EntityVersion>> entity = EntityService.get().getEntity(PublicIds.of(conceptUuid));
//        return entity.isPresent();

        EntityProxy.Concept concept = EntityProxy.Concept.make(PublicIds.of(conceptUuid));
        ConceptRecord entity = EntityService.get().getEntityFast(concept);
        Latest<ConceptVersionRecord> latest = stampCalc.latest(entity);

//        if (latest.isPresent()) {
//            System.out.println("latest.isPresent(): " + primaryDi +" - "+ gmdnCode +" - " + gmdnCodeStatus);
//        }
        return latest.isPresent();

    }

}
