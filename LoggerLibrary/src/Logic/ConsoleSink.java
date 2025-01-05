package Logic;

import java.util.Map;

import Entity.Message;

public class ConsoleSink implements Sink{

    @Override
    public synchronized void logMessage(Message message) {
        System.out.println(message.toString());
    }

    @Override
    public void addConfig(Map<String, String> configMap) {
        
    }
    
}
