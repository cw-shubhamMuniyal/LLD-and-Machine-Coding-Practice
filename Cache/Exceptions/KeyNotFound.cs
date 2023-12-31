namespace Exceptions
{
    public class KeyNotFound : Exception
    {
        public KeyNotFound(string message)
        {
            Console.WriteLine(message);
        }
    }
}