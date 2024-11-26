package org.dataflowanalysis.examplemodels.results.dfd;

import org.dataflowanalysis.analysis.dsl.AnalysisConstraint;
import org.dataflowanalysis.analysis.dsl.constraint.ConstraintDSL;
import org.dataflowanalysis.examplemodels.results.ExpectedViolation;

import java.util.List;

public class ComplexPseudoCycleResult implements DFDExampleModelResult {
    @Override
    public String getModelName() {
        return "ComplexPseudoCycle";
    }

    @Override
    public AnalysisConstraint getDSLConstraint() {
        // TODO: Enter actual constraint
        return new ConstraintDSL()
                .ofData()
                .withLabel("DataSensitivity", "Personal")
                .neverFlows()
                .toVertex()
                .withCharacteristic("ServerLocation", "nonEU")
                .create();
    }

    @Override
    public List<ExpectedViolation> getExpectedViolations() {
        // TODO: Enter actual violations
        return List.of();
    }

    @Override
    public String toString() {
        return this.getModelName();
    }
}
