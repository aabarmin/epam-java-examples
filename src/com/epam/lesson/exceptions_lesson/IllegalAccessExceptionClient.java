package com.epam.lesson.exceptions_lesson;

import java.lang.reflect.Field;

/**
 * @author ABarmin
 */
public class IllegalAccessExceptionClient {
    public static void main(String[] args) {
        final Class<AnotherClass> aClass =
                AnotherClass.class;
        try {
            final AnotherClass instance = new AnotherClass();
//            final Method method = aClass.getMethod("method");
//            method.invoke(instance);

            final Field field = aClass.getDeclaredField("value");
            // field.setAccessible(true);
            field.get(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
