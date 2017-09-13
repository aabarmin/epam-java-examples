package com.epam.lesson.interfaces.java8;

public class Java8InterfaceClient {
    public static void main(String[] args) {
        InterfaceImplementation implementation = new InterfaceImplementation();
        System.out.println(implementation.getHello());

        FirstInterface firstInterface = (FirstInterface) implementation;
        System.out.println(firstInterface.getHello());
        System.out.println(firstInterface.getHello("Vasya"));

        System.out.println(
                FirstInterface.getName()
        );

        System.out.println(
                implementation.getHello(3)
        );
    }
}

interface SecondInterface {
    default String getHello(int value) {
        return "Hello, Snow, " + value + " times";
    }

    default String getHello() {
        return "Hello from future";
    }
}

interface FirstInterface {
    default String getHello() {
        return "Hello, Java8";
    }

    default String getHello(String who) {
        return "Hello, " + who;
    }

    static String getName() {
        return "John Snow";
    }
}

class InterfaceImplementation implements FirstInterface, SecondInterface {
    @Override
    public String getHello() {
        return "Hello, Tirion";
    }
}