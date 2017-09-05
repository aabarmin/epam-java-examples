package com.epam.lesson.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author ABarmin
 */
public class ReflectionClass {
    public static void callMe(String stringValue) {
        System.out.println("String");
    }

    /*
    public void callMe(Integer intValue) {
        System.out.println("Integer");
    }

    public void callMe(int intValue) {
        System.out.println("int");
    }
    */
    public static void callMe(double d) {
        System.out.println("Float");
    }

    public static void main(String[] args) {
        final Method[] declaredMethods = ReflectionClass.class.getDeclaredMethods();
        final Constructor<?>[] declaredConstructors = ReflectionClass.class.getDeclaredConstructors();
        System.out.println("");

        Object value = 10;
        // ReflectionClass.callMe((Number) value);
        ReflectionClass.callMe(new Integer(10));
        ReflectionClass.callMe("10");
        ReflectionClass.callMe(10.0);
    }
}
