package com.example.designpatterns.behavioral.observer;

public class ConsoleDisplay implements WeatherObserver {
    @Override
    public void update(String weather) {
        System.out.println("Console Display: " + weather);
    }
}
