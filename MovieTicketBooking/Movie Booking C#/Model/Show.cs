using System.Data.Common;

namespace MovieTicketBooking.Model
{
    public class Show
    {
        string Id;
        Movie Movie;
        int DurationInMin;
        DateTime StartTime;
        public Screen Screen { get; }
        public Show(string id, Movie movie, int durationInMins, DateTime startTime, Screen screen)
        {
            this.Id = id;
            this.Movie = movie;
            this.DurationInMin = durationInMins;
            this.StartTime = startTime;
            this.Screen = screen;
        }
    }
}