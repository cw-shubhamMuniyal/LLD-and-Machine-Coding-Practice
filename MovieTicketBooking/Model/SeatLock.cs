namespace MovieTicketBooking.Model
{
    public class SeatLock
    {
        public string LockedBy { get; }
        public Seat Seat;
        public Show Show;
        int TimeoutInSeconds;
        DateTime LockTime;
        public SeatLock(string lockedBy, Seat seat, Show show, int timeoutInSeconds, DateTime lockTime)
        {
            this.LockedBy = lockedBy;
            this.Seat = seat;
            this.Show = show;
            this.TimeoutInSeconds = timeoutInSeconds;
            this.LockTime = lockTime;
        }
        public bool isLockExpired()
        {
            DateTime lockInstant = LockTime.ToUniversalTime().AddSeconds(TimeoutInSeconds);
            DateTime currentInstant = DateTime.UtcNow;
            return lockInstant < currentInstant;
        }
    }
}