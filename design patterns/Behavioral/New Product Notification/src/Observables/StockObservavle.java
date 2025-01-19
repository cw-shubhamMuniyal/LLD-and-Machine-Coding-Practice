package Observables;

import Observer.Observer;

public interface StockObservavle<T> {

    void add(Observer observer);

    void remove(Observer observer);

    T getData();

    void setData(T data);

    void notifyObservers();

}