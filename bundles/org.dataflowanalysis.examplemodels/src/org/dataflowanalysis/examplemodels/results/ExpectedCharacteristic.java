package org.dataflowanalysis.examplemodels.results;

public record ExpectedCharacteristic(String characteristicType, String characteristicLiteral) {

    @Override
    public String toString() {
        return String.format("%s.%s", characteristicType, characteristicLiteral);
    }
}
