package com.epam.lesson.concurrency.atomics;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicClient {
    private static AtomicInteger value = new AtomicInteger(0);

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(1);
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                value.incrementAndGet();
            }).start();
        }
        latch.countDown();

        System.out.println(value);
    }
}
