package com.epam.lesson.concurrency;

public class ThreadGroupClient {
    public static void main(String[] args) {
        final ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        System.out.println(threadGroup);
        //
        final Thread mainThread = Thread.currentThread();
        //
        final ThreadGroup group = new ThreadGroup("Our thread group");
        final Thread thread = new Thread(group, () -> {
            System.out.println(Thread.currentThread());
            mainThread.checkAccess();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
        });
        final ThreadGroup anotherGroup = new ThreadGroup("Another group");
        final Thread anotherThread = new Thread(anotherGroup, () -> {
            System.out.println(Thread.currentThread());
            thread.checkAccess();
            thread.interrupt();
        });
        thread.start();
        anotherThread.start();
        //
        final ThreadGroup forInterruption = new ThreadGroup("For interruption");
        for (int i = 0; i < 5; i++) {
            final Thread interrupted = new Thread(forInterruption, () -> {
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    System.out.println("Interrupted");
                }
            });
            interrupted.start();
        }
        // forInterruption.interrupt();
        forInterruption.list();
        final Thread[] tList = new Thread[forInterruption.activeCount()];
        forInterruption.enumerate(tList);
        System.out.println(tList);
    }
}
