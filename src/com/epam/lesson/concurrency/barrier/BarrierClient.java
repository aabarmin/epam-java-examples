package com.epam.lesson.concurrency.barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BarrierClient {
    public static void main(String[] args) {
        final CyclicBarrier barrier = new CyclicBarrier(2);
        for (int i = 0; i < 4; i++) {
            final int j = i;
            new Thread(() -> {
                System.out.println("Start " + j);
                try {
                    Thread.sleep(1000 * j);
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

                System.out.println("After barrier " + j);
            }).start();
        }
    }
}
