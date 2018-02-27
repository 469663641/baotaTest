package com.example.service.observer.demo;

/**
 * Created by baota on 2018/2/11.
 */
public class CurrentConditionDisplay implements Observer, DisplayElement {

    private Subject weatherData;
    private float temp;
    private float humidity;
    private float pressure;

    public CurrentConditionDisplay(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }


    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();

    }

    @Override
    public void display() {
        System.err.println("temp:"+temp+"humidity:"+humidity+"pressure:"+pressure);

    }
}
