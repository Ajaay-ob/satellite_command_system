package com.example.designpatterns.behavioral.strategy;

public class SortingContext {
    private SortStrategy strategy;

    public SortingContext(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void sort(int[] numbers) {
        strategy.sort(numbers);
    }
}
