import Stratergies.DriveStratergy;

public class Vehicle {
    
    private final DriveStratergy driveStratergy;

    public Vehicle(DriveStratergy driveStratergy) {
        this.driveStratergy = driveStratergy;
    }

    public void drive() {
        driveStratergy.drive();
    }


}
