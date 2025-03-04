using CabBooking.Model;

namespace CabBooking.Stratergies
{
    class MatchCabToRiderDefaultStratergy : IMatchCabToRiderStratergy
    {
        public Cab SelectCab(List<Cab> cabs)
        {
            return cabs.FirstOrDefault();
        }
    }
}