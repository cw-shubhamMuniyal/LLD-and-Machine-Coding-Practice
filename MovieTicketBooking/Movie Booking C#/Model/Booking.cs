namespace MovieTicketBooking.Model
{
    public class Booking
    {
        public BookingStatus Status { get; set; }
        string Id;
        public string User { get; }
        public Show Show { get; }
        public List<Seat> Seats { get; } = new();
        public Booking(string id, BookingStatus bookingStatus, string user, Show show, List<Seat> seats)
        {
            this.Id = id;
            this.Status = bookingStatus;
            this.User = user;
            this.Show = show;
            this.Seats = seats;
        }
    }
}