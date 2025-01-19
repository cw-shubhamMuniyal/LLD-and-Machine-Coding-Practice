public class Main {
    public static void main(String[] args) {
        System.out.println("Prototype design pattern with example!");
        System.out.println("______________________________________");

        Shape circle = new Circle(5.0, "red");
        System.out.println("original Circle");
        circle.display();

        Shape clonedCircle = circle.clone();
        clonedCircle.setColor("blue");
        System.out.println("Cloned Circle with changed color property");
        clonedCircle.display();

        Shape rectangle = new Rectangle(5.0, 10.0, "blue");
        System.out.println("original rectangle");
        rectangle.display();

        Shape clonedRectangle = rectangle.clone();
        clonedRectangle.setColor("red");
        System.out.println("Cloned rectangle with changed color property");
        clonedRectangle.display();
    }
}