package org.dataflowanalysis.examplemodels.results.pcm;

import org.dataflowanalysis.analysis.dsl.AnalysisConstraint;
import org.dataflowanalysis.analysis.dsl.constraint.ConstraintDSL;
import org.dataflowanalysis.analysis.dsl.selectors.Intersection;
import org.dataflowanalysis.analysis.dsl.variable.ConstraintVariable;
import org.dataflowanalysis.examplemodels.results.ExpectedCharacteristic;
import org.dataflowanalysis.examplemodels.results.ExpectedViolation;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class VariableReturnResult implements PCMExampleModelResult {
    @Override
    public String getModelName() {
        return "VariableReturn";
    }

    @Override
    public AnalysisConstraint getDSLConstraint() {
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
        return List.of(
                new ExpectedViolation(UUID.fromString("faaf62e5-405f-385c-96f1-c01d378193a6"), List.of(new ExpectedCharacteristic("AssignedRole", "User")),
                        Map.of("RETURN", List.of(new ExpectedCharacteristic("AssignedRole", "Admin")))),
                new ExpectedViolation(UUID.fromString("843a03df-2250-3227-b4b2-108318912005"), List.of(new ExpectedCharacteristic("AssignedRole", "User")),
                        Map.of("data", List.of(new ExpectedCharacteristic("AssignedRole", "Admin")))));
    }

    @Override
    public String toString() {
        return this.getModelName();
    }
}