public class VehicleFactory {

    public static Vehicle createVehicle(String vehicleType) {
        if (vehicleType.equals("car")) {
            return new Car();
        }
        return new NullVehicle();
    }
}
