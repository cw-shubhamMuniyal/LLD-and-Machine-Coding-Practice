using Elevator.Logic;

namespace Elevator.Modal
{
    public class InternalButton
    {
        List<int> availableButtons = new() { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        InternalDispatcher dispatcher = new InternalDispatcher();
        int buttonSelected;

        public void PressButton(int destination, ElevatorCar elevatorCar)
        {

            //1.check if destination is in the list of available floors

            //2.submit the request to the jobDispatcher
            if(!availableButtons.Contains(destination))
            {
                throw new Exception("Incorrect destination, pressed floor is not available to use");
            }
            dispatcher.submitInternalRequest(destination, elevatorCar);
        }

    }
}