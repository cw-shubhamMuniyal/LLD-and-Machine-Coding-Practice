namespace CabBooking.Model
{
    class Cab
    {
        public string Id { get; }
        public Location CurrentLocation { get; private set; }
        public DriverStatus Status { get; private set; }
        string Mobile;
        public Trip Trip { get; private set; }

        public Cab(string id, Location location, string mobile, DriverStatus status)
        {
            this.Id = id;
            this.CurrentLocation = location;
            this.Mobile = mobile;
            this.Status = status;
        }

        public void SetLocation(Location location)
        {
            this.CurrentLocation = location;
        }
        public void SetCurrentTrip(Trip trip)
        {
            this.Trip = trip;
        }
        public void SetStatus(DriverStatus driverStatus)
        {
            this.Status = driverStatus;
        }
        public void EndTrip()
        {
            this.Trip.Status = TripStatus.Done;
            this.Trip = null;
        }
        public string Print()
        {
            return "Id " + Id.ToString() + " mobile number " + Mobile;
        }
    }
}

