public class ChessMoveOriginator {

    private ChessMoveState state;

    public ChessMoveState getState() {
        return state;
    }

    public void placeMove(ChessMoveState state) {
        this.state = state;
    }

    public ChessMoveMemento save() {
        return new ChessMoveMemento(state);
    }

    public void restore(ChessMoveMemento memento) {
        state.setPiece(memento.getBoardState().getPiece());
        state.setPosition(memento.getBoardState().getPosition());
    }

}
