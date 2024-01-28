namespace Elevator.Modal
{
    public class ElevatorDisplay
    {
        int Floor;
        Direction Direction;
        public void SetDisplay(int floor, Direction direction)
        {
            this.Floor = floor;
            this.Direction = direction;
        }
        public void ShowDisplay()
        {
            Console.WriteLine("Floor is " + Floor);
            Console.WriteLine("Direction is " + Direction);
        }
    }
}