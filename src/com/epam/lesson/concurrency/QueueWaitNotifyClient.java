package com.epam.lesson.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QueueWaitNotifyClient {
    public static void main(String[] args) {
        final OurQueue queue = new OurQueue();
        //
        new Thread(() -> {
            System.out.println("Consumer started");
            //
            synchronized (queue) {
                while (true) {
                    while (queue.hasValue()) {
                        final int value = queue.getValue();
                        System.out.println("Value has been read " + value);
                    }
                    System.out.println("Going to sleep");
                    try {
                        queue.wait();
                        System.out.println("Wake up!");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        //
        new Thread(() -> {
            System.out.println("Producer started");
            //
            for (int i = 0; i < 100; i++) {
                final int value = new Random().nextInt(100);
                System.out.println("Value added " + value);
                queue.addValue(value);
                synchronized (queue) {
                    queue.notify();
                }
            }
        }).start();
    }
}

class OurQueue {
    private List<Integer> values = new ArrayList<>();

    public void addValue(int value) {
        values.add(value);
    }

    public int getValue() {
        return values.remove(0);
    }

    public boolean hasValue() {
        return !values.isEmpty();
    }
}