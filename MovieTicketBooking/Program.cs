using MovieTicketBooking.Controllers;
using MovieTicketBooking.Model;
using MovieTicketBooking.Providers;
using MovieTicketBooking.Services;

namespace MovieTicketBooking;

class Program
{
    static void Main(string[] args)
    {
        Console.WriteLine("Hello, World!");
        TheatreService theatreService = new TheatreService();
        TheatreController theatreController = new TheatreController(theatreService);
        theatreController.AddTheatre("1", "Ashok Anil");
        theatreController.AddScreen("1", "1");
        theatreController.AddScreen("2", "1");
        theatreController.AddScreen("3", "1");

        int count = 0;
        List<string> seatsInScreen1 = new();
        List<string> seatsInScreen2 = new();
        List<string> seatsInScreen3 = new();

        // Screen 1
        for(int row=0;row<10;row++)
        {
            seatsInScreen1.Add(theatreController.AddSeat(count++, row, "1"));
        }
        // Screen 2
        for(int row=0;row<5;row++)
        {
            seatsInScreen1.Add(theatreController.AddSeat(count++, row, "2"));
        }
        // Screen 3
        for(int row=0;row<20;row++)
        {
            seatsInScreen1.Add(theatreController.AddSeat(count++, row, "3"));
        }

        MovieService movieService = new MovieService();
        MovieController movieController = new MovieController(movieService);
        string movieId1 = movieController.Add("Baahubali");
        string movieId2 = movieController.Add("KGF");
        string movieId3 = movieController.Add("Avengers");

        ShowService showService = new ShowService();
        ISeatLockProvider seatLockProvider = new InMemorySeatLockProvider(20);
        BookingService bookingService = new BookingService(seatLockProvider);
        SeatAvailabilityService seatAvailabilityService = new SeatAvailabilityService(showService,
        seatLockProvider, bookingService);
        ShowController showController = new ShowController(showService, movieService, theatreService,
        seatAvailabilityService);
        string showId1 = showController.CreateShow(movieId1, "1", new DateTime(2024,01,24) + new TimeSpan(9, 0, 0), 180);
        string showId2 = showController.CreateShow(movieId2, "1", new DateTime(2024,01,24) + new TimeSpan(12, 0, 0), 180);
        string showId3 = showController.CreateShow(movieId3, "1", new DateTime(2024,01,24) + new TimeSpan(3, 0, 0), 180);

        BookingController bookingController = new BookingController(showService, theatreService, bookingService);
        string bookingId1 = bookingController.CreateBooking(showId1, "chinnay swamay", seatsInScreen1.GetRange(0, 5));

        PaymentService paymentService = new PaymentService(bookingService, seatLockProvider, 5);
        PaymentController paymentController = new PaymentController(bookingService, paymentService);
        paymentController.ProcessPaymentFailed("chinnay swamay", bookingId1);


        string bookingId2 = bookingController.CreateBooking(showId1, "Muttu swamay", seatsInScreen1.GetRange(2, 5));
        bookingController.ConfrimBooking(bookingId2, "Muttu swamay");
        paymentController.ProcessPaymentSuccess("Muttu swamay", bookingId2);



    }
}
