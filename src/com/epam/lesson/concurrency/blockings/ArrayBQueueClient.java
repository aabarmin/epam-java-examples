package com.epam.lesson.concurrency.blockings;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ArrayBQueueClient {
    public static ArrayBlockingQueue<Runnable> tasks =
            new ArrayBlockingQueue<Runnable>(10,  true);

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                System.out.println("Try to add");
                try {
                    if (tasks.offer(() -> {
                        System.out.println("Executed");
                    }, 50, TimeUnit.MILLISECONDS)) {
                        System.out.println("Add new task");
                    } else {
                        System.out.println("Can't add");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(() -> {
            while (true) {
                Runnable task;
                while ((task = tasks.poll()) != null) {
                    System.out.println("Execute new task");
                    task.run();

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
