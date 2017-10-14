package com.epam.lesson.concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class DeadlockClient {
    private static Object monitor1 = new Object();
    private static Object monitor2 = new Object();

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(1);

        new Thread(() -> {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Pair.getInstance(monitor1, monitor2)) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Done 1");
            }
        }).start();

        new Thread(() -> {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Pair.getInstance(monitor2, monitor1)) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Done 2");
            }
        }).start();

        latch.countDown();
    }
}

class Pair {
    private final Object first;
    private final Object second;

    private static final Map<Pair, Pair> LOCKS = new HashMap<>();

    public static synchronized Pair getInstance(Object a, Object b) {
        Pair p = new Pair(a, b);
        if (!LOCKS.containsKey(p)) {
            LOCKS.put(p, p);
        }
        return LOCKS.get(p);
    }

    public Pair(Object first, Object second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        if (first.equals(pair.first) &&
                second.equals(pair.second)) {
            return true;
        }
        if (first.equals(pair.second) &&
                second.equals(pair.first)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = first.hashCode();
        result = 31 * result + second.hashCode();
        return result;
    }
}