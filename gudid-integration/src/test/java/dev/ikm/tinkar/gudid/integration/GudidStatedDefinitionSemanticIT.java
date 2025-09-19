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
import dev.ikm.tinkar.terms.EntityProxy;
import dev.ikm.tinkar.terms.TinkarTerm;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GudidStatedDefinitionSemanticIT extends AbstractIntegrationTest {
	String previousPrimaryDi = "";
	String previousProductCode = "";
	Set<String> productCodes;
	AtomicBoolean matchedOwlExpression = new AtomicBoolean(false);

	/**
	 * Test GudidStatedDefinition Semantics.
	 *
	 * @result Reads content from file and validates Axiom of Semantics by calling
	 *         private method assertLine().
	 */
	@Test
	public void testGudidStatedDefinitionSemantics() throws IOException {
		String sourceFilePath = "../gudid-pipeline/target/src";
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

		String primaryDi = columns[0];
		String productCodeColumn = columns[1];

		if (!gudidUtility.isDeviceIncluded(primaryDi, productCodeColumn)) {
			return true;
		}

		StateSet stateActive = StateSet.ACTIVE;

		PatternEntityVersion latestAxiomPattern = (PatternEntityVersion) Calculators.Stamp.DevelopmentLatest()
				.latest(TinkarTerm.OWL_AXIOM_SYNTAX_PATTERN).get();

		StampCalculator stampCalcActive = StampCalculatorWithCache
				.getCalculator(StampCoordinateRecord.make(stateActive, Coordinates.Position.LatestOnDevelopment()));

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
					.flatMap(productCode -> gudidUtility.getConceptByProductCode(productCode).stream())
					.toList();

			String owlExpression = gudidUtility.buildOwlExpression(concept, fdaProductCodeUuids);

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

		return Set.of(elementsForOwl1).equals(Set.of(elementsForOwl2));
	}
}
