package com.epam.lesson.concurrency;

public class JoinWithWaitClient {
    public static void main(String[] args) throws Exception {
        final Thread thread = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println(i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread.start();
        thread.join();
//        thread.start();

        Runtime.getRuntime().availableProcessors();

        System.out.println("Goes ahead");
    }
}
