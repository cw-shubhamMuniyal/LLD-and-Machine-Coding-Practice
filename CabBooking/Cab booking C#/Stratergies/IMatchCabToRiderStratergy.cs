using CabBooking.Model;

namespace CabBooking.Stratergies
{
    interface IMatchCabToRiderStratergy
    {
        Cab SelectCab(List<Cab> cabs);
    }
}