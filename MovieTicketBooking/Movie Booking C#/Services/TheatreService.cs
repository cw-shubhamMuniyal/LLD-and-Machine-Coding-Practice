using System;
using MovieTicketBooking.Model;

namespace MovieTicketBooking.Services
{
    public class TheatreService
    {
        Dictionary<string, Theatre> theatres = new();
        Dictionary<string, Screen> screens = new();
        Dictionary<string, Seat> seats = new();

        public string AddTheatre(string id, string name)
        {
            if(theatres.ContainsKey(id))
            {
                throw new Exception("threatre with this id already exists");
            }
            theatres.Add(id, new Theatre(id, name));
            return id;
        }
        public string AddScreen(string id, string theatreId)
        {
            if(screens.ContainsKey(id))
            {
                throw new Exception("screen with this id already exists");
            }
            if(!theatres.ContainsKey(theatreId))
            {
                throw new Exception("threatre with this id not exists");
            }
            Screen screen = new Screen(id, theatres.GetValueOrDefault(id));
            screens.Add(id, screen);
            theatres.GetValueOrDefault(theatreId).AddScreen(screen);
            return id;
        }
        public string AddSeat(int seatNo, int rowNo, string ScreenId)
        {
            if(!screens.ContainsKey(ScreenId))
            {
                throw new Exception("screen with this id not exists");
            }
            string id = Guid.NewGuid().ToString();
            Seat seat = new Seat(id, rowNo, seatNo);
            seats.Add(id, seat);
            screens.GetValueOrDefault(ScreenId).AddSeat(seat);
            return id;
        }
        public Screen GetScreen(string screenId)
        {
            if(!screens.ContainsKey(screenId))
            {
                throw new Exception("screen with this id not exists");
            }
            return screens.GetValueOrDefault(screenId);
        }
        public Seat GetSeat(string seatId)
        {
            if(!seats.ContainsKey(seatId))
            {
                throw new Exception("seat with this id not exists");
            }
            return seats.GetValueOrDefault(seatId);
        }
    }
}