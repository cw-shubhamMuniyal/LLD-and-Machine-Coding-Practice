using CabBooking.Controller;
using CabBooking.DataAccessLayer;
using CabBooking.Model;
using CabBooking.Stratergies;

namespace CabBooking;

class Program
{
    static void Main(string[] args)
    {
        Console.WriteLine("Hello, World!");
        CabManager cabManager = new();
        RiderManager riderManager = new();
        IMatchCabToRiderStratergy matchCabToRiderStratergy = new MatchCabToRiderDefaultStratergy();
        IPriceStratergy priceStratergy = new DefaultPriceStratergy();

        TripManager tripManager = new TripManager(cabManager, riderManager, priceStratergy, matchCabToRiderStratergy);
        CabController cabController = new CabController(cabManager, tripManager);
        RiderController riderController = new RiderController(riderManager, tripManager);

        Location location = new Location(10, 10);
        cabController.Register("1", location, "9090909090");

        location = new Location(50, 10);
        cabController.Register("3", location, "1234567890");
        
        location = new Location(10, 15);
        cabController.Register("5", location, "0987654321");
        cabController.UpdateAvailability("5", DriverStatus.InActive);

        riderController.Register("1", "8988898989");
        riderController.Register("2", "9012340987");

        riderController.BookCab("2", new Location(50, 10), new Location(0, 0));
        cabController.EndTrip("3");

        var trips = riderController.GetTripsHistory("2");
    }
}
