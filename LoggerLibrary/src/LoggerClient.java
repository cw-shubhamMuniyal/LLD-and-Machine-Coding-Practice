import java.util.Map;
import Entity.Configuration;
import Enum.Level;
import Logic.ConfigLoader;
import Logic.ConsoleSink;
import Logic.Logger;

public class LoggerClient {
    public static void main(String[] args) throws Exception {
        Configuration configuration = new Configuration();

        // simulating file logging
        runFileLogger(configuration);
        // simulating console logging with user implemented Sink
        runConsoleLogger(configuration);

    }

    private static void runFileLogger(Configuration configuration) throws InterruptedException {
        String configString = "ts_format:dd/MM/yyyy hh-mm-ss\n"
                + "log_level:DEBUG\n"
                + "sink_type:FILE\n"
                + "file_location:application.log\n"
                + "max_file_size=2000";
        Map<String, String> configMap = ConfigLoader.loadConfig(configString);
        configuration.setConfigMap(configMap);

        Logger logger = Logger.getInstance();
        logger.setConfig(configuration);

        // Create and start multiple threads to log messages
        Thread thread1 = new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    logger.log("Empty txnIds Nothing to fetch " + i, Level.DEBUG, "com.java.thread1", "987", "google");
                    Thread.sleep(100); // Sleep to simulate some processing time
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    logger.log("No user found for phone number " + i, Level.DEBUG, "com.java.thread2", "498",
                            "meta");
                    Thread.sleep(100); // Sleep to simulate some processing time
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Start threads
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

    private static void runConsoleLogger(Configuration configuration) throws InterruptedException {
        String configString = "ts_format:dd/MM/yyyy hh-mm-ss\n"
                + "log_level:ERROR";
        Map<String, String> configMap = ConfigLoader.loadConfig(configString);
        configuration.setConfigMap(configMap);

        Logger logger = Logger.getInstance();
        // Allowing user to provide implementation of sink
        logger.setConfig(configuration);
        logger.addSink(Level.ERROR, new ConsoleSink());

        // Create and start multiple threads to log messages
        Thread thread1 = new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    logger.log("Empty txnIds Nothing to fetch " + i, Level.ERROR, "com.java.thread1", "987", "google");
                    Thread.sleep(100); // Sleep to simulate some processing time
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    logger.log("No user found for phone number " + i, Level.ERROR, "com.java.thread2", "498",
                            "meta");
                    Thread.sleep(100); // Sleep to simulate some processing time
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Start threads
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
