namespace Model
{
    public class Slot(int id)
    {

        public Car ParkedCar { get; set;}
        public int Id { get; set; } = id;
        public bool IsSlotFree()
        {
            return ParkedCar == null;
        }
        public void AssignCar(Car car)
        {
            ParkedCar = car;
        }
        public void UnassignCar()
        {
            ParkedCar = null;
        }
    }
}