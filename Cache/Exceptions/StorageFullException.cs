namespace Exceptions
{
    public class StorageFullException : SystemException
    {
        public StorageFullException(string message) : base(message)
        {
        }
    }
}