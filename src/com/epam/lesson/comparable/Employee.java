package com.epam.lesson.comparable;

import com.epam.lesson.interfaces.CommonEmployee;

import java.util.Arrays;

public class Employee implements Comparable<Employee> {
    private final String firstName;
    private final String lastName;
    private final int age;

    public Employee(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public int compareTo(Employee o) {
        return (firstName + "_" + lastName + "_" + age).compareTo(
                o.firstName + "_" + o.lastName + "_" + o.age
        );
    }

    public static void main(String[] args) {
        Employee[] collection = {
                new Employee("Aaaa", "BB", 10),
                new Employee("Bbbb", "BB", 20),
                new Employee("Bbbb", "AA", 5)
        };
        Arrays.sort(collection);
        System.out.println(Arrays.toString(collection));
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}
