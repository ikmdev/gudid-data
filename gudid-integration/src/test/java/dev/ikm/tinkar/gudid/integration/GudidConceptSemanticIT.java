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

public class GudidConceptSemanticIT extends AbstractIntegrationTest {

    /**
     * Test GudidConcepts Semantics.
     *
     * @result Reads content from file and validates Concept of Semantics by calling private method assertLine().
     */
    @Test
    public void testGudidConceptSemantics() throws IOException {
        String sourceFilePath = "../gudid-origin/target/origin-sources";
        String errorFile = "target/failsafe-reports/gudid_concepts_not_found.txt";

        String absolutePath = findFilePath(sourceFilePath, "foiclass.txt");
        int notFound = processFile(absolutePath, errorFile);

        assertEquals(0, notFound, "Unable to find " + notFound + " Gudid Concept semantics. Details written to " + errorFile);
    }

    @Override
    protected boolean assertLine(String[] columns) {
        String medicalSpecialty = columns[1];
        String productCode = columns[2];
        if (!gudidUtility.isMedicalSpecialtyIncluded(medicalSpecialty, productCode)) {
            return true;
        }
        UUID conceptUuid = conceptUuidForProductCode(productCode);
        StateSet stateActive = StateSet.ACTIVE;
        StampCalculator stampCalcActive = StampCalculatorWithCache
                .getCalculator(StampCoordinateRecord.make(stateActive, Coordinates.Position.LatestOnDevelopment()));
        ConceptRecord entity = EntityService.get().getEntityFast(conceptUuid);
        Latest<ConceptVersionRecord> latest = stampCalcActive.latest(entity);
        return latest.isPresent();
    }

}
