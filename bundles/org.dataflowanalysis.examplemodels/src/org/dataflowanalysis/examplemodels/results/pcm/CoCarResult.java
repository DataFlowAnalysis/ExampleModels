package org.dataflowanalysis.examplemodels.results.pcm;

import org.dataflowanalysis.analysis.dsl.AnalysisConstraint;
import org.dataflowanalysis.analysis.dsl.constraint.ConstraintDSL;
import org.dataflowanalysis.analysis.dsl.selectors.Intersection;
import org.dataflowanalysis.analysis.dsl.variable.ConstraintVariable;
import org.dataflowanalysis.examplemodels.results.ExpectedViolation;

import java.util.List;

public class CoCarResult implements PCMExampleModelResult {
    @Override
    public String getBaseFolderName() {
        return "casestudies";
    }

    @Override
    public String getModelName() {
        return "CoCarNextGen";
    }

    @Override
    public String getFileName() {
        return "AudiA6C8";
    }

    @Override
    public List<AnalysisConstraint> getDSLConstraints() {
        // TODO: Does not exist
        return List.of();
    }

    @Override
    public List<ExpectedViolation> getExpectedViolations() {
        // TODO: Enter actual expected violations (should this be per constraint?)
        return List.of();
    }

    @Override
    public String toString() {
        return this.getModelName();
    }
}
