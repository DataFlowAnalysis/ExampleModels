package org.dataflowanalysis.examplemodels.results.pcm;

import org.dataflowanalysis.analysis.dsl.AnalysisConstraint;
import org.dataflowanalysis.analysis.dsl.constraint.ConstraintDSL;
import org.dataflowanalysis.analysis.dsl.selectors.Intersection;
import org.dataflowanalysis.analysis.dsl.variable.ConstraintVariable;
import org.dataflowanalysis.analysis.pcm.core.seff.SEFFPCMVertex;
import org.dataflowanalysis.analysis.pcm.core.user.UserPCMVertex;
import org.dataflowanalysis.examplemodels.results.ExpectedViolation;

import java.util.ArrayList;
import java.util.List;

public class NodeCharacteristicsResult implements PCMExampleModelResult {
    @Override
    public String getModelName() {
        return "NodeCharacteristics";
    }

    @Override
    public List<AnalysisConstraint> getDSLConstraints() {
        List<AnalysisConstraint> constraints = new ArrayList<>();
        constraints.add(new ConstraintDSL()
                .ofData()
                .neverFlows()
                .toVertex()
                .with((vertex) -> vertex instanceof UserPCMVertex<?> && vertex.getAllVertexCharacteristics().size() != 1)
                .with((vertex) -> vertex instanceof SEFFPCMVertex<?> && vertex.getAllVertexCharacteristics().size() != 2)
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
