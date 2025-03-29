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
    public List<AnalysisConstraint> getDSLConstraints() {
        return List.of(new ConstraintDSL()
                .ofData()
                .withLabel("DataSensitivity", "Personal")
                .neverFlows()
                .toVertex()
                .withCharacteristic("ServerLocation", "nonEU")
                .create());
    }

    @Override
    public List<ExpectedViolation> getExpectedViolations() {
        return List.of(
                new ExpectedViolation(0, PCMIdentifier.of("_oGmXgYTjEeywmO_IpTxeAg", true), List.of(new ExpectedCharacteristic("ServerLocation", "nonEU")),
                        Map.of("userData", List.of(new ExpectedCharacteristic("DataSensitivity", "Personal")))),
                new ExpectedViolation(0, PCMIdentifier.of("_oGmXgYTjEeywmO_IpTxeAg", false), List.of(new ExpectedCharacteristic("ServerLocation", "nonEU")),
                        Map.of("userData", List.of(new ExpectedCharacteristic("DataSensitivity", "Personal")))));
    }

    @Override
    public String toString() {
        return this.getModelName();
    }
}
