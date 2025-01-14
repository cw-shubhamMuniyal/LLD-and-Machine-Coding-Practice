package states;

public interface GateState {

    void paymentSuccess();
    void paymentFailed();
    void initiatedPayment();
    void enterUser();

}
