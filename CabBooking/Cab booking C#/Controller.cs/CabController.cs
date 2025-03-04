using CabBooking.DataAccessLayer;
using CabBooking.Model;
using Exceptions;

namespace CabBooking.Controller
{
    class CabController
    {
        CabManager _cabManager;
        TripManager _tripManager;
        public CabController(CabManager cabManager, TripManager tripManager)
        {
            _cabManager = cabManager;
            _tripManager = tripManager;
        }
        public bool Register(string id, Location location, string mobile)
        {
            try
            {
                _cabManager.RegisterCab(new Cab(id, location, mobile, DriverStatus.Idle));
            }
            catch (Exception exception)
            {
                return false;
            }
            return true;
        }
        public void EndTrip(string cabId)
        {
            _tripManager.EndTrip(cabId);
        }
        public void UpdateLocation(string cabId, Location newLocation)
        {
            Cab cab = _cabManager.Get(cabId);
            try
            {
                if (cab == null)
                {
                    throw new CabNotFoundException();
                }
                cab.SetLocation(newLocation);
            }
            catch
            {
                return;
            }
        }
        public void UpdateAvailability(string cabId, DriverStatus driverStatus)
        {
            Cab cab = _cabManager.Get(cabId);
            try
            {
                if (cab == null)
                {
                    throw new CabNotFoundException();
                }
                cab.SetStatus(driverStatus);
            }
            catch
            {
                return;
            }
        }
    }
}