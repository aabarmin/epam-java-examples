package com.epam.lesson.exceptions;

public class StaticInit {
    public static void main(String[] args) {
        System.out.println("Hello");
        try {
            System.out.println(AnotherClass.j);
        } catch (Error e) {
            System.out.println(AnotherClass.j);
            e.printStackTrace();
        }
        System.out.println("Bye");
    }
}
