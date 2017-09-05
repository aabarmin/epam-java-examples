package com.epam.lesson.varargs;

import java.util.Arrays;
import java.util.List;

public class Varargs {
    public static void method(int... args) {
        System.out.println("int...");
        for (int arg : args) {
            System.out.println(arg);
        }
    }

    public static void method(String... args) {
        System.out.println("String...");
        for (String arg : args) {
            System.out.println(arg);
        }
    }

    public static void method(int value1) {
        System.out.println("value1");
    }

    public static void method(int value1, int value2) {
        System.out.println("value2");
    }

    public static void method(int value1, int value2, int value3) {
        System.out.println("value3");
    }

    public static void main(String[] args) {
        method(1);
        method(1, 2);
        method(1, 2, 3);
        method(1, 2, 3, 4);

        final List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
//

//        int[] m = {1, 2, 3, 4};
//        method(m);
//        Integer[] m1 = {1, 2, 3, 4};
//        method(m1);
        // method("1a", "2a", "3a");
        // method((Integer) null);
    }
}
