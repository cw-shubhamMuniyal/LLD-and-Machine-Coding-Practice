namespace Logic
{
    public interface IRateLimiter
    {
        public bool GrantAccess();
    }
}