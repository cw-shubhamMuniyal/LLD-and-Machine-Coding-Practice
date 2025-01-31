public class ChessMove {
    public static void main(String[] args) {

        System.out.println("Learning Memento design pattern with example!");
        System.out.println("____________________________________________!");

        ChessMoveOriginator chessMoveOriginator = new ChessMoveOriginator();
        ChessMoveCaretaker chessMoveCaretaker = new ChessMoveCaretaker();

        ChessMoveState chessMoveState = new ChessMoveState("Knight", "E4");
        chessMoveOriginator.placeMove(chessMoveState);
        chessMoveCaretaker.save(chessMoveOriginator);

        chessMoveState = new ChessMoveState("Bishop", "E5");
        chessMoveOriginator.placeMove(chessMoveState);
        chessMoveCaretaker.save(chessMoveOriginator);

        chessMoveState = new ChessMoveState("Queen", "A1");
        chessMoveOriginator.placeMove(chessMoveState);
        System.out.println("Current state: " + chessMoveOriginator.getState().toString());

        chessMoveCaretaker.undo(chessMoveOriginator);
        System.out.println("After Undo: " + chessMoveOriginator.getState().toString());

        chessMoveCaretaker.undo(chessMoveOriginator);
        System.out.println("After Another Undo: " + chessMoveOriginator.getState().toString());
    }
}