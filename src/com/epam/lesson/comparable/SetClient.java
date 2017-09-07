package com.epam.lesson.comparable;

import java.util.Set;
import java.util.TreeSet;

public class SetClient {
    public static void main(String[] args) {
        Set<Employee> set = new TreeSet();
        set.add(new Employee("Aaaa", "BB", 10));
        set.add(new Employee("Bbbb", "BB", 20));
        set.add(new Employee("Bbbb", "AA", 5));

        System.out.println(set);

        set = new TreeSet<>(new DescendingComparator());

        set.add(new Employee("Aaaa", "BB", 10));
        set.add(new Employee("Bbbb", "BB", 20));
        set.add(new Employee("Bbbb", "AA", 5));

        System.out.println(set);
    }
}
