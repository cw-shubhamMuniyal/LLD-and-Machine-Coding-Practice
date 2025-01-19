package Observer;

import Observables.StockObservavle;

public class EmailNotificationAlertObserver<T> implements Observer {

    StockObservavle<T> stockObservavle;
    String email;

    public EmailNotificationAlertObserver(StockObservavle<T> stockObservavle, String email) {
        this.stockObservavle = stockObservavle;
        this.email = email;
    }

    @Override
    public void update() {
        System.out.println(
                "Notification Triggerred to email " + email + " since new stocks added");
    }

}
