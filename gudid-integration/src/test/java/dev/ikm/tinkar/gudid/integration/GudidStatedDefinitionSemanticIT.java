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
import dev.ikm.tinkar.entity.ConceptRecord;
import dev.ikm.tinkar.entity.ConceptVersionRecord;
import dev.ikm.tinkar.entity.EntityService;
import dev.ikm.tinkar.entity.PatternEntityVersion;
import dev.ikm.tinkar.entity.SemanticEntityVersion;
import dev.ikm.tinkar.terms.EntityProxy;
import dev.ikm.tinkar.terms.TinkarTerm;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GudidStatedDefinitionSemanticIT extends AbstractIntegrationTest {

	/**
	 * Test GudidConcepts Semantics.
	 *
	 * @result Reads content from file and validates Axiom of Semantics by calling
	 *         private method assertLine().
	 */
	@Test
	public void testGudidStatedDefinitionSemantics() throws IOException {
		String sourceFilePath = "../gudid-origin/target/origin-sources";
		String errorFile = "target/failsafe-reports/gudid_axiom_not_found.txt";

//        String absolutePath = gudIdFileName; //Unable to find 2932991 device.txt semantics. Details written to target/failsafe-reports/gudid_concepts_not_found.txt ==> expected: <0> but was: <2932991>
		String absolutePath = findFilePath(sourceFilePath, "productCodes.txt"); // Unable to find 6987
																				// productCodes.txt.txt semantics.
																				// Details written to
																				// target/failsafe-reports/gudid_concepts_not_found.txt
																				// ==> expected: <0> but was: <6987>
		int notFound = processFile(absolutePath, errorFile);

		assertEquals(0, notFound,
				"Unable to find " + notFound + " Gudid Axiom semantics for Devices. Details written to " + errorFile);
	}

	@Override
	protected boolean assertLine(String[] columns) {

		//AtomicBoolean matchedOwlExpression = new AtomicBoolean(false);

		StateSet stateActive = StateSet.ACTIVE;

		PatternEntityVersion latestAxiomPattern = (PatternEntityVersion) Calculators.Stamp.DevelopmentLatest()
				.latest(TinkarTerm.OWL_AXIOM_SYNTAX_PATTERN).get();

		StampCalculator stampCalcActive = StampCalculatorWithCache
				.getCalculator(StampCoordinateRecord.make(stateActive, Coordinates.Position.LatestOnDevelopment()));

		String primaryDi = columns[0];
		String productCodeColumn = columns[1];

		if (previousPrimaryDi.equals("")) {
			previousPrimaryDi = primaryDi;
			return true;
		}

		UUID conceptUuid = conceptUuidForPrimaryDi(previousPrimaryDi);

		EntityProxy.Concept concept = EntityProxy.Concept.make(PublicIds.of(conceptUuid));

		List<UUID> fdaProductCodeUuids = null;

		if (!primaryDi.equals(previousPrimaryDi)) {
			if (productCodes == null || productCodes.isEmpty()) {
				productCodes = new HashSet<>(); // If not, create a new HashSet
				productCodes.add(previousProductCode); // Add the productCode to the Set
			}
			// primaryDiToProductCodes.put(primaryDi, productCodes); // And add it to the
			// map

			// Get FDA product code concept UUIDs from mapping
			fdaProductCodeUuids = productCodes.stream()
					.flatMap(productCode -> gudidUtilityWithNameSpace.getConceptByProductCode(productCode).stream())
					.toList();

			String owlExpression = gudidUtilityWithNameSpace.buildOwlExpression(concept, fdaProductCodeUuids);

			EntityService.get().forEachSemanticForComponentOfPattern(concept.nid(),
					TinkarTerm.OWL_AXIOM_SYNTAX_PATTERN.nid(), semanticEntity -> {
						Latest<SemanticEntityVersion> latestActive = stampCalcActive.latest(semanticEntity);

						if (latestActive.isPresent()) {
							String axiomSyntaxText = latestAxiomPattern.getFieldWithMeaning(TinkarTerm.AXIOM_SYNTAX,
									latestActive.get());
							if (owlExpression.equals(axiomSyntaxText)) {
								matchedOwlExpression.set(true);
							} else if (owlExpressionsMatching(owlExpression, axiomSyntaxText)) {
								matchedOwlExpression.set(true);
							} else {
								matchedOwlExpression.set(false);
							}
						}
					});

			previousPrimaryDi = primaryDi;

			productCodes.clear();
			productCodes.add(productCodeColumn);

			previousProductCode = productCodeColumn;
		} else {
			if (productCodes == null || productCodes.isEmpty()) {
				productCodes = new HashSet<>(); // If not, create a new HashSet
			}

			productCodes.add(productCodeColumn); // Add the productCode to the Set
			previousPrimaryDi = primaryDi;

			return true;
		}

		return matchedOwlExpression.get();
	}

	boolean owlExpressionsMatching(String owl1, String owl2) {
		String[] elementsForOwl1 = owl1.replace("SubClassOf(:", "").replace("ObjectIntersectionOf(", "")
				.replace(")", "").split(":");

		String[] elementsForOwl2 = owl1.replace("SubClassOf(:", "").replace("ObjectIntersectionOf(", "")
				.replace(")", "").split(":");

		boolean match = false;
		for (String element1 : elementsForOwl1) {
			for (String element2 : elementsForOwl2) {
				if (element1.equals(element2)) {
					match = true;
					break;
				}
			}

			if (match == false) {
				break;
			}
		}

		return match;
	}
}
