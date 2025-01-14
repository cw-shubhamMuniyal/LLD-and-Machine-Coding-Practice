package states;

import gate.Gate;

public class OpenGateState implements GateState {

    Gate gate;

    OpenGateState(Gate gate) {
        this.gate = gate;
    }

    @Override
    public void paymentSuccess() {
        System.out.println("Gate is already opened. Let the user in");
    }

    @Override
    public void paymentFailed() {
        System.out.println("Gate is already opened. Let the user in");
    }

    @Override
    public void initiatedPayment() {
        System.out.println("Gate is already opened. Let the user in");
    }

    @Override
    public void enterUser() {
        this.gate.updateState(new ClosedGateState(gate));
        System.out.println("User entered! Closing the gate.");
    }
}
