import enums.LogLevel;


public class Logger {
    public static void main(String[] args) throws Exception {
        System.out.println("Learning Chain of responsibility with logger example!");

        LogProcessor infLogProcessor = new InfoLogProcessor(null, LogLevel.INFO.getLevel());
        LogProcessor errorLogProcessor = new ErrorLogProcessor(infLogProcessor, LogLevel.ERROR.getLevel());
        LogProcessor logProcessor = new DebugLogProcessor(errorLogProcessor, LogLevel.DEBUG.getLevel());

        logProcessor.logMessage("Testing COR design pattern with debug message", LogLevel.DEBUG.getLevel());
        System.out.println();

        logProcessor.logMessage("Testing COR design pattern with error message", LogLevel.ERROR.getLevel());
        System.out.println();

        logProcessor.logMessage("Testing COR design pattern with info message", LogLevel.INFO.getLevel());

    }
}
