package com.epam.lesson.lambdas;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class HalfLifeClient1 {
    public static void main(String[] args) {
        // 1. name              // -
        // 2. arguments         // +
        // 3. body              // +
        // 4. return type       // -

        final Thread thread = new Thread(() -> System.out.println("Hello from thread"));
        thread.start();
        System.out.println("Hello from main");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10);

        // external iterator
        final Iterator<Integer> iterator = numbers.iterator();

        // internal iterator
//        numbers.forEach(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) {
//                System.out.println(integer);
//            }
//        });
        // numbers.forEach(System.out::println);
        numbers.stream()
                .map(i -> i * 2)
                .forEach(System.out::println);

        System.out.println(" 1. ----- ");
        // int result = 0;
        for (Integer number : numbers) {
            if (number > 3 && number % 2 == 0) {
                // result = number;
                break;
            }
        }

        System.out.println(" 2. ----- ");
        final String reduce = numbers.stream()
                .filter(HalfLifeClient1::isGT3)
                .filter(HalfLifeClient1::isEVEN)
                .map(i -> String.valueOf(i))
                .map(i -> i + "___")
                .reduce("", (a, b) -> a + b);
        System.out.println(reduce);
    }

    public static int sum(int prev, int cur) {
        return prev + cur;
    }

    public static boolean isGT3(int i) {
        System.out.println("isGT3");
        return i > 3;
    }

    public static boolean isEVEN(int i) {
        System.out.println("isEVEN");
        return i % 2 == 0;
    }
}
