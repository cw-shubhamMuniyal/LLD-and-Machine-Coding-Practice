import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class TokenBucket implements RateLimiter {

    AtomicInteger capacity;
    AtomicLong lastRefillTimeInMillis;
    int refreshRate;
    int bucketCapacity;

    TokenBucket(int bucketCapacity, int refreshRate) {
        this.bucketCapacity = bucketCapacity;
        this.capacity = new AtomicInteger(bucketCapacity);
        this.capacity.set(bucketCapacity);
        this.refreshRate = refreshRate;
        this.lastRefillTimeInMillis = new AtomicLong(System.currentTimeMillis());
    }

    @Override
    public boolean grantAccess(String id) {

        adjustCapacity();
        if (capacity.get() > 0) {
            capacity.decrementAndGet();
            return true;
        }
        return false;
    }

    private void adjustCapacity() {

        long currentTimeInMillis = System.currentTimeMillis();
        int additionalTokens = (int) ((currentTimeInMillis - lastRefillTimeInMillis.get()) / 1000) * refreshRate;
        int newCapacity = Math.min(capacity.get() + additionalTokens, bucketCapacity);
        capacity.getAndSet(newCapacity);
        lastRefillTimeInMillis.getAndSet(currentTimeInMillis);
    }
}
