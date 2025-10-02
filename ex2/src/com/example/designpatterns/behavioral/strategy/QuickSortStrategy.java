package com.example.designpatterns.behavioral.strategy;

import java.util.Arrays;

public class QuickSortStrategy implements SortStrategy {
    @Override
    public void sort(int[] numbers) {
        Arrays.sort(numbers);
        System.out.println("Sorted using QuickSort: " + Arrays.toString(numbers));
    }
}
