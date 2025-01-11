public abstract class LogProcessor {

    LogProcessor nextLogProcessor;
    int level;

    public LogProcessor(LogProcessor nextLogProcessor, int level) {
        this.nextLogProcessor = nextLogProcessor;
        this.level = level;
    }

    void logMessage(String message, int level) {

        if (level >= this.level) {
            write(message);
        }

        if (nextLogProcessor != null) {
            nextLogProcessor.logMessage(message, level);
        }
    }

    abstract void write(String message);
}
