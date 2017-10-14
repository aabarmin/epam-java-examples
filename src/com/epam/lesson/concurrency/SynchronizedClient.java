package com.epam.lesson.concurrency;

import java.util.concurrent.CountDownLatch;

public class SynchronizedClient {
    public static void main(String[] args) {
        final SynchronizedClient client = new SynchronizedClient();

        final CountDownLatch latch = new CountDownLatch(1);
        for (int i = 0; i < 5; i++) {
            final Thread thread = new Thread(() -> {
                try {
                    latch.await();

                    client.writeNotification();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
        latch.countDown();
        System.out.println("Done");
    }

    private void writeNotification() {
        System.out.println("Before " + Thread.currentThread());
        System.out.println("After " + Thread.currentThread());
    }
}
