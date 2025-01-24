import java.util.HashMap;
import java.util.Objects;

public class RobotFactory {

    static HashMap<String, Robot> robots = new HashMap<>();

    public static Robot createRobot(String robotType) {

        Robot robot = robots.get(robotType);

        if (Objects.isNull(robot)) {
            if (robotType.equals("SCARA")) {
                Robot scaraRobot = new ScaraRobot();
                robots.put(robotType, scaraRobot);
                return scaraRobot;
            }
            else if (robotType.equals("DELTA")) {
                Robot deltaRobot = new DeltaRobot();
                robots.put(robotType, deltaRobot);
                return deltaRobot;
            }
        }
        return robot;
    }
}
