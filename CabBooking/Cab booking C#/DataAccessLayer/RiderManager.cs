using CabBooking.Model;

namespace CabBooking.DataAccessLayer
{
    class RiderManager
    {
        Dictionary<string, Rider> Riders = new();
        public void RegisterRider(string id, string mobile)
        {
            if(Riders.ContainsKey(id))
            {

            }
            else
            {
                Riders.Add(id, new Rider(id, mobile));
            }
        }
        public Rider Get(string id)
        {
            Rider rider;
            bool isRiderAvailable = Riders.TryGetValue(id, out rider);
            if(!isRiderAvailable)
            {

            }
            return rider;
        }
    }
}