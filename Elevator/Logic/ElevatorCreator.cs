using Elevator.Logic;

public class ElevatorCreator
{

    public static List<ElevatorController> elevatorControllerList = new();
    static ElevatorCreator()
    {

        ElevatorCar elevatorCar1 = new ElevatorCar();
        elevatorCar1._id = 1;
        ElevatorController controller1 = new ElevatorController(elevatorCar1);

        ElevatorCar elevatorCar2 = new ElevatorCar();
        elevatorCar1._id = 2;
        ElevatorController controller2 = new ElevatorController(elevatorCar2);

        elevatorControllerList.Add(controller1);
        elevatorControllerList.Add(controller2);
    }
}