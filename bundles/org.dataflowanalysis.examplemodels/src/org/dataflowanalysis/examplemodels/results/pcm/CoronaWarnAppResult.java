package org.dataflowanalysis.examplemodels.results.pcm;

import org.dataflowanalysis.analysis.dsl.AnalysisConstraint;
import org.dataflowanalysis.analysis.dsl.constraint.ConstraintDSL;
import org.dataflowanalysis.analysis.dsl.selectors.Intersection;
import org.dataflowanalysis.analysis.dsl.variable.ConstraintVariable;
import org.dataflowanalysis.examplemodels.results.ExpectedViolation;

import java.util.ArrayList;
import java.util.List;
public class CoronaWarnAppResult implements PCMExampleModelResult {
    @Override
    public String getBaseFolderName() {
        return "scenarios";
    }

    @Override
    public String getModelName() {
        return "CoronaWarnApp";
    }

    @Override
    public List<AnalysisConstraint> getDSLConstraints() {
        List<AnalysisConstraint> constraints = new ArrayList<>();
        constraints.add(new ConstraintDSL()
                .ofData()
                .neverFlows()
                .toVertex()
                .withCharacteristic("Location", "IllegalLocation")
                .create());
        constraints.add(new ConstraintDSL()
                .ofData()
                .withLabel("Status", "Leaked")
                .neverFlows()
                .toVertex()
                .create());
        return constraints;
    }

    @Override
    public List<ExpectedViolation> getExpectedViolations() {
        return List.of();
    }

    @Override
    public String toString() {
        return this.getModelName();
    }
}
