package org.dataflowanalysis.examplemodels.results.dfd;

import org.dataflowanalysis.analysis.dsl.AnalysisConstraint;
import org.dataflowanalysis.analysis.dsl.constraint.ConstraintDSL;
import org.dataflowanalysis.examplemodels.results.ExpectedViolation;

import java.util.List;

public class DeadOutPinResult implements DFDExampleModelResult {
    @Override
    public String getModelName() {
        return "DeadOutPin";
    }

    @Override
    public List<AnalysisConstraint> getDSLConstraints() {
        // TODO: Enter actual constraint
        return List.of();
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

