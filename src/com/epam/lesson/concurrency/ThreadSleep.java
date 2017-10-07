package com.epam.lesson.concurrency;

public class ThreadSleep {
    public static void main(String[] args) throws Exception {
        final MyAnotherThread myAnotherThread = new MyAnotherThread();
        myAnotherThread.start();
        Thread.sleep(100);
        myAnotherThread.isReady = true;
        System.out.println("Main end");
    }
}

class MyAnotherThread extends Thread {
    public boolean isReady = false;

    @Override
    public void run() {
        while (!isReady) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread end");
    }
}
