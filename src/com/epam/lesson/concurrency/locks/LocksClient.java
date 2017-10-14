package com.epam.lesson.concurrency.locks;

import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LocksClient {
    private static Lock lock = new ReentrantLock();

    public static void m() {
        lock.lock();
        try {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws Exception {
        final ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.invokeAll(Collections.nCopies(10, () -> {
            m();
            return null;
        }));
        executorService.shutdown();
    }
}
