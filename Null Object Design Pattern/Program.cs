namespace Null_Object_Design_Pattern;

class Program
{
    static void Main(string[] args)
    {
        GetVehicleSpecs(new Null());
    }
    private static void GetVehicleSpecs(Vehicle vehicle)
    {
        // if(vehicle != null) : Now you can avoid writing this line for checking null after adding null design pattern
        // for vehicle object
        Console.WriteLine(vehicle.GetTankingCapacity());
        Console.WriteLine(vehicle.GetSeatingCapacity());
    }
}
