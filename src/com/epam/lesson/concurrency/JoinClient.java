package com.epam.lesson.concurrency;

public class JoinClient {
    public static void main(String[] args) throws Exception {
        final Counter counter1 = new Counter(100);
        final Counter counter2 = new Counter(300);

        counter1.start();
        counter2.setDaemon(true);
        counter2.setName("Daemon");
        counter2.start();

        Thread.currentThread();

//        counter1.join();
//        counter2.join();

        System.out.println("All counted");
    }
}

class Counter extends Thread {
    private int delay;

    public Counter(int delay) {
        this.delay = delay;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(
                    this.getName() + " " +
                            i
            );
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}