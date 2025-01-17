package adapter;

import adaptee.WeightMachineAdaptee;

public class WeightMachineAdapterImpl implements adapter.WeightMachineAdapter {

    WeightMachineAdaptee weightMachineAdaptee;

    public WeightMachineAdapterImpl(WeightMachineAdaptee weightMachineAdaptee) {
        this.weightMachineAdaptee = weightMachineAdaptee;
    }

    @Override
    public Double getWeightInKg() {
        Double weightInPound = weightMachineAdaptee.getWeightInPound();
        return weightInPound * 0.45359237;
    }
}