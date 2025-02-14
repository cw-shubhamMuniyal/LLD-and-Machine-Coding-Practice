import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Learning about rate limiters!");
        System.out.println("_____________________________");


        UserBucketCreator userBucketCreator = new UserBucketCreator();
        userBucketCreator.addUserBucket("1", new SlidingWindowLog(10, 1));
        userBucketCreator.addUserBucket("2", new SlidingWindowLog(10, 1));

        try (ExecutorService executors = Executors.newFixedThreadPool(12)) {

            for (int i = 0; i <= 11; i++) {
                executors.execute(() -> userBucketCreator.grantApplication("1"));
                executors.execute(() -> userBucketCreator.grantApplication("2"));
            }
            executors.shutdown();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}