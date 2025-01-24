public class FlyWeightPatternExample {
    public static void main(String[] args) {

        System.out.println("Learning Fly weight design pattern using example!");
        System.out.println("_________________________________________________");

        Robot scaraRobot1 = RobotFactory.createRobot("SCARA");
        scaraRobot1.display(10,20);
        Robot scaraRobot2 = RobotFactory.createRobot("SCARA");
        scaraRobot2.display(30,40);

        Robot deltaRobot1 = RobotFactory.createRobot("DELTA");
        deltaRobot1.display(40,60);
        Robot deltaRobot2 = RobotFactory.createRobot("DELTA");
        deltaRobot2.display(80,100);
    }
}