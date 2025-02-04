import java.util.Iterator;
import java.util.List;

public class StatesIterator implements Iterator<State> {

    private final List<State> states;
    private Integer index;

    public StatesIterator(List<State> states) {
        this.states = states;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return states.size() > index;
    }

    @Override
    public State next() {
        return states.get(index++);
    }
}
