package org.dataflowanalysis.examplemodels.results.pcm;

import org.dataflowanalysis.examplemodels.results.ExampleModelResult;

import java.nio.file.Paths;

public interface PCMExampleModelResult extends ExampleModelResult {
    default String getUsageModelPath() {
        return Paths.get(this.getBaseFolderName(), "pcm", this.getModelName(), String.format("%s.usagemodel", this.getFileName())).toString();
    }

    default String getAllocationModelPath() {
        return Paths.get(this.getBaseFolderName(), "pcm", this.getModelName(), String.format("%s.allocation", this.getFileName())).toString();
    }

    default String getNodeCharacteristicsModelPath() {
        return Paths.get(this.getBaseFolderName(), "pcm", this.getModelName(), String.format("%s.nodecharacteristics", this.getFileName())).toString();
    }
}
