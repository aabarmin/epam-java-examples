package com.epam.lesson.arrays;

public class ArrayStorage {
    public static void main(String[] args) {
        Integer[] integers = new Integer[10];
        Number[] numbers = integers;

        int[] arr = {10, 20, 30};

        integers[0] = 10;
        // integers[1] = 1.1;

        numbers[0] = 10;
        numbers[1] = 1.1f;
    }
}
