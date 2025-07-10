package dev.ikm.tinkar.gudid.integration;

import dev.ikm.tinkar.coordinate.Coordinates;
import dev.ikm.tinkar.coordinate.stamp.StampCoordinateRecord;
import dev.ikm.tinkar.coordinate.stamp.StateSet;
import dev.ikm.tinkar.coordinate.stamp.calculator.Latest;
import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculator;
import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculatorWithCache;
import dev.ikm.tinkar.entity.ConceptRecord;
import dev.ikm.tinkar.entity.ConceptVersionRecord;
import dev.ikm.tinkar.entity.EntityService;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GudidConceptSemanticDevicesIT extends AbstractIntegrationTest {

    /**
     * Test GudidConcepts Semantics.
     *
     * @result Reads content from file and validates Concept of Semantics by calling private method assertLine().
     */
    @Test
    public void testGudidConceptSemanticsDevices() throws IOException {
        String sourceFilePath = "../gudid-origin/target/origin-sources";
        String errorFile = "target/failsafe-reports/gudid_concepts_devices_not_found.txt";

//        String absolutePath = gudIdFileName; //Unable to find 2932991 device.txt semantics. Details written to target/failsafe-reports/gudid_concepts_not_found.txt ==> expected: <0> but was: <2932991>
        String absolutePath = findFilePath(sourceFilePath, "device.txt"); //Unable to find 6987 foiclass.txt semantics. Details written to target/failsafe-reports/gudid_concepts_not_found.txt ==> expected: <0> but was: <6987>
        int notFound = processFile(absolutePath, errorFile);

        assertEquals(0, notFound, "Unable to find " + notFound + " Gudid Concept semantics for devices. Details written to " + errorFile);
    }

    @Override
    protected boolean assertLine(String[] columns) {
        String primaryDi = columns[0];
        UUID conceptUuid = conceptUuidForPrimaryDi(primaryDi);
        StateSet stateActive = StateSet.ACTIVE;
        StampCalculator stampCalcActive = StampCalculatorWithCache
                .getCalculator(StampCoordinateRecord.make(stateActive, Coordinates.Position.LatestOnDevelopment()));
        ConceptRecord entity = EntityService.get().getEntityFast(conceptUuid);
        Latest<ConceptVersionRecord> latest = stampCalcActive.latest(entity);
        return latest.isPresent();
    }

}
