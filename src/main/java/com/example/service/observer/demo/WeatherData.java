package com.example.service.observer.demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by baota on 2018/2/11.
 */
@Component
public class WeatherData implements Subject{

    private ArrayList observers;
    private float temp;
    private float humidity;
    private float pressure;

    public WeatherData(){
        observers = new ArrayList();

    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);

    }

    @Override
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if (i >= 0){

            observers.remove(i);
        }

    }

    @Override
    public void notifyObserver() {
        for (int i = 0;i < observers.size(); i++) {
            Observer observer  = (Observer) observers.get(i);
            observer.update(temp, humidity, pressure);
        }

    }


    public  void meaturementsChanged(){
        this.notifyObserver();
    }

    public void setMeaturements(float temp, float humidity, float pressure){
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        meaturementsChanged();
    }
}
