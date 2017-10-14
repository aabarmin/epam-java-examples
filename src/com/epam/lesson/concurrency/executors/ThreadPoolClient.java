package com.epam.lesson.concurrency.executors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolClient {
    public static void main(String[] args) throws Exception {
        final ExecutorService executorService = Executors.newCachedThreadPool();
        //
        final Collection<Callable<String>> tasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            final int j = i;
            tasks.add(() -> {
                Thread.sleep(new Random().nextInt(2000));
                return "Result from " + j;
            });
        }
        //
        System.out.println("Before get futures");
        // final List<Future<String>> futures = executorService.invokeAll(tasks);
        final List<Future<String>> futures = new ArrayList<>();
        for (Callable<String> task : tasks) {
            futures.add(executorService.submit(task));
        }
        boolean hasUndone = true;
        while (hasUndone) {
            hasUndone = false;
            final Iterator<Future<String>> iterator = futures.iterator();
            while (iterator.hasNext()) {
                final Future<String> future = iterator.next();
                if (!future.isDone()) {
                    hasUndone = true;
                } else {
                    System.out.println(future.get());
                    iterator.remove();
                }
            }
        }


//        for (Future<String> future : futures) {
//            System.out.println(future.get());
//        }

        final String s = executorService.invokeAny(tasks);
        System.out.println(s);


        System.out.println("After get futures");


        executorService.shutdown();

    }
}
