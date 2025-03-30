package org.dataflowanalysis.examplemodels.results.dfd;

import org.dataflowanalysis.analysis.dsl.AnalysisConstraint;
import org.dataflowanalysis.analysis.dsl.constraint.ConstraintDSL;
import org.dataflowanalysis.examplemodels.results.ExpectedViolation;

import java.util.List;

public class UnusedInputResult implements DFDExampleModelResult {
    @Override
    public String getModelName() {
        return "UnusedInput";
    }

    @Override
    public List<AnalysisConstraint> getDSLConstraints() {
        // TODO: Has no constraints
        return List.of();
    }

    @Override
    public List<ExpectedViolation> getExpectedViolations() {
        // TODO: Has no constraints; Therefore no expected violations
        return List.of();
    }

    @Override
    public String toString() {
        return this.getModelName();
    }
}

