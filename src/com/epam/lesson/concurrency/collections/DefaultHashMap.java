package com.epam.lesson.concurrency.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class DefaultHashMap {
    private static ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();

    public static void main(String[] args) throws Exception {
        final CountDownLatch latch = new CountDownLatch(1);
        final Collection<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            final int j = i;
            final Thread thread = new Thread(() -> {
                final int key = j % 5;
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //
                map.compute(key, (k, v) -> {
                    return map.getOrDefault(k, 0) + 1;
                });
                // map.put(key, map.getOrDefault(key, 0) + 1);
            });
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.start();
        }
        latch.countDown();
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(map);
    }
}
