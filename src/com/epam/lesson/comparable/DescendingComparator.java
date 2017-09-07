package com.epam.lesson.comparable;

import java.util.Comparator;

public class DescendingComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return (o2.getFirstName() + "_" + o2.getLastName() + "_" + o2.getAge()).compareTo(
                o1.getFirstName() + "_" + o1.getLastName() + "_" + o1.getAge()
        );
    }
}
