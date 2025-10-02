package org.example;

import java.util.List;
import java.util.ArrayList;

public class Broker implements Observable {
    private List<Observer> observers = new ArrayList<>();


    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer o : observers) {
            o.update(message);
        }
    }

    public void setStatus(String status) {
        System.out.println("The stock market is: " + status);
        notifyObservers("The stock market is: " + status);
    }
}
