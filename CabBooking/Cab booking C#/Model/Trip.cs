namespace CabBooking.Model
{
    class Trip
    {
        Location Source;
        Location Destination;
        double Price;
        string RiderId;
        string CabId;
        public TripStatus Status { get; set; }

        public Trip(Location source, Location destination, double price, string cabId, string riderId, TripStatus status)
        {
            this.Source = source;
            this.Destination = destination;
            this.Price = price;
            this.RiderId = riderId;
            this.CabId = cabId;
            this.Status = status;
        }
    }
}

