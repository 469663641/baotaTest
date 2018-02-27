package com.example.service.observer.demo;

/**
 * Created by baota on 2018/2/11.
 */
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver();

}
