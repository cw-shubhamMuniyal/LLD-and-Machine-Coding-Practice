package Logic;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import Entity.Configuration;
import Entity.Message;
import Enum.Level;
import Enum.SinkType;
import Factory.SinkFactory;
import Utility.StringValidation;

public class Logger {
    private static volatile Logger loggerInstance;
    private final Map<Level, Sink> sinks = new ConcurrentHashMap<>();
    private final Map<String, Object> locks = new ConcurrentHashMap<>();
    private SimpleDateFormat dateTimeFormat;

    private Logger() {
    }

    public static Logger getInstance() {
        if (loggerInstance == null) {
            synchronized (Logger.class) {
                if (loggerInstance == null) {
                    loggerInstance = new Logger();
                }
            }
        }
        return loggerInstance;
    }

    public synchronized void setConfig(Configuration config) {
        Map<String, String> configMap = config.getConfigMap();
        String tsFormat = configMap.getOrDefault("ts_format", "ddMMyyyyhhmmss");
        this.dateTimeFormat = new SimpleDateFormat(tsFormat);

        String sinkTypeStr = configMap.get("sink_type");
        if (StringValidation.isNotBlank((sinkTypeStr))) {
            SinkType sinkType = SinkType.valueOf(configMap.get("sink_type"));
            Sink sink = SinkFactory.getSink(sinkType);
            if (sink != null) {
                sink.addConfig(configMap);
                addSink(Level.valueOf(configMap.get("log_level")), sink);
            }
        }

    }

    public synchronized void addSink(Level level, Sink sink) {
        sinks.put(level, sink);
        locks.put(sink.getClass().getName(), new Object());
    }

    public void log(String content, Level level, String namespace, String trackingId, String hostName) {
        String timestamp = dateTimeFormat.format(new Date());
        Message message = new Message(content, namespace, level, timestamp, trackingId, hostName);
        Sink sink = sinks.get(level);
        if (sink != null) {
            Object lock = locks.get(sink.getClass().getName());
            synchronized (lock) {
                try {
                    sink.logMessage(message);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }

    }
}
