package com.epam.lesson.generics;

public class SuperGeneric{
    public <T> T method(T value) {
        return value;
    }

    public <T extends ParentClass> T method1(T value) {
        return value;
    }

    public <T extends ParentClass & Comparable<T>> T method2(T value) {
        return value;
    }

    public <T> T m(T v) { return null; }
}
