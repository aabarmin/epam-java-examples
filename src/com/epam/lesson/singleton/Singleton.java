package com.epam.lesson.singleton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ABarmin
 */
public class Singleton {
    private Singleton() {
        System.out.println("Constructor called");
    }

    private static class SingletonHolder {
        public static final Singleton SINGLETON = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.SINGLETON;
    }

    public static void main(String[] args) throws Exception {
        final Collection<Callable<Void>> tasks = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            tasks.add(new Callable<Void>() {
                @Override
                public Void call() throws Exception {
                    Singleton.getInstance();
                    return null;
                }
            });
        }
        final ExecutorService pool = Executors.newFixedThreadPool(10);
        pool.invokeAll(tasks);
        pool.shutdown();
    }
}
