package org.dataflowanalysis.examplemodels.results.pcm;

import org.dataflowanalysis.analysis.dsl.AnalysisConstraint;
import org.dataflowanalysis.analysis.dsl.constraint.ConstraintDSL;
import org.dataflowanalysis.analysis.dsl.selectors.Intersection;
import org.dataflowanalysis.analysis.dsl.variable.ConstraintVariable;
import org.dataflowanalysis.examplemodels.results.ExpectedViolation;

import java.util.ArrayList;
import java.util.List;

public class MaaSTicketSystemResult implements PCMExampleModelResult {
    @Override
    public String getBaseFolderName() {
        return "casestudies";
    }

    @Override
    public String getModelName() {
        return "MaaSTicketSystem";
    }

    @Override
    public String getFileName() {
        return "MaaS";
    }

    @Override
    public List<AnalysisConstraint> getDSLConstraints() {
        List<AnalysisConstraint> constraints = new ArrayList<>();
        constraints.add(new ConstraintDSL()
                .fromNode()
                .neverFlows()
                .toVertex()
                .withCharacteristic("Role", "MaliciousActor")
                .create());
        constraints.add(new ConstraintDSL()
                .ofData()
                .withLabel("DataType", "LoginData")
                .neverFlows()
                .toVertex()
                .withCharacteristic("Role", "Customer")
                .create());
        constraints.add(new ConstraintDSL()
                .ofData()
                .withLabel("Origin", "Leaked")
                .neverFlows()
                .toVertex()
                .create());
        return constraints;
    }

    @Override
    public List<ExpectedViolation> getExpectedViolations() {
        // TODO: Enter violations
        return List.of();
    }

    @Override
    public String toString() {
        return this.getModelName();
    }
}
