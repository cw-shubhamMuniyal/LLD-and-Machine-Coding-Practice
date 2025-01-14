import gate.Gate;
import gate.GateImpl;

public class PayToAccessGate {
    public static void main(String[] args) {

        System.out.println("Pay to Access Gate system using state Design pattern!");
        System.out.println("_____________________________________________________");

        Gate gate = new GateImpl();

        System.out.println("Initially gate is closed");

        gate.initiatedPayment();
        gate.paymentFailed();

        gate.initiatedPayment();
        gate.paymentSuccess();
        gate.paymentFailed();
        gate.enterUser();
    }
}