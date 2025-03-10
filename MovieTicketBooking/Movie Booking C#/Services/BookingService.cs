using MovieTicketBooking.Model;
using MovieTicketBooking.Providers;

namespace MovieTicketBooking.Services
{
    public class BookingService
    {
        ISeatLockProvider _seatLockProvider;
        Dictionary<string, Booking> _bookings = new();
        public BookingService(ISeatLockProvider seatLockProvider)
        {
            _seatLockProvider = seatLockProvider;
        }
        public string CreateBooking(Show show, string user, List<Seat> seats)
        {
            if(isAnySeatAlreadyBooked(show, seats))
            {
                throw new Exception("seats are booked");
            }
            _seatLockProvider.LockSeats(show, seats, user);
            string id = Guid.NewGuid().ToString();
            Booking booking = new Booking(id, BookingStatus.Created, user, show, seats);
            _bookings.Add(id, booking);
            return id;
        }
        public void ConfrimBooking(string bookingId, string user)
        {
            if(!_bookings.ContainsKey(bookingId))
            {
                throw new Exception("Booking does not exists");
            }
            Booking booking = _bookings.GetValueOrDefault(bookingId);
            List<Seat> bookedSeats = booking.Seats;
            foreach(Seat seat in bookedSeats)
            {
                if(!_seatLockProvider.ValidateLock(booking.Show, seat, user))
                {
                    throw new Exception("Lock is not applied on seat with id "+  seat.Id);
                }
            }
            booking.Status = BookingStatus.Confirmed;
        } 
        private bool isAnySeatAlreadyBooked(Show show, List<Seat> seats)
        {
            List<Seat> bookedSeats = GetBookedSeats(show);
            foreach(Seat seat in seats)
            {
                if(bookedSeats.Contains(seat))
                {
                    return true;
                }
            }
            return false;
        }
        public List<Seat> GetBookedSeats(Show show)
        {
            List<Seat> seats = new();
            foreach(Booking booking in _bookings.Values)
            {
                if(booking.Show == show && booking.Status == BookingStatus.Confirmed)
                {
                    seats = booking.Seats;
                    return seats;
                }
            }
            return seats;
        }
        public Booking GetBooking(string id)
        {
            if(!_bookings.ContainsKey(id))
            {
                throw new Exception("Booking does not exists");
            }
            return _bookings.GetValueOrDefault(id);
        }
    }
}