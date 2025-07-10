package dev.ikm.tinkar.gudid.integration;

import dev.ikm.tinkar.common.id.PublicIds;
import dev.ikm.tinkar.component.Component;
import dev.ikm.tinkar.coordinate.Calculators;
import dev.ikm.tinkar.coordinate.Coordinates;
import dev.ikm.tinkar.coordinate.stamp.StampCoordinateRecord;
import dev.ikm.tinkar.coordinate.stamp.StateSet;
import dev.ikm.tinkar.coordinate.stamp.calculator.Latest;
import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculator;
import dev.ikm.tinkar.coordinate.stamp.calculator.StampCalculatorWithCache;
import dev.ikm.tinkar.entity.ConceptRecord;
import dev.ikm.tinkar.entity.ConceptVersionRecord;
import dev.ikm.tinkar.entity.EntityService;
import dev.ikm.tinkar.entity.PatternEntityVersion;
import dev.ikm.tinkar.entity.SemanticEntityVersion;
import dev.ikm.tinkar.terms.EntityProxy;
import dev.ikm.tinkar.terms.TinkarTerm;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static dev.ikm.tinkar.terms.TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE;
import static dev.ikm.tinkar.terms.TinkarTerm.FULLY_QUALIFIED_NAME_DESCRIPTION_TYPE;
import static dev.ikm.tinkar.terms.TinkarTerm.REGULAR_NAME_DESCRIPTION_TYPE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GudidDescriptionSemanticIT extends AbstractIntegrationTest {

    /**
     * Test GudidDescription Semantics.
     *
     * @result Reads content from file and validates Concept of Semantics by calling private method assertLine().
     */
    @Test
    public void testGudidDescriptionSemantics() throws IOException {
        String sourceFilePath = "../gudid-origin/target/origin-sources";
        String errorFile = "target/failsafe-reports/gudid_descriptions_not_found.txt";

        String absolutePath = findFilePath(sourceFilePath, "foiclass.txt");
        int notFound = processFile(absolutePath, errorFile);

        assertEquals(0, notFound, "Unable to find " + notFound + " Gudid Description semantics. Details written to " + errorFile);
    }

    @Override
    protected boolean assertLine(String[] columns) {
        String productCode = columns[2];
        String deviceName = columns[3];
        UUID conceptUuid = conceptUuid(productCode);
        StateSet stateActive = StateSet.ACTIVE;
        StampCalculator stampCalcActive = StampCalculatorWithCache
                .getCalculator(StampCoordinateRecord.make(stateActive, Coordinates.Position.LatestOnDevelopment()));
//        ConceptRecord entity = EntityService.get().getEntityFast(conceptUuid);
//        Latest<ConceptVersionRecord> latest = stampCalcActive.latest(entity);

        EntityProxy.Concept fdaProductCodeConcept = EntityProxy.Concept.make(PublicIds.of(conceptUuid));
        PatternEntityVersion latestDescriptionPattern = (PatternEntityVersion) Calculators.Stamp.DevelopmentLatest().latest(TinkarTerm.DESCRIPTION_PATTERN).get();

        AtomicBoolean descriptionValue = new AtomicBoolean(false);

        //NOTE. This only covers the method createDescriptionSemantic() that 'Creates Regular Name semantic (PRODUCTCODE)'
        EntityService.get().forEachSemanticForComponentOfPattern(fdaProductCodeConcept.nid(), TinkarTerm.DESCRIPTION_PATTERN.nid(), semanticEntity -> {
            Latest<SemanticEntityVersion> latestActive = stampCalcActive.latest(semanticEntity);

            if (latestActive.isPresent()) {
                String description = latestDescriptionPattern.getFieldWithMeaning(TinkarTerm.DESCRIPTION, latestActive.get());
                Component descriptionNotCaseSensitive = latestDescriptionPattern.getFieldWithMeaning(TinkarTerm.DESCRIPTION_NOT_CASE_SENSITIVE, latestActive.get());
                Component descriptionType = latestDescriptionPattern.getFieldWithMeaning(TinkarTerm.DESCRIPTION_TYPE, latestActive.get());

                if (description.equals(productCode)
                        && descriptionNotCaseSensitive.equals(DESCRIPTION_NOT_CASE_SENSITIVE)
                        && descriptionType.equals(REGULAR_NAME_DESCRIPTION_TYPE)) {
                    descriptionValue.set(true);
                }
            }

        });

        return descriptionValue.get();
    }

}
