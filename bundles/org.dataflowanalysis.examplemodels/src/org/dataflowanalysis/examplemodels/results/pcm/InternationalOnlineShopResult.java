package org.dataflowanalysis.examplemodels.results.pcm;

import org.dataflowanalysis.analysis.dsl.AnalysisConstraint;
import org.dataflowanalysis.analysis.dsl.constraint.ConstraintDSL;
import org.dataflowanalysis.examplemodels.results.ExpectedCharacteristic;
import org.dataflowanalysis.examplemodels.results.ExpectedViolation;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class InternationalOnlineShopResult implements PCMExampleModelResult {
    @Override
    public String getModelName() {
        return "InternationalOnlineShop";
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
                new ExpectedViolation(UUID.fromString("74b8d8a8-d110-3c5a-aca0-0092db3ec931"), List.of(new ExpectedCharacteristic("ServerLocation", "nonEU")),
                        Map.of("userData", List.of(new ExpectedCharacteristic("DataSensitivity", "Personal")))),
                new ExpectedViolation(UUID.fromString("f362790a-49d7-3c22-8558-7232ba02d577"), List.of(new ExpectedCharacteristic("ServerLocation", "nonEU")),
                        Map.of("userData", List.of(new ExpectedCharacteristic("DataSensitivity", "Personal")))));
    }

    @Override
    public String toString() {
        return this.getModelName();
    }
}
