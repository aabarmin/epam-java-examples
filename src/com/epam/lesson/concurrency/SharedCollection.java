package com.epam.lesson.concurrency;

import java.time.Duration;
import java.time.Instant;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class SharedCollection {
    public static void main(String[] args) throws Exception {
        final AccountService service = new AccountService(new AccountRepository());
        for (int i = 0; i < 5; i++) {
            service.modifyAccount(
                    AccountKey.newInstance("Account " + i),
                    10
            );
        }
        //
        final Collection<Thread> threads = new HashSet<>();
        final CountDownLatch latch = new CountDownLatch(1);
        for (int i = 0; i < 50; i++) {
            final int j = i;
            threads.add(new Thread(() -> {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                service.modifyAccount(
                        AccountKey.newInstance("Account " + (j % 5)),
                        10
                );
            }));
        }
        for (int i = 0; i < 50; i++) {
            final int j = i;
            threads.add(new Thread(() -> {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                service.modifyAccount(
                        AccountKey.newInstance("Account " + (j % 5)),
                        -10
                );
            }));
        }
        final Instant start = Instant.now();
        for (Thread thread : threads) {
            thread.start();
        }
        latch.countDown();
        for (Thread thread : threads) {
            thread.join();
        }
        final long duration = Duration.between(start, Instant.now()).toMillis();
        //
        for (int i = 0; i < 5; i++) {
            System.out.println(
                    "Account " + i + ": " +
                            service.getValue(
                                    "Account " + i
                            )
            );
        }
        System.out.println("Time: " + duration);
    }
}

class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void modifyAccount(AccountKey key, int value) {
        synchronized (key) {
            accountRepository.setValue(key, value);
        }
    }

    public int getValue(String key) {
        return accountRepository.getValue(
                AccountKey.newInstance(key)
        );
    }
}

class AccountRepository {
    private Map<AccountKey, Integer> accounts = new HashMap<>();

    public void setValue(AccountKey key, int value) {
        System.out.println("Modify account " + key + " start");
        final int v = getValue(key);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accounts.put(key, v + value);
        System.out.println("Modify account " + key + " end");
    }

    public int getValue(AccountKey key) {
        if (!accounts.containsKey(key)) {
            return 0;
        }
        return accounts.get(key);
    }
}

class AccountKey {
    private static final Map<String, AccountKey> KEYS = new HashMap<>();
    private final String key;

    protected AccountKey(String key) {
        this.key = key;
    }

    public static AccountKey newInstance(final String key) {
        if (!KEYS.containsKey(key)) {
            KEYS.put(key, new AccountKey(key));
        }
        return KEYS.get(key);
    }

    @Override
    public String toString() {
        return "AccountKey{" +
                "key='" + key + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountKey that = (AccountKey) o;

        return key.equals(that.key);
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }
}