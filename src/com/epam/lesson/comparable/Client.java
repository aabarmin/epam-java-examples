package com.epam.lesson.comparable;

import java.util.Arrays;
import java.util.Collection;

public class Client {
    public static void main(String[] args) {
        final Employee[] collection = {
                new Employee("Aaaa", "BB", 10),
                new Employee("Bbbb", "BB", 20),
                new Employee("Bbbb", "AA", 5)
        };

        Arrays.sort(collection);
        System.out.println(Arrays.toString(collection));

        Arrays.sort(collection, new AscendingComparator());
        System.out.println(Arrays.toString(collection));

        Arrays.sort(collection, new DescendingComparator());
        System.out.println(Arrays.toString(collection));
    }
}
