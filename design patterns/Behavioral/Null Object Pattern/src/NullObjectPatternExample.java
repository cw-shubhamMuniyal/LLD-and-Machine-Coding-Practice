public class NullObjectPatternExample {

    public static void main(String[] args) {

        Vehicle vehicle = VehicleFactory.createVehicle("car");
        getVehicleSpeed(vehicle);
    }

    private static void getVehicleSpeed(Vehicle vehicle) {

        System.out.println(vehicle.getSpeed());
    }
}
