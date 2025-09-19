package dev.ikm.tinkar.gudid.integration;

import dev.ikm.maven.GudidTerm;
import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.component.Component;
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
import dev.ikm.tinkar.terms.EntityProxy;
import dev.ikm.tinkar.terms.TinkarTerm;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GudidPremarketSubmissionSemanticIT extends AbstractIntegrationTest {

    /**
     * Test GudidPremarketSubmission Semantics.
     *
     * @result Reads content from file and validates Concept of Semantics by calling private method assertLine().
     */
    @Test
    public void testGudidPremarketSubmissionSemantics() throws IOException {
        String sourceFilePath = "../gudid-pipeline/target/src";
        String errorFile = "target/failsafe-reports/gudid_premarket_submission_not_found.txt";

        String absolutePath = findFilePath(sourceFilePath, "premarketSubmissions.txt");
        int notFound = processFile(absolutePath, errorFile);

        assertEquals(0, notFound, "Unable to find " + notFound + " Gudid premarterSubmission semantics. Details written to " + errorFile);
    }

    @Override
    protected boolean assertLine(String[] columns) {
        String primaryDi = columns[0];
        String submissionNumber = columns[1];
        String supplementNumber = columns[2];

        if (!gudidUtility.isDeviceIncluded(primaryDi)) {
            return true;
        }

        StateSet stateActive = StateSet.ACTIVE;
        StampCalculator stampCalcActive = StampCalculatorWithCache
                .getCalculator(StampCoordinateRecord.make(stateActive, Coordinates.Position.LatestOnDevelopment()));
        PatternEntityVersion latestIdentifierPattern = (PatternEntityVersion) Calculators.Stamp.DevelopmentLatest().latest(TinkarTerm.IDENTIFIER_PATTERN).get();

        UUID conceptUuid = conceptUuidForPrimaryDi(primaryDi);
        EntityProxy.Concept concept = EntityProxy.Concept.make(PublicIds.of(conceptUuid));

        AtomicBoolean submissionNumberValue = new AtomicBoolean(false);

        EntityService.get().forEachSemanticForComponentOfPattern(concept.nid(), TinkarTerm.IDENTIFIER_PATTERN.nid(), semanticEntity -> {
            Latest<SemanticEntityVersion> latestActive = stampCalcActive.latest(semanticEntity);
			
			if (latestActive.isPresent()) {
                Component component = latestIdentifierPattern.getFieldWithMeaning(TinkarTerm.IDENTIFIER_SOURCE, latestActive.get());
                String value = latestIdentifierPattern.getFieldWithMeaning(TinkarTerm.IDENTIFIER_VALUE, latestActive.get());
                if (GudidTerm.GUDID_FDA_PREMARKET_SUBMISSION_NUMBER.equals(component)
                        && submissionNumber.equals(value)) {
                    submissionNumberValue.set(true);
                }
			}
		});
		
        return submissionNumberValue.get();
    }

}
