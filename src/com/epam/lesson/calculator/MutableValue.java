package com.epam.lesson.calculator;

public class MutableValue {
    private ImmutableValue delegate = new ImmutableValue(10);

    public int getValue() {
        System.out.println("Value has got");
        return delegate.getValue();
    }
}
