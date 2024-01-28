using Elevator.Modal;

namespace Elevator.Logic
{
    public class ElevatorCar
    {
        public int _id { get; set; }
        ElevatorDisplay _display;
        InternalButton _internalButton;
        ElevatorState _elevatorState;
        int _currentFloor;
        public Direction _elevatorDirection { get; }
        ElevatorDoor _elevatorDoor;

        public ElevatorCar()
        {
            _display = new ElevatorDisplay();
            _internalButton = new InternalButton();
            _elevatorState = ElevatorState.Idle;
            _currentFloor = 0;
            _elevatorDirection = Direction.Up;
            _elevatorDoor = new ElevatorDoor();

        }
        public void ShowDisplay()
        {
            _display.ShowDisplay();
        }

        public void PressButton(int destination)
        {
            _internalButton.PressButton(destination, this);
        }

        public void SetDisplay()
        {
            _display.SetDisplay(_currentFloor, _elevatorDirection);
        }

        bool MoveElevator(Direction dir, int destinationFloor)
        {
            int startFloor = _currentFloor;
            if (dir == Direction.Up)
            {
                for (int i = startFloor; i <= destinationFloor; i++)
                {

                    _currentFloor = startFloor;
                    SetDisplay();
                    ShowDisplay();
                    if (i == destinationFloor)
                    {
                        return true;
                    }
                }
            }

            if (dir == Direction.Down)
            {
                for (int i = startFloor; i >= destinationFloor; i--)
                {

                    _currentFloor = startFloor;
                    SetDisplay();
                    ShowDisplay();
                    if (i == destinationFloor)
                    {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}