import adaptee.WeightMachineAdapteeImpl;
import adapter.WeightMachineAdapter;
import adapter.WeightMachineAdapterImpl;

public class Client {
    public static void main(String[] args) {

        System.out.println("Adapter Pattern Example.");
        System.out.println("_________________________");

        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(
                new WeightMachineAdapteeImpl()
        );
        Double weight = weightMachineAdapter.getWeightInKg();
        System.out.println(weight);
    }
}