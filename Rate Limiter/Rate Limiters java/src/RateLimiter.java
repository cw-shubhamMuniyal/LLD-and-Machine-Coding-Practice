public interface RateLimiter {

    boolean grantAccess(String id);
}
