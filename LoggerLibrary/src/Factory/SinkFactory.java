package Factory;

import Enum.SinkType;
import Logic.ConsoleSink;
import Logic.FileSink;
import Logic.Sink;

public class SinkFactory {
    public static Sink getSink(SinkType sinkType) {
        switch (sinkType) {
            case SinkType.FILE:
                return new FileSink();
            case SinkType.CONSOLE:
                return new ConsoleSink();
            default:
                return null;
        }
    }
}
