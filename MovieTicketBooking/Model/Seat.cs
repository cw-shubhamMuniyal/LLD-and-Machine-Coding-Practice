namespace MovieTicketBooking.Model
{
    public class Seat
    {
        public string Id { get; }
        int RowNo;
        int SeatNo;
        public Seat(string id, int rowNo, int seatNo)
        {
            this.Id = id;
            this.SeatNo = seatNo;
            this.RowNo = rowNo;
        }
    }
}