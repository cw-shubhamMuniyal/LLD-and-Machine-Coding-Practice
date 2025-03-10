using MovieTicketBooking.Model;
using MovieTicketBooking.Providers;

namespace MovieTicketBooking.Services
{
    public class SeatAvailabilityService
    {
        ShowService _showService;
        ISeatLockProvider _seatLockProvider;
        BookingService _bookingService;
        public SeatAvailabilityService(ShowService showService, ISeatLockProvider seatLockProvider,
        BookingService bookingService)
        {
            _showService = showService;
            _seatLockProvider = seatLockProvider;
            _bookingService = bookingService;
        }
        public List<Seat> GetAllAvailableSeats(string showId)
        {
            Show show = _showService.GetShow(showId);
            Screen screen = show.Screen;
            List<Seat> allSeats = screen.Seats;
            var lockedSeats = GetLockedSeats(show);
            foreach (Seat seat in allSeats)
            {
                if (lockedSeats.Contains(seat))
                {
                    allSeats.Remove(seat);
                }
            }
            return allSeats;
        }
        private List<Seat> GetLockedSeats(Show show)
        {
            List<Seat> seats = new();
            seats.AddRange(_seatLockProvider.GetLockedSeats(show));
            seats.AddRange(_bookingService.GetBookedSeats(show));
            return seats;
        }
    }
}