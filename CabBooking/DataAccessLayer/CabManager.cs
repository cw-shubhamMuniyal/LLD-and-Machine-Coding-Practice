using CabBooking.Model;
using Exceptions;

namespace CabBooking.DataAccessLayer
{
    class CabManager
    {
        Dictionary<string, Cab> Cabs = new Dictionary<string, Cab>();
        public void RegisterCab(Cab cab)
        {
            if(Cabs.ContainsKey(cab.Id))
            {
                throw new CabAlreadyExistsException();
            }
            else
            {
                Cabs.Add(cab.Id, cab);
            }
        }
        public List<Cab> GetCabsWithinDistance(Location riderLocation, double radius)
        {
            List<Cab> cabs= new List<Cab>();
            Double distance;
            foreach(Cab cab in Cabs.Values)
            {
                Double.TryParse(cab.CurrentLocation.GetDistance(riderLocation), out distance);
                if(distance <= radius)
                {
                    cabs.Add(cab);
                }
            }
            return cabs;
        }
        public Cab Get(string id)
        {
            if(!Cabs.ContainsKey(id))
            {
                throw new CabAlreadyExistsException();
            }
            else
            {
                Cab cab;
                Cabs.TryGetValue(id, out cab);
                return cab;
            }
        }
    }
}