package com.epam.lesson.concurrency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.CountDownLatch;

public class AccountClient {
    public static void main(String[] args) throws Exception {
        final Account account = new Account(10);
        final Collection<Thread> threads = new HashSet<>();
        final CountDownLatch latch = new CountDownLatch(1);
        for (int i = 0; i < 50; i++) {
            threads.add(new Thread(() -> {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                account.deposit(50);
            }));
        }
        for (int i = 0; i < 50; i++) {
            threads.add(new Thread(() -> {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                account.withdraw(50);
            }));
        }
        for (Thread thread : threads) {
            thread.start();
        }
        latch.countDown();
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(
                account.getValue()
        );
    }
}

class Account {
    private int value;
    private Object mutex = new Object();

    public Account(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void withdraw(int amount) {
        System.out.println("Withdraw start");
        synchronized (mutex) {
            int x = value - amount;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.value = x;
        }
        System.out.println("Withdraw end");
    }

    public void deposit(int amount) {
        System.out.println("Deposit start");
        synchronized (mutex) {
            int x = value + amount;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.value = x;
        }
        System.out.println("Deposit end");
    }
}