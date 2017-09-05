package com.epam.lesson.calculator;

public class ImmutableValue implements Cloneable {
    private final int value;

    protected ImmutableValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ImmutableValue newInstance(ImmutableValue value) {
        return new ImmutableValue(value.getValue());
    }

    public static ImmutableValue newInstance(int a, int b) {
        return new ImmutableValue(a + b);
    }

    public static ImmutableValue newInstance(int value) {
        return new ImmutableValue(value);
    }

    @Override
    public String toString() {
        return "ImmutableValue{" +
                "value=" + value +
                '}';
    }
}
