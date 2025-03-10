using MovieTicketBooking.Model;
using MovieTicketBooking.Services;

namespace MovieTicketBooking.Controllers
{
    public class ShowController
    {
        ShowService _showService;
        MovieService _movieService;
        TheatreService _theatreService;
        SeatAvailabilityService _seatAvailabilityService;
        public ShowController(ShowService showService, MovieService movieService,
        TheatreService theatreService, SeatAvailabilityService seatAvailabilityService)
        {
            _showService = showService;
            _theatreService = theatreService;
            _movieService = movieService;
            _seatAvailabilityService = seatAvailabilityService;
        }
        public string CreateShow(string movieId, string screenId, DateTime startTime, int durationInMins)
        {
            Movie movie = _movieService.GetMovie(movieId);
            Screen screen = _theatreService.GetScreen(screenId);
            return _showService.AddShow(movie, screen, startTime, durationInMins);
        }
        public List<Seat> GetAllAvailableSeats(string showId)
        {
            return _seatAvailabilityService.GetAllAvailableSeats(showId);
        }
    }
}