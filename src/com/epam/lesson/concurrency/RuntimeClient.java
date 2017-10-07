package com.epam.lesson.concurrency;

public class RuntimeClient {
    public static void main(String[] args) throws Exception {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//            throw new RuntimeException();
             System.out.println("Before shutdown");
        }));

        System.out.println("Started");
        Thread.sleep(1000);
//        throw new RuntimeException();
        System.out.println("Going to finish");
    }
}
