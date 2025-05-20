package org.dataflowanalysis.examplemodels.results.dfd.scenarios;

import java.util.List;
import java.util.Map;
import org.dataflowanalysis.analysis.dsl.AnalysisConstraint;
import org.dataflowanalysis.analysis.dsl.constraint.ConstraintDSL;
import org.dataflowanalysis.examplemodels.results.ExpectedCharacteristic;
import org.dataflowanalysis.examplemodels.results.ExpectedViolation;
import org.dataflowanalysis.examplemodels.results.dfd.DFDExampleModelResult;
import org.dataflowanalysis.examplemodels.results.dfd.DFDIdentifier;

public class ACMACNoViolation implements DFDExampleModelResult {
    @Override
    public String getBaseFolderName() {
        return "scenarios";
    }

    @Override
    public String getModelName() {
        return "AC-MAC-no-violation";
    }

    @Override
    public List<AnalysisConstraint> getDSLConstraints() {
    	return List.of(new ConstraintDSL().ofData()
    			.withLabel("ClassificationLevel", "Classified")
    			.neverFlows()
    			.toVertex()
    			.withCharacteristic("ClearanceLevel", "Unclassified")
    			.create(),
    			new ConstraintDSL().ofData()
    			.withLabel("ClassificationLevel", "Secret")
    			.neverFlows()
    			.toVertex()
    			.withCharacteristic("ClearanceLevel", "Classified")
    			.create());
    }

    @Override
    public List<ExpectedViolation> getExpectedViolations() {
        return null;
    }

    @Override
    public String toString() {
        return this.getModelName();
    }
}