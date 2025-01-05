import Stratergies.SportyDriveStratergy;

public class SportyVehicle extends Vehicle{

    SportyVehicle() {
        super(new SportyDriveStratergy());
    }

    @Override
    public void drive() {
        super.drive();
    }
    
}
