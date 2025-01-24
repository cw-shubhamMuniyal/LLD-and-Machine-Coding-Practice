public class ScaraRobot implements Robot {

    private final String image = "scara-robot.png";

    @Override
    public void display(int x, int y) {
        System.out.println("Displaying Scara robot at (" + x + ", " + y + ") with image: " + image);
    }
}
