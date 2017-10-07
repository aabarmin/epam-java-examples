package com.epam.lesson.concurrency;

public class ExceptionHandling {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(
                new Thread.UncaughtExceptionHandler() {
                    @Override
                    public void uncaughtException(Thread t, Throwable e) {
                        e.printStackTrace();
                    }
                }
        );
        // throw new RuntimeException("123455");

        final Thread thread = new Thread(() -> {
            throw new RuntimeException("Exception from thread");
        });
        thread.setUncaughtExceptionHandler((t, e) -> {
            System.out.println("Exception handler for thread");
            e.printStackTrace();
        });
        thread.start();
    }
}
