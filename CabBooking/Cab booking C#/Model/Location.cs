namespace CabBooking.Model
{
    class Location
    {
        int XCordinate;
        int YCordinate;
        public Location(int xCordinate, int yCordinate)
        {
            this.XCordinate = xCordinate;
            this.YCordinate = yCordinate;
        }
        public string GetDistance(Location destination)
        {
            return Math.Sqrt(
            Math.Pow(this.XCordinate - destination.XCordinate, 2)
            +
            Math.Pow(this.YCordinate - destination.YCordinate, 2)
            ).ToString();
        }
    }
}

