package com.epam.lesson.singleton;

/**
 * @author ABarmin
 */
public class AnotherSingleton {
    private static AnotherSingleton ourInstance = new AnotherSingleton();

    public static AnotherSingleton getInstance() {
        return ourInstance;
    }

    private AnotherSingleton() {
    }
}
