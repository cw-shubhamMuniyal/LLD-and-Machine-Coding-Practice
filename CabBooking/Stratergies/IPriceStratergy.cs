using CabBooking.Model;

namespace CabBooking.Stratergies
{
    interface IPriceStratergy
    {
        Double FindPrice(Location source, Location destination);
    }
}