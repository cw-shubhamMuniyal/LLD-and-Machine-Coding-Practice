public class ChessMoveMemento {

    private final ChessMoveState boardState;

    public ChessMoveMemento(ChessMoveState boardState) {
        this.boardState = boardState;
    }

    public ChessMoveState getBoardState() {
        return boardState;
    }

}
