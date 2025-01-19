public class Rectangle implements Shape {

    private final Double length;
    private final Double breadth;
    private String color;

    public Rectangle(Double length, Double breadth, String color) {
        this.length = length;
        this.breadth = breadth;
        this.color = color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void display() {
        System.out.println("Rectangle{" +
                "length=" + length +
                " breadth=" + breadth +
                " color=" + color +
                '}');
    }

    @Override
    public Shape clone() {
        return new Rectangle(this.length, this.breadth, this.color);
    }
}
