package com.example.designpatterns;

import com.example.designpatterns.behavioral.observer.*;
import com.example.designpatterns.behavioral.strategy.*;

public class Main {
    public static void main(String[] args) {
        // Observer test
        WeatherStation station = new WeatherStation();
        station.addObserver(new ConsoleDisplay());
        station.setWeather("Sunny");

        // Strategy test
        SortingContext context = new SortingContext(new QuickSortStrategy());
        context.sort(new int[]{5, 2, 9, 1});
    }
}
