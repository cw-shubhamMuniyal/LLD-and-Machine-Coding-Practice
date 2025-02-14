import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class LeakyBucket implements RateLimiter {

    int capacity;
    BlockingQueue<String> requests;

    LeakyBucket(int capacity) {
        this.capacity = capacity;
        requests = new LinkedBlockingQueue<>(capacity);
    }

    @Override
    public boolean grantAccess(String id) {

        if (requests.remainingCapacity() > 0) {
            adjustRequest(id);
            return true;
        }
        return false;
    }

    private void adjustRequest(String id) {
        if (requests.remainingCapacity() > 0) {
            requests.add(id);
        }
    }

    private void processRequests() {

        requests.remove();

    }
}
