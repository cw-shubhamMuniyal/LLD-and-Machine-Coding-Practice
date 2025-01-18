import java.awt.*;

public class Car {

    public Car(CarBuilder carBuilder) {
        this.bodyType = carBuilder.bodyType;
        this.color = carBuilder.color;
        this.fuelType = carBuilder.fuelType;
        this.transmission = carBuilder.transmission;
    }

    private String color;

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", transmission='" + transmission + '\'' +
                ", bodyType='" + bodyType + '\'' +
                '}';
    }

    private String fuelType;

    private String transmission;

    private String bodyType;
}
