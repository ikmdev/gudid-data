package dev.ikm.tinkar.gudid.integration;

import dev.ikm.maven.GudidTerm;
import dev.ikm.tinkar.common.id.IntIdSet;
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
import dev.ikm.tinkar.terms.EntityProxy;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GudidGmdnTermsDeviceIdSemanticIT extends AbstractIntegrationTest {
    /**
     * Test GudidGmdnTermDeviceId Semantics.
     *
     * @result Reads content from file and validates Concept of Semantics by calling private method assertLine().
     */
    @Test
    public void testGudidGmdnTermDeviceIdSemantics() throws IOException {
        String sourceFilePath = "../gudid-origin/target/origin-sources";
        String errorFile = "target/failsafe-reports/gudid_gmdn_terms_device_id_not_found.txt";

        String absolutePath = findFilePath(sourceFilePath, "gmdnTerms.txt");
        int notFound = processFile(absolutePath, errorFile);

        assertEquals(0, notFound, "Unable to find " + notFound + " Gudid gmdnTerms semantics. Details written to " + errorFile);
    }

    @Override
    protected boolean assertLine(String[] columns) {
        String primaryDi = columns[0];
        String gmdnCode = columns[3];
        String gmdnCodeStatus = columns[4];

        if (!gudidUtility.isDeviceIncluded(primaryDi)) {
            return true;
        }

        StateSet state = "Active".equals(gmdnCodeStatus) ? StateSet.ACTIVE : StateSet.INACTIVE;
        StampCalculator stampCalc = StampCalculatorWithCache
                .getCalculator(StampCoordinateRecord.make(state, Coordinates.Position.LatestOnDevelopment()));

        UUID conceptUuid = conceptUuidForGMDN(gmdnCode);
        UUID deviceConceptUuid = conceptUuidForPrimaryDi(primaryDi);
        EntityProxy.Concept concept = EntityProxy.Concept.make(PublicIds.of(conceptUuid));
        EntityProxy.Concept deviceConcept = EntityProxy.Concept.make(PublicIds.of(deviceConceptUuid));

        PatternEntityVersion latestDeviceIdPattern = (PatternEntityVersion) Calculators.Stamp.DevelopmentLatest().latest(GudidTerm.GUDID_GMDN_TERMS_PATTERN).get();
        AtomicBoolean deviceIdValue = new AtomicBoolean(false);

        EntityService.get().forEachSemanticForComponentOfPattern(deviceConcept.nid(), GudidTerm.GUDID_GMDN_TERMS_PATTERN.nid(), semanticEntity -> {
            Latest<SemanticEntityVersion> latest = stampCalc.latest(semanticEntity);

            if (latest.isPresent()) {
                IntIdSet deviceConceptNids = latestDeviceIdPattern.getFieldWithMeaning(GudidTerm.GUDID_GMDN_TERMS, latest.get());
                if (deviceConceptNids.size()==1 && deviceConceptNids.toArray()[0]==concept.nid()) {
                    deviceIdValue.set(true);
                }
            }

        });

        return deviceIdValue.get();
    }
}
