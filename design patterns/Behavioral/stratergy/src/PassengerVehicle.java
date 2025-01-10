import Stratergies.NormalDriveStratergy;

public class PassengerVehicle extends Vehicle{


    PassengerVehicle() {
        super(new NormalDriveStratergy());
    }

    @Override
    public void drive() {
        super.drive();
    }
    
}
