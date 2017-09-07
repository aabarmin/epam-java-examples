package com.epam.lesson.comparable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionClient {
    public static void main(String[] args) {
        final List<Employee> list = Arrays.asList(
                new Employee("Aaaa", "BB", 10),
                new Employee("Bbbb", "BB", 20),
                new Employee("Bbbb", "AA", 5)
        );

        Collections.sort(list);
        System.out.println(list);

        Collections.sort(list, new AscendingComparator());
        System.out.println(list);

        Collections.sort(list, new DescendingComparator());
        System.out.println(list);
    }
}
