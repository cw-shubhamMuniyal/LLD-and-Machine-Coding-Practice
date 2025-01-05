package Logic;

import java.util.Map;

import Entity.Message;

public interface Sink {
    void logMessage(Message message);

    void addConfig(Map<String, String> configMap);
}
