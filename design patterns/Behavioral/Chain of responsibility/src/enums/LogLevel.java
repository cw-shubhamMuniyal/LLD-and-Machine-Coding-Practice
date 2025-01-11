package enums;

public enum LogLevel {
    INFO(1),
    ERROR(2),
    DEBUG(3);

    LogLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    final int level;
}
