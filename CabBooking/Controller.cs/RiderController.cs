using CabBooking.DataAccessLayer;
using CabBooking.Model;

namespace CabBooking.Controller
{
    class RiderController
    {
        RiderManager _riderManager;
        TripManager _tripManager;
        public RiderController(RiderManager riderManager, TripManager tripManager)
        {
            _riderManager = riderManager;
            _tripManager = tripManager;
        }
        public bool Register(string id, string mobile)
        {
            try
            {
                _riderManager.RegisterRider(id, mobile);
            }
            catch (Exception exception)
            {
                return false;
            }
            return true;
        }
        public void BookCab(string riderId, Location source, Location destination)
        {
            _tripManager.CreateTrip(_riderManager.Get(riderId), source, destination);
        }
        public List<Trip> GetTripsHistory(string riderId)
        {
            return _tripManager.GetRiderTripsHistory(riderId);
        }
    }
}