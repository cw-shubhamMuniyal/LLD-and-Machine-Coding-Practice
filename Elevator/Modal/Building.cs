namespace Elevator.Modal
{
    public class Building
    {
        public List<Floor> Floors { get; private set; }
        Building()
        {
            Floors = new();
        }
        public Building(List<Floor> floors)
        {
            Floors = floors;
        }
    }
}