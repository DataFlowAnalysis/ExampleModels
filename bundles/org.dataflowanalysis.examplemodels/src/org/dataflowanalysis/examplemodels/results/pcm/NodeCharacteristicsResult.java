package org.dataflowanalysis.examplemodels.results.pcm;

import org.dataflowanalysis.analysis.dsl.AnalysisConstraint;
import org.dataflowanalysis.analysis.dsl.constraint.ConstraintDSL;
import org.dataflowanalysis.analysis.dsl.selectors.Intersection;
import org.dataflowanalysis.analysis.dsl.variable.ConstraintVariable;
import org.dataflowanalysis.examplemodels.results.ExpectedViolation;

import java.util.List;

/**
 * TODO: This test model tests a specific feature not a integration/E2E test
 */
public class NodeCharacteristicsResult implements PCMExampleModelResult {
    @Override
    public String getModelName() {
        return "NodeCharacteristics";
    }

    @Override
    public AnalysisConstraint getDSLConstraint() {
        // TODO: Enter actual constraint
        return new ConstraintDSL()
                .ofData()
                .withLabel("AssignedRole", ConstraintVariable.of("grantedRoles"))
                .neverFlows()
                .toVertex()
                .withCharacteristic("AssignedRole", ConstraintVariable.of("assignedRoles"))
                .where()
                .isNotEmpty(ConstraintVariable.of("grantedRoles"))
                .isNotEmpty(ConstraintVariable.of("assignedRoles"))
                .isEmpty(Intersection.of(ConstraintVariable.of("grantedRoles"), ConstraintVariable.of("assignedRoles")))
                .create();
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
