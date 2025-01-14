package gate;

import states.GateState;

public interface Gate {

    void paymentSuccess();
    void paymentFailed();
    void initiatedPayment();
    void enterUser();
    void updateState(GateState gateState);
}
