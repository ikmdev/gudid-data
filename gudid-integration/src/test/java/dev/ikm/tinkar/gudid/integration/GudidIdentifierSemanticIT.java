package dev.ikm.tinkar.gudid.integration;

import dev.ikm.maven.GudidUtility;
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
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GudidIdentifierSemanticIT extends AbstractIntegrationTest {

    /**
     * Test GudidIdentifier Semantics.
     *
     * @result Reads content from file and validates Concept of Semantics by calling private method assertLine().
     */
    @Test
    public void testGudidIdentifierSemantics() throws IOException {
        String sourceFilePath = "../gudid-pipeline/target/src";
        String errorFile = "target/failsafe-reports/gudid_identifier_not_found.txt";

        String absolutePath = findFilePath(sourceFilePath, "identifiers.txt");
        int notFound = processFile(absolutePath, errorFile);

        assertEquals(0, notFound, "Unable to find " + notFound + " Gudid Identifier semantics for Devices. Details written to " + errorFile);
    }

    @Override
    protected boolean assertLine(String[] columns) {
        String primaryDi = columns[0];

        if (!gudidUtility.isDeviceIncluded(primaryDi)) {
            return true;
        }

    	int deviceIssuingAgencyCount = 0;
    	AtomicInteger innerDeviceIssuingAgencyCount = new AtomicInteger(0);
    	
        if (!columns[3].isEmpty()) {
            deviceIssuingAgencyCount++;
        }
    	
        StateSet stateActive = StateSet.ACTIVE;
        
		PatternEntityVersion latestIdentifierPattern = (PatternEntityVersion) Calculators.Stamp.DevelopmentLatest()
				.latest(TinkarTerm.IDENTIFIER_PATTERN).get();
		
        StampCalculator stampCalcActive = StampCalculatorWithCache
	               .getCalculator(StampCoordinateRecord.make(stateActive, Coordinates.Position.LatestOnDevelopment()));

        UUID conceptUuid = conceptUuidForPrimaryDi(primaryDi);
        
		EntityProxy.Concept concept = EntityProxy.Concept.make(PublicIds.of(conceptUuid));
        
		EntityService.get().forEachSemanticForComponentOfPattern(concept.nid(), TinkarTerm.IDENTIFIER_PATTERN.nid(), semanticEntity -> {
			Latest<SemanticEntityVersion> latestActive = stampCalcActive.latest(semanticEntity);
			
			if (latestActive.isPresent()) {
				if (!columns[3].isEmpty()) {
                    Component component = latestIdentifierPattern.getFieldWithMeaning(TinkarTerm.IDENTIFIER_SOURCE, latestActive.get());
                    String value = latestIdentifierPattern.getFieldWithMeaning(TinkarTerm.IDENTIFIER_VALUE, latestActive.get());
                    if (columns[1].equals(value) && GudidUtility.lookupDeviceIdIssuingAgencyConcept(columns[3]).equals(component)) {
                    	innerDeviceIssuingAgencyCount.addAndGet(1);
                    }
				}
			}
		});
		
        return deviceIssuingAgencyCount == innerDeviceIssuingAgencyCount.get();
    }

}
