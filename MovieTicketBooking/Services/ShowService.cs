using MovieTicketBooking.Model;

namespace MovieTicketBooking.Services
{
    public class ShowService
    {
        Dictionary<string, Show> shows = new();

        public string AddShow(Movie movie, Screen screen, DateTime startTime, int durationInMins)
        {
            string showId = Guid.NewGuid().ToString();
            Show show = new Show(showId, movie, durationInMins, startTime, screen);
            shows.Add(showId, show);
            return showId;
        }
        public Show GetShow(string showId)
        {
            if(!shows.ContainsKey(showId))
            {
                throw new Exception("Show with this id is not avalilable");
            }
            return shows.GetValueOrDefault(showId);
        }
    }
}