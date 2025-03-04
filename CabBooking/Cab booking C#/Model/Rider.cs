namespace CabBooking.Model
{
    class Rider
    {
        public string Id { get; }
        public string Mobile { get; }
        public Rider(string id, string mobile)
        {
            this.Id = id;
            this.Mobile = mobile;
        }
    }
}

