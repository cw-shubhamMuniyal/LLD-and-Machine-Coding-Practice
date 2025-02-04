import java.util.List;

public class StateAggregator implements Country {

    List<State> states;

    public StateAggregator(List<State> states) {
        this.states = states;
    }

    @Override
    public StatesIterator createIterator() {
        return new StatesIterator(states);
    }
}
