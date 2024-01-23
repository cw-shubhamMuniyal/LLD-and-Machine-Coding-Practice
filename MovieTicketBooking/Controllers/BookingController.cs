using MovieTicketBooking.Model;
using MovieTicketBooking.Services;

namespace MovieTicketBooking.Controllers
{
    public class BookingController
    {
        ShowService _showService;
        TheatreService _theatreService;
        BookingService _bookingService;
        public BookingController(ShowService showService,
        TheatreService theatreService, BookingService bookingService)
        {
            _showService = showService;
            _theatreService = theatreService;
            _bookingService = bookingService;
        }
        public string CreateBooking(string showId, string user, List<string> seatIds)
        {
            Show show = _showService.GetShow(showId);
            List<Seat> seats = seatIds.Select(_theatreService.GetSeat).ToList();
            return _bookingService.CreateBooking(show, user, seats);
        }
        public void ConfrimBooking(string bookingId, string user)
        {
            _bookingService.ConfrimBooking(bookingId, user);
        }
    }
}