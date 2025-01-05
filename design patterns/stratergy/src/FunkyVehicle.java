import Stratergies.SportyDriveStratergy;

public class FunkyVehicle extends Vehicle {

    FunkyVehicle() {
        super(new SportyDriveStratergy());
    }

    @Override
    public void drive() {
        super.drive();
    }

}
