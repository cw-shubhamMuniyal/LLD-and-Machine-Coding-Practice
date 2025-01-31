import java.util.ArrayList;
import java.util.List;

public class ChessMoveCaretaker {

    private List<ChessMoveMemento> history = new ArrayList<>();

    public void save(ChessMoveOriginator chessMoveOriginator) {
        this.history.add(chessMoveOriginator.save());
    }

    public void undo(ChessMoveOriginator chessMoveOriginator) {
        if (!history.isEmpty()) {
            ChessMoveMemento lastState = this.history.removeLast();
            chessMoveOriginator.restore(lastState);

        }
    }

}
