using MovieTicketBooking.Model;
using MovieTicketBooking.Services;

namespace MovieTicketBooking.Providers
{
    public class InMemorySeatLockProvider : ISeatLockProvider
    {
        Dictionary<Show, Dictionary<Seat, SeatLock>> _locks = new();
        int _lockTimeout;
        public InMemorySeatLockProvider(int lockTimeout)
        {
            _lockTimeout = lockTimeout;
        }
        public List<Seat> GetLockedSeats(Show show)
        {
            List<Seat> seats = new();
            if(!_locks.ContainsKey(show))
            {
                return seats;
            }
            var allSeats = _locks.GetValueOrDefault(show).Keys;
            foreach(var seat in allSeats)
            {
                if(isSeatLocked(show, seat))
                {
                    seats.Add(seat);
                }
            }
            return seats;
        }

        public void LockSeats(Show show, List<Seat> seats, string user)
        {
            foreach (Seat seat in seats)
            {
                if (isSeatLocked(show, seat))
                {
                    throw new Exception("seat is locked already");
                }
            }
            foreach (Seat seat in seats)
            {
                lockSeat(user, seat, show, _lockTimeout);
            }
        }

        private void lockSeat(string user, Seat seat, Show show, int timeoutInSeconds)
        {
            SeatLock seatLock = new SeatLock(user, seat, show, timeoutInSeconds, DateTime.Now);
            if (!_locks.ContainsKey(show))
            {
                _locks.Add(show, new Dictionary<Seat, SeatLock>());
            }
            _locks.GetValueOrDefault(show).Add(seat, seatLock);
        }
        public void UnlockSeat(Show show, List<Seat> seats, string user)
        {
            foreach (Seat seat in seats)
            {
                if(ValidateLock(show, seat, user))
                {
                    unlockSeat(show, seat);
                }
            }
        }

        public bool ValidateLock(Show show, Seat seat, string user)
        {
            return isSeatLocked(show, seat) &&
            _locks.GetValueOrDefault(show).GetValueOrDefault(seat).LockedBy.Equals(user);
        }

        private void unlockSeat(Show show, Seat seat)
        {
            if (!_locks.ContainsKey(show))
            {
                return;
            }
            _locks.GetValueOrDefault(show).Remove(seat);
        }

        private bool isSeatLocked(Show show, Seat seat)
        {
            return _locks.ContainsKey(show) &&
            _locks.GetValueOrDefault(show).ContainsKey(seat) &&
            !_locks.GetValueOrDefault(show).GetValueOrDefault(seat).isLockExpired();
        }
    }
}