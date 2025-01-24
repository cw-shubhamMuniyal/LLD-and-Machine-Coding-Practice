public class DeltaRobot implements Robot {

    private final String image = "delta-robot.png";

    @Override
    public void display(int x, int y) {
        System.out.println("Displaying Delta robot at (" + x + ", " + y + ") with image: " + image);
    }
}
