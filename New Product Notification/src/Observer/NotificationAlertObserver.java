package Observer;

import Observables.StockObservavle;

public class NotificationAlertObserver<T> implements Observer {

    StockObservavle<T> stockObservavle;
    String number;

    public NotificationAlertObserver(StockObservavle<T> stockObservavle, String number) {
        this.stockObservavle = stockObservavle;
        this.number = number;
    }

    @Override
    public void update() {
        System.out.println(
                "Notification Triggerred to number " + number + " since new stocks added");
    }

}
