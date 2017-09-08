package com.epam.lesson.interfaces.java8;

public class InterfaceWithMethodsImpl implements InterfaceWithMethods, AnotherInterfaceWithMethods {
    public static void main(String[] args) {
        final InterfaceWithMethodsImpl impl = new InterfaceWithMethodsImpl();
        impl.getName();
        impl.getName(10);
    }
}
