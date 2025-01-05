package Entity;

import Enum.Level;

public class Message {
    private final String content;
    private final String namespace;
    private final Level level;
    private final String timeStamp;
    private final String trackingId;
    private final String hostName;

    public Message(String content, String namespace, Level level, String timeStamp, String trackingId, String hostName) {
        this.content = content;
        this.namespace = namespace;
        this.level = level;
        this.timeStamp = timeStamp;
        this.trackingId = trackingId;
        this.hostName = hostName;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getContent() {
        return content;
    }

    public Level getLevel() {
        return level;
    }

    public String getNamespace() {
        return namespace;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public String getHostName() {
        return hostName;
    }

    @Override
    public String toString() {
        return level + " [" + timeStamp + "]" + "    " + content + "        " + namespace + "       " + trackingId + "      " + hostName;
    }
}
