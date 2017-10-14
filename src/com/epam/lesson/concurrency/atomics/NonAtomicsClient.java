package com.epam.lesson.concurrency.atomics;

import java.util.concurrent.CountDownLatch;

public class NonAtomicsClient {
    private static int value = 0;

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(1);
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                value++;
            }).start();
        }
        latch.countDown();

        System.out.println(value);
    }
}
