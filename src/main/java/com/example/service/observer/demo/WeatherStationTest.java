package com.example.service.observer.demo;

/**
 * Created by baota on 2018/2/11.
 */

public class WeatherStationTest {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
        weatherData.setMeaturements(80,70,60);
    }

}
