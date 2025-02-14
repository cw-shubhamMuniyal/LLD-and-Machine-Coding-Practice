import java.util.*;

public class UserBucketCreator {

    Map<String, RateLimiter> userBucket;

    UserBucketCreator() {
        this.userBucket = new HashMap<>();
    }

    void addUserBucket(String id, RateLimiter rateLimiter) {
        userBucket.put(id, rateLimiter);
    }

    void grantApplication(String id) {
        RateLimiter rateLimiter = userBucket.get(id);
        boolean isAccessGranted = rateLimiter.grantAccess(id);

        if (isAccessGranted) {
            System.out.println("Access granted for thread" + Thread.currentThread().getName() + " and user id " + id);
        }
        else {
            System.out.println("Access not granted for thread" + Thread.currentThread().getName() + " and user id " + id);
        }
    }
}
