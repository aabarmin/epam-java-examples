package com.epam.lesson.generics.right;

public class DefaultGeneric<T> {
    private T value;

    public DefaultGeneric() {
    }

    public DefaultGeneric(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
