public class PetrolCarBuilder extends CarBuilder{

    @Override
    CarBuilder setFuelType() {
        this.fuelType = "petrol";
        return this;
    }
}
