public class Circle implements Shape {

    private final Double radius;
    private String color;

    public Circle(Double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void display() {
        System.out.println("Circle{" +
                " radius=" + radius +
                " color=" + color +
                '}');
    }

    @Override
    public Shape clone() {
        return new Circle(this.radius, this.color);
    }
}
