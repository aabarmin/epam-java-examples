package com.epam.lesson.concurrency.executors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableClient {
    public static void main(String[] args) throws Exception {
        final ExecutorService executorService = Executors.newFixedThreadPool(5);
        final Future<String> future = executorService.submit(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello from callable";
        });

        executorService.shutdown();

        System.out.println("Before get");

        final String s = future.get();
        System.out.println(s);

        System.out.println(future.get());

        System.out.println("After get");


        /*
        final Collection<Callable<String>> tasks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            final int j = i;
            tasks.add(() -> {
                Thread.sleep(1000);
                return "Result " + j;
            });
        }
        //
        executorService.su
        */
    }
}
