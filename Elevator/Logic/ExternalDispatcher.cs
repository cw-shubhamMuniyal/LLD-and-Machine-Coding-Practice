using Elevator.Modal;

public class ExternalDispatcher
{

    List<ElevatorController> elevatorControllerList = ElevatorCreator.elevatorControllerList;

    public void submitExternalRequest(int floor, Direction direction)
    {
        //for simplicity, i am following even odd,
        foreach (ElevatorController elevatorController in elevatorControllerList)
        {
            int elevatorID = elevatorController.elevatorCar._id;
            if (elevatorID % 2 == 1 && floor % 2 == 1)
            {
                elevatorController.SubmitExternalRequest(floor, direction);
            }
            else if (elevatorID % 2 == 0 && floor % 2 == 0)
            {
                elevatorController.SubmitExternalRequest(floor, direction);

            }
        }
    }

}