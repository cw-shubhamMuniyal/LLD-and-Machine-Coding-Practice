public class Jump {

    private final JumpType type;
    private final int startPosition;
    private final int endPosition;

    public Jump(JumpType type, int startPosition, int endPosition) {
        this.type = type;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    public int getEndPosition() {
        return endPosition;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public JumpType getType() {
        return type;
    }
}
