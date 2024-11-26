package org.dataflowanalysis.examplemodels.results.pcm;

import org.dataflowanalysis.analysis.dsl.AnalysisConstraint;
import org.dataflowanalysis.analysis.dsl.constraint.ConstraintDSL;
import org.dataflowanalysis.examplemodels.results.ExpectedCharacteristic;
import org.dataflowanalysis.examplemodels.results.ExpectedViolation;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class MultipleDeploymentsResult implements PCMExampleModelResult {
    @Override
    public String getModelName() {
        return "MultipleDeployments";
    }

    @Override
    public AnalysisConstraint getDSLConstraint() {
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
        return List.of(
                new ExpectedViolation(UUID.fromString("838571d3-277b-392f-9ac4-6b4d4ceddf56"),
                        List.of(new ExpectedCharacteristic("ServerLocation", "nonEU"), new ExpectedCharacteristic("ServerLocation", "EU")),
                        Map.of("userdata", List.of(new ExpectedCharacteristic("DataSensitivity", "Personal")))),
                new ExpectedViolation(UUID.fromString("a9ea02e4-d182-3bb2-bf18-edae674488c7"),
                        List.of(new ExpectedCharacteristic("ServerLocation", "nonEU"), new ExpectedCharacteristic("ServerLocation", "EU")),
                        Map.of("userdata", List.of(new ExpectedCharacteristic("DataSensitivity", "Personal")))));
    }

    @Override
    public String toString() {
        return this.getModelName();
    }
}
