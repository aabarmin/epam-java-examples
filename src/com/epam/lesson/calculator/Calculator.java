package com.epam.lesson.calculator;

public class Calculator {
    public ImmutableValue multiplyTwo(ImmutableValue value) {
        return new ImmutableValue(value.getValue() * 2);
    }

    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = new String("Hello");

        System.out.println(s1 == s2.intern());
    }
}
