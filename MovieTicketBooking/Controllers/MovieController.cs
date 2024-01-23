using MovieTicketBooking.Services;

namespace MovieTicketBooking.Controllers
{
    public class MovieController
    {
        MovieService _movieService;
        public MovieController(MovieService movieService)
        {
            _movieService = movieService;
        }
        public string Add(string name)
        {
            return _movieService.AddMovie(name);
        }
    }
}