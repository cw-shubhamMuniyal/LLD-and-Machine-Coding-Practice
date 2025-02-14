import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SlidingWindowLog implements RateLimiter {

    Queue<Long> requests;
    int capacity;
    Long timeInSeconds;

    SlidingWindowLog(int capacity, long timeInSeconds) {
        requests = new ConcurrentLinkedQueue<>();
        this.capacity = capacity;
        this.timeInSeconds = timeInSeconds;
    }

    @Override
    public boolean grantAccess(String id) {

        return adjustSlidingWindow();
    }

    private boolean adjustSlidingWindow() {

        long currentTimeInMillis = System.currentTimeMillis();

        if (requests.isEmpty()) {
            requests.offer(System.currentTimeMillis());
            return true;
        }

        Long fistRequestTimeInMillis = requests.peek();

        while ((currentTimeInMillis - fistRequestTimeInMillis.longValue()) / 1000 > timeInSeconds) {
            requests.poll();
            fistRequestTimeInMillis = requests.peek();
        }

        if (requests.size() < capacity) {
            requests.offer(System.currentTimeMillis());
            return true;
        }
        return false;
    }
}
