package com.epam.lesson.generics.wrong;

public class GenericClass<T> {
    private T value;

    public GenericClass() {
    }

    public GenericClass(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
