public class ElectricCarBuilder extends CarBuilder{

    @Override
    CarBuilder setFuelType() {
        this.fuelType = "electric";
        return this;
    }
}
