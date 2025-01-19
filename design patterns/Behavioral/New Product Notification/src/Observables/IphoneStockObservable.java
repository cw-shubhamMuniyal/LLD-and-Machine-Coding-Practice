package Observables;

import java.util.ArrayList;
import java.util.List;

import Observer.Observer;

public class IphoneStockObservable implements StockObservavle<Integer> {

    List<Observer> observers = new ArrayList<Observer>();
    public Integer stockCount = 0;

    @Override
    public void add(Observer observer) {
        observers.add(observer);

    }

    @Override
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public Integer getData() {
        return stockCount;
    }

    @Override
    public void setData(Integer data) {

        if (stockCount == 0) {
            notifyObservers();
        }
        this.stockCount = data;

    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

}
