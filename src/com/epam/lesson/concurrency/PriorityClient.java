package com.epam.lesson.concurrency;

public class PriorityClient {
    public static void main(String[] args) throws Exception {
        final NumberCounter low = new NumberCounter();
        low.setName("Low ");
        low.setPriority(Thread.MIN_PRIORITY);

        final NumberCounter high = new NumberCounter();
        high.setName("High");
        high.setPriority(Thread.MAX_PRIORITY);

        low.start();
        high.start();

        Thread.sleep(1000);

        low.interrupt();
        high.interrupt();
    }
}

class NumberCounter extends Thread {
    private long count;

    @Override
    public void run() {
        while (!isInterrupted()) {
            count++;
        }
        System.out.println(getName() + " " + count);
    }
}
