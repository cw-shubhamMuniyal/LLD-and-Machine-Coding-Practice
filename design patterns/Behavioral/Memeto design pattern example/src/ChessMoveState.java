public class ChessMoveState {

    private String piece;

    private String position;

    public ChessMoveState(String piece, String position) {
        this.piece = piece;
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPiece() {
        return piece;
    }

    public void setPiece(String piece) {
        this.piece = piece;
    }

    @Override
    public String toString() {
        return "ChessMoveState{" +
                "piece='" + piece + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
