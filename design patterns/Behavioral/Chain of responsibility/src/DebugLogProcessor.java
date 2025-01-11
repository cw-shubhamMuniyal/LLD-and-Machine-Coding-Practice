public class DebugLogProcessor extends LogProcessor {

    public DebugLogProcessor(LogProcessor nextLogProcessor, int level) {
        super(nextLogProcessor, level);
    }

    @Override
    void write(String message) {
        System.out.println("logging " + message + " with level debug");
    }

}
