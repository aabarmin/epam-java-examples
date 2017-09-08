package com.epam.lesson.generics.wrong;

public class RestrictedGeneric<T> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void method(RestrictedGeneric<T> m) {
        System.out.println("Generic 1");
    }

    public void method2(RestrictedGeneric<? super ChildClass> m) {
        System.out.println("Generic 2");
    }
}
