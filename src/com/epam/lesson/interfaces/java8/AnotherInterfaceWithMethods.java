package com.epam.lesson.interfaces.java8;

public interface AnotherInterfaceWithMethods {
    default String getName(int value) {
        return "Aaaa";
    }

    static void main(String[] args) {
        System.out.println("Hello, world!");
    }
}
