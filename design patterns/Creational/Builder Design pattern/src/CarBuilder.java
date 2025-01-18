public abstract class CarBuilder {

    protected String color;

    protected String fuelType;

    protected String transmission;

    protected String bodyType;

    public CarBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    abstract CarBuilder setFuelType();

    public CarBuilder setTransmission(String transmission) {
        this.transmission = transmission;
        return this;
    }

    public CarBuilder setBodyType(String bodyType) {
        this.bodyType = bodyType;
        return this;
    }

    public Car build() {
        return new Car(this);
    }
}
