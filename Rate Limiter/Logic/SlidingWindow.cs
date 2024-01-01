using System.Collections.Concurrent;

namespace Logic
{
    public class SlidingWindow : IRateLimiter
    {
        long SlidingWindowTimeInSeconds;
        int Capacity;
        readonly ConcurrentQueue<long> Window;
        public SlidingWindow(long slidingWindowTimeInSeconds, int capacity)
        {
            SlidingWindowTimeInSeconds = slidingWindowTimeInSeconds;
            Capacity = capacity;
            Window = new ConcurrentQueue<long>();
        }
        public bool GrantAccess()
        {
            long currentTime = DateTimeOffset.UtcNow.ToUnixTimeMilliseconds();
            AdjustWindow(currentTime);
            if(Window.Count < Capacity)
            {
                Window.Enqueue(currentTime);
                return true;
            }
            return false;
        }
        private void AdjustWindow(long currentTime)
        {
            if(Window.Count == 0)
            {
                return;
            }
            long timeElapsedInWindow = (currentTime-SlidingWindowTimeInSeconds)/1000;
            long time = Window.First();
            while(timeElapsedInWindow > time)
            {
                Window.TryDequeue(out long _);
                if(Window.Count == 0)
                {
                    return;
                }
                time = Window.First();
            }
        }
    }
}