package com.epam.lesson.queues;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class QueueClient {
    private Queue<String> queue = new PriorityQueue<>(4);

    public static void main(String[] args) {
        final QueueClient client = new QueueClient();
        client.run();
    }

    public void run() {
        final Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    while (queue.size() > 0) {
                        System.out.println("Readed " + queue.remove());
                    }
                }
            }
        });
        consumer.start();

        final Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 100;
                while (i-- > 0) {
                    final String added = String.valueOf(new Random().nextInt());
                    queue.offer(added);
                    System.err.println("added " + added);
                }
                System.out.println("end");
            }
        });
        producer.start();
    }
}
