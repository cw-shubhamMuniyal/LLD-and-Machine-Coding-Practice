import Observables.IphoneStockObservable;
import Observables.StockObservavle;
import Observer.EmailNotificationAlertObserver;
import Observer.Observer;

public class Store {
    public static void main(String[] args) throws Exception {
        System.out.println("Notification sent after new Product Addition");

        // Subject to be observed: in this case, iphone stocks
        StockObservavle<Integer> stockObservavle = new IphoneStockObservable();

        // Observers to be notified by email or phone number when new stocks added
        Observer observer1 = new EmailNotificationAlertObserver<Integer>(stockObservavle, "abc@gmail.com");
        Observer observer2 = new EmailNotificationAlertObserver<Integer>(stockObservavle, "xyz@gmail.com");
        Observer observer3 = new EmailNotificationAlertObserver<Integer>(stockObservavle, "9876543210");

        stockObservavle.add(observer1);
        stockObservavle.add(observer2);
        stockObservavle.add(observer3);

        stockObservavle.setData(200);
        stockObservavle.setData(0);
        stockObservavle.setData(200);




    }
}
