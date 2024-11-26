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

public class TravelPlannerResult implements PCMExampleModelResult {
    @Override
    public String getBaseFolderName() {
        return "casestudies";
    }

    @Override
    public String getModelName() {
        return "TravelPlanner";
    }

    @Override
    public String getFileName() {
        return "travelPlanner";
    }

    @Override
    public AnalysisConstraint getDSLConstraint() {
        return new ConstraintDSL()
                .ofData()
                .withLabel("GrantedRoles", ConstraintVariable.of("grantedRoles"))
                .neverFlows()
                .toVertex()
                .withCharacteristic("AssignedRoles", ConstraintVariable.of("assignedRoles"))
                .where()
                .isNotEmpty(ConstraintVariable.of("grantedRoles"))
                .isNotEmpty(ConstraintVariable.of("assignedRoles"))
                .isEmpty(Intersection.of(ConstraintVariable.of("grantedRoles"), ConstraintVariable.of("assignedRoles")))
                .create();
    }

    @Override
    public List<ExpectedViolation> getExpectedViolations() {
        return List.of(
                new ExpectedViolation(UUID.fromString("2214df8e-6d69-3738-83a2-1b91df85e9af"), List.of(new ExpectedCharacteristic("AssignedRoles", "Airline")),
                        Map.of("flight",
                                List.of(new ExpectedCharacteristic("GrantedRoles", "User"), new ExpectedCharacteristic("GrantedRoles", "Airline")),
                                "ccd", List.of(new ExpectedCharacteristic("GrantedRoles", "User")))),
                new ExpectedViolation(UUID.fromString("5bdd20eb-7450-3772-974f-87e31009847e"), List.of(new ExpectedCharacteristic("AssignedRoles", "Airline")),
                        Map.of("flight",
                                List.of(new ExpectedCharacteristic("GrantedRoles", "User"), new ExpectedCharacteristic("GrantedRoles", "Airline")),
                                "ccd", List.of(new ExpectedCharacteristic("GrantedRoles", "User")))),
                new ExpectedViolation(UUID.fromString("207639fc-5022-354e-8ffd-7b20885b469e"), List.of(new ExpectedCharacteristic("AssignedRoles", "Airline")),
                        Map.of("flight",
                                List.of(new ExpectedCharacteristic("GrantedRoles", "User"), new ExpectedCharacteristic("GrantedRoles", "Airline")),
                                "ccd", List.of(new ExpectedCharacteristic("GrantedRoles", "User")), "RETURN",
                                List.of(new ExpectedCharacteristic("GrantedRoles", "User"), new ExpectedCharacteristic("GrantedRoles", "Airline")))));
    }

    @Override
    public String toString() {
        return this.getModelName();
    }
}
