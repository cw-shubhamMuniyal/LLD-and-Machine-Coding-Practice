public class InfoLogProcessor extends LogProcessor {

    public InfoLogProcessor(LogProcessor nextLogProcessor, int level) {
        super(nextLogProcessor, level);
    }

    @Override
    void write(String message) {
        System.out.println("logging " + message + " with level info");
    }

}
