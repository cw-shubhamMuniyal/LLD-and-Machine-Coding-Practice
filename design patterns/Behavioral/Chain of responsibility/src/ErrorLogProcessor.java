public class ErrorLogProcessor extends LogProcessor {

    public ErrorLogProcessor(LogProcessor nextLogProcessor, int level) {
        super(nextLogProcessor, level);
    }

    @Override
    void write(String message) {
        System.out.println("logging " + message + " with level error");
    }

}
