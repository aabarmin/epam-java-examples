package com.epam.lesson.lambdas;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

public class LambdaExample {
    private int value = 10;

    private void method() {
        final int some = 20;
        final Thread thread = new Thread(() -> {
            this.value = 20;
            System.out.println(some);
        });
        thread.start();
    }

    public static void sayHello() {
        System.out.println("Hello from another thread");
    }

    public static boolean isGT2(int v) {
        return v > 2;
    }

    public static void main(String[] args) {
        // 1. name
        // 2. body
        // 3. arguments
        // 4. return type

        Thread thread = new Thread(() -> System.out.println("Hello!"));
        thread.start();

        System.out.println("Main thread");

        final Collection<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.stream()
                .filter(LambdaExample::isGT2)
                .map(i -> i * 2)
                .forEach(i -> System.out.println(i));

        FInterface impl = () -> System.out.println("111");
    }
}
