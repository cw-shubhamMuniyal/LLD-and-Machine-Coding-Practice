public class Director {

    private Car createElectricCar() {
        return new ElectricCarBuilder().
                setColor("red")
                .setTransmission("manual")
                .setBodyType("sedan")
                .setFuelType()
                .build();
    }

    private Car createPetrolCar() {
        return new PetrolCarBuilder().
                setColor("blue")
                .setTransmission("electric")
                .setBodyType("SUV")
                .setFuelType()
                .build();
    }

    public Car getCar(String type) {
        if (type.equals("electric")) {
            return createElectricCar();
        }
        else if (type.equals("petrol")) {
            return createPetrolCar();
        }
        else return null;
    }
}
