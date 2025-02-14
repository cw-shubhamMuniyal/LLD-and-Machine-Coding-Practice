namespace Logic
{
    public class UserBucketCreator
    {
        readonly Dictionary<string, SlidingWindow> UserBucketPair;
        public UserBucketCreator(string id)
        {
            UserBucketPair = new Dictionary<string, SlidingWindow>();
            UserBucketPair.Add(id, new SlidingWindow(1, 10));
        }
        public void GrantApplication(string id)
        {
            UserBucketPair.TryGetValue(id, out SlidingWindow slidingWindow);
            if(slidingWindow != null)
            {
                if(slidingWindow.GrantAccess())
                {
                    Console.WriteLine("Access granted, Processing Your Request");
                }
                else
                {
                    Console.WriteLine("You crossed your request limit, please try after some time");
                }
            }
        }
    }
}