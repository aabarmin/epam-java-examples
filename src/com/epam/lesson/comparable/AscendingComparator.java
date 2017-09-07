package com.epam.lesson.comparable;

import java.util.Comparator;

public class AscendingComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return (o1.getFirstName() + "_" + o1.getLastName() + "_" + o1.getAge()).compareTo(
                o2.getFirstName() + "_" + o2.getLastName() + "_" + o2.getAge()
        );
    }
}
