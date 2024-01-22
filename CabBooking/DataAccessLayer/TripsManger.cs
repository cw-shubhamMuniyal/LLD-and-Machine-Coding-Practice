using CabBooking.Model;
using CabBooking.Stratergies;
using Exceptions;

namespace CabBooking.DataAccessLayer
{
    class TripManager
    {
        CabManager _cabManager; 
        RiderManager _riderManager;
        IPriceStratergy _priceStratergy;
        IMatchCabToRiderStratergy _matchCabToRiderStratergy;
        public TripManager(CabManager cabManager,
        RiderManager riderManager,
        IPriceStratergy priceStratergy,
        IMatchCabToRiderStratergy matchCabToRiderStratergy)
        {
            _riderManager = riderManager;
            _cabManager = cabManager;
            _priceStratergy = priceStratergy;
            _matchCabToRiderStratergy = matchCabToRiderStratergy;
        }
        const int _radius = 10;
        Dictionary<string, List<Trip>> tripsByRider = new();
        public void CreateTrip(Rider rider, Location source, Location destination)
        {
            // get all cabs within 10km distance
            var closeBycabs = _cabManager.GetCabsWithinDistance(source, _radius);
            var idleCloseByCabs = closeBycabs.FindAll(cab => cab.Status == DriverStatus.Idle);
            Cab selectedCab = _matchCabToRiderStratergy.SelectCab(idleCloseByCabs);
            if(selectedCab == null)
            {
                throw new CabNotFoundException();
            }
            double price = _priceStratergy.FindPrice(source, destination);
            Trip trip = new Trip(source, destination, price, selectedCab.Id, rider.Id, TripStatus.InProgress);
            selectedCab.SetCurrentTrip(trip);
            selectedCab.SetStatus(DriverStatus.Active);
            List<Trip> trips; 
            if(!tripsByRider.TryGetValue(rider.Id, out trips))
            {
                trips = new();
            }
            trips.Add(trip);
            tripsByRider.Add(rider.Id, trips);
        }
        public List<Trip> GetRiderTripsHistory(string riderId)
        {
            return tripsByRider.GetValueOrDefault(riderId);
        }
        public void EndTrip(string cabId)
        {
            Cab cab = _cabManager.Get(cabId);
            if(cab == null)
            {
                throw new CabNotFoundException();
            }
            cab.EndTrip();
        }
    }
}