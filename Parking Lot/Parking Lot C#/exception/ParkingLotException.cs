namespace Exceptions
{

    /**
     * Generic exception for general parking lot exceptions.
     */
    public class ParkingLotException : Exception
    {

        public ParkingLotException()
        {
        }

        public ParkingLotException(String message)
        {
            base.InnerException.ToString();
        }
    }
}