namespace MovieTicketBooking.Model
{
    public class Movie
    {
        string Id;
        string Name;
        public Movie(string id, string name)
        {
            this.Id = id;
            this.Name = name;
        }
    }
}