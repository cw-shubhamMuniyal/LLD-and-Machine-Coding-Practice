using MovieTicketBooking.Model;

namespace MovieTicketBooking.Providers
{
    public interface ISeatLockProvider
    {
        void LockSeats(Show show, List<Seat> seats, string user);
        void UnlockSeat(Show show, List<Seat> seats, string user);
        bool ValidateLock(Show show, Seat seat, string user);
        List<Seat> GetLockedSeats(Show show);

    }
}