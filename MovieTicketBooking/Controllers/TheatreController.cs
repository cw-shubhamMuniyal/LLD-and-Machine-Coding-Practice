using MovieTicketBooking.Model;
using MovieTicketBooking.Services;

namespace MovieTicketBooking.Controllers
{
    public class TheatreController
    {
        TheatreService _theatreService;
        public TheatreController(TheatreService theatreService)
        {
            _theatreService = theatreService;
        }   
        public string AddTheatre(string id, string name)
        {
            return _theatreService.AddTheatre(id, name);
        }
        public string AddScreen(string id, string theatreId)
        {
            return _theatreService.AddScreen(id, theatreId);
        }
        public string AddSeat(int seatNo, int rowNo, string ScreenId)
        {
            return _theatreService.AddSeat(seatNo, rowNo, ScreenId);
        }
    }
}