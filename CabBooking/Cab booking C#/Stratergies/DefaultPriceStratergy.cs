using CabBooking.Model;

namespace CabBooking.Stratergies
{
    class DefaultPriceStratergy : IPriceStratergy
    {
        const double _PRICEPERKM = 10.0;

        public double FindPrice(Location source, Location destination)
        {
            double price;
            double.TryParse(source.GetDistance(destination), out price);
            return price * _PRICEPERKM;
        }
    }
}