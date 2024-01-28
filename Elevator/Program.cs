using Elevator.Modal;

namespace Elevator;

class Program
{
    static void Main(string[] args)
    {
        Console.WriteLine("Hello, World!");
        List<Floor> floorList = new();
        Floor floor1 = new Floor(1);
        Floor floor2 = new Floor(2);
        Floor floor3 = new Floor(3);
        Floor floor4 = new Floor(4);
        Floor floor5 = new Floor(5);
        floorList.Add(floor1);
        floorList.Add(floor2);
        floorList.Add(floor3);
        floorList.Add(floor4);
        floorList.Add(floor5);

        Building building = new Building(floorList);
    }
}
