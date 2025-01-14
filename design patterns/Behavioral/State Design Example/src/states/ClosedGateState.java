package states;

import gate.Gate;

public class ClosedGateState implements GateState {

    Gate gate;

    public ClosedGateState(Gate gate) {
        this.gate = gate;
    }

    @Override
    public void paymentSuccess() {
        System.out.println("payment successful! Let user in!");
        this.gate.updateState(new OpenGateState(gate));
    }


    @Override
    public void paymentFailed() {
        System.out.println("Payment failed! Insufficient fund!");
    }

    @Override
    public void initiatedPayment() {
        System.out.println("payment is getting processed. Please wait a moment!");
    }

    @Override
    public void enterUser() {
        System.out.println("User not allowed to enter until payment is successful!");
    }}
