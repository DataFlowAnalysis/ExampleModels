package org.dataflowanalysis.examplemodels.results.pcm;

import org.dataflowanalysis.analysis.dsl.AnalysisConstraint;
import org.dataflowanalysis.analysis.dsl.constraint.ConstraintDSL;
import org.dataflowanalysis.analysis.dsl.selectors.Intersection;
import org.dataflowanalysis.analysis.dsl.variable.ConstraintVariable;
import org.dataflowanalysis.analysis.pcm.dsl.PCMVertexType;
import org.dataflowanalysis.examplemodels.results.ExpectedCharacteristic;
import org.dataflowanalysis.examplemodels.results.ExpectedViolation;

import java.util.List;
import java.util.Map;

/**
 * TODO: This test model tests a specific feature not a integration/E2E test
 */
public class IgnoredNodesResult implements PCMExampleModelResult {
    @Override
    public String getModelName() {
        return "IgnoredNodes";
    }

    @Override
    public List<AnalysisConstraint> getDSLConstraints() {
        return List.of(new ConstraintDSL()
                .fromNode()
                .withType(PCMVertexType.CALLING)
                .withType(PCMVertexType.USER)
                .neverFlows()
                .toVertex()
                .with((node) -> !node.getAllDataCharacteristics().isEmpty())
                .create());
    }

    @Override
    public List<ExpectedViolation> getExpectedViolations() {
        return List.of(new ExpectedViolation(0, new PCMIdentifier("_LTpZcKpIEe6ICOKQQaQogw"), List.of(), Map.of("RETURN", List.of(new ExpectedCharacteristic("DataVisibility", "User")))));
    }

    @Override
    public String toString() {
        return this.getModelName();
    }
}
