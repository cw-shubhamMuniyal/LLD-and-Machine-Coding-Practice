package gate;

import states.ClosedGateState;
import states.GateState;

public class GateImpl implements  Gate {

    GateState state;

    public GateImpl() {
        this.state = new ClosedGateState(this);
    }

    @Override
    public void paymentSuccess() {
        state.paymentSuccess();
    }

    @Override
    public void paymentFailed() {
        state.paymentFailed();
    }

    @Override
    public void initiatedPayment() {
        state.initiatedPayment();
    }

    @Override
    public void enterUser() {
        state.enterUser();
    }

    @Override
    public void updateState(GateState gateState) {
        this.state = gateState;
    }
}
