namespace MovieTicketBooking.Model
{
    public class Screen
    {
        string Id { get; }
        public List<Seat> Seats { get; } = new List<Seat>();
        Theatre Theatre;
        public Screen(string id, Theatre theatre)
        {
            this.Id = id;
            this.Theatre = theatre;
        }
        public Screen(string id, List<Seat> seats, Theatre theatre)
        {
            this.Id = id;
            this.Seats = seats;
            this.Theatre = theatre;
        }
        public void AddSeat(Seat seat)
        {
            this.Seats.Add(seat);
        }
    }
}