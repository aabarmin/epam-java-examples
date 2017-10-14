package com.epam.lesson.concurrency.executors;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorsClient {
    public static void main(String[] args) {
        // final ExecutorService executorService = Executors.newSingleThreadExecutor();
        final ExecutorService executorService = Executors.newFixedThreadPool(2);
        /*
        final ExecutorService executorService = Executors.newCachedThreadPool(
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        System.out.println("Starting runnable");
                        final Thread thread = new Thread(r);
                        thread.setName("Task executor");
                        return thread;
                    }
                }
        );
        */
        /*
        final ExecutorService executorService = new ThreadPoolExecutor(
                1, 1,
                10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(1, true)
        );
        */
        final Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            final int j = i;
            System.out.println("Submitting task");
            executorService.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Done!");
                map.put(j, "Result " + j);
            });
        }
        System.out.println("Before shutdown");
        executorService.shutdown();
        System.out.println("After shutdown");
    }
}
