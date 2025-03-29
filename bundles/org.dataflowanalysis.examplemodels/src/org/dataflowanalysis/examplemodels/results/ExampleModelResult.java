package org.dataflowanalysis.examplemodels.results;

import org.dataflowanalysis.analysis.dsl.AnalysisConstraint;
import org.dataflowanalysis.examplemodels.Activator;
import org.eclipse.core.runtime.Plugin;

import java.util.List;

public interface ExampleModelResult {
    default String getModelProjectName() {
        return "org.dataflowanalysis.examplemodels";
    }

    default Class<? extends Plugin> getPluginActivator() {
        return Activator.class;
    }

    default String getBaseFolderName() {
        return "models";
    }

    default String getFileName() {
        return "default";
    }

    String getModelName();

    List<AnalysisConstraint> getDSLConstraints();

    List<ExpectedViolation> getExpectedViolations();
}
