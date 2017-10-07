package com.epam.lesson.concurrency;

public class WaitNotifyClient {
    private int value;

    private Object mutex = new Object();

    public static void main(String[] args) throws Exception {
        new WaitNotifyClient().run();
    }

    public void run() throws Exception {
        System.out.println("Start");
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                synchronized (mutex) {
                    try {
                        mutex.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Value acquired " + value);
            }).start();
        }
        Thread.sleep(100);
        new Thread(() -> {
            value = 10;
            synchronized (mutex) {
                mutex.notifyAll();
            }
        }).start();
        System.out.println("End");
    }
}
