package com.epam.lesson.exceptions_lesson;

/**
 * @author ABarmin
 */
public class ArrayStoreExceptionClient {
    public static void main(String[] args) {
        Number[] numbers = new Integer[1];
        numbers[0] = 10.0;
    }
}
