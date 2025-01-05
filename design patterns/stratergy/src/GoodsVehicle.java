import Stratergies.NormalDriveStratergy;

public class GoodsVehicle extends Vehicle{

    public GoodsVehicle() {
        super(new NormalDriveStratergy());
    }

    @Override
    public void drive() {
        super.drive();
    }
    

}
