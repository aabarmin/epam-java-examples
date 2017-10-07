package com.epam.lesson.concurrency;

public class ConcurrencyClient {
    public static void main(String[] args) throws Exception {
        final MyThread thread = new MyThread();
        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from runnable");
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    System.out.println("Interrupted exception fired");
//                }
            }
        });
        // thread1.start();
        // thread1.interrupt();
        thread.start();
        Thread.sleep(100);
        thread.interrupt();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello from thread");
        while (true) {
            if (this.isInterrupted()) {
                System.out.println("Interrupted!");
                return;
            }
            System.out.println("Working");
        }
    }
}