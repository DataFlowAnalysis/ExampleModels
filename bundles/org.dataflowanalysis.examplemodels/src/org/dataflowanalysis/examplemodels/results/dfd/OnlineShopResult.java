package org.dataflowanalysis.examplemodels.results.dfd;

import org.dataflowanalysis.analysis.dsl.AnalysisConstraint;
import org.dataflowanalysis.analysis.dsl.constraint.ConstraintDSL;
import org.dataflowanalysis.examplemodels.results.ExpectedCharacteristic;
import org.dataflowanalysis.examplemodels.results.ExpectedViolation;

import java.util.List;
import java.util.Map;

public class OnlineShopResult  implements DFDExampleModelResult {
    @Override
    public String getModelName() {
        return "OnlineShop";
    }

    @Override
    public List<AnalysisConstraint> getDSLConstraints() {
        return List.of(new ConstraintDSL()
                .ofData()
                .withLabel("Sensitivity", "Personal")
                .neverFlows()
                .toVertex()
                .withCharacteristic("Location", "nonEU")
                .create());
    }

    @Override
    public List<ExpectedViolation> getExpectedViolations() {
        return List.of(new ExpectedViolation(2, new DFDIdentifier("_U27Lor6CEe6fAKdvyu1GEg"), List.of(new ExpectedCharacteristic("Location", "nonEU")),
                Map.of("_zWPQ8L6GEe6fAKdvyu1GEg", List.of(
                        new ExpectedCharacteristic("Sensitivity", "Personal"),
                        new ExpectedCharacteristic("Encryption", "Encrypted")
                ))));
    }

    @Override
    public String toString() {
        return this.getModelName();
    }
}
