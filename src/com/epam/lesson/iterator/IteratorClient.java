package com.epam.lesson.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class IteratorClient {
    public static void main(String[] args) {
        final Collection<String> items = new HashSet<>(Arrays.asList(
                "First",
                "Second",
                "Third"
        ));
        Iterator<String> iterator = items.iterator();
        while (iterator.hasNext()) {
            final String next = iterator.next();
            System.out.print(next + " ");
        }

        System.out.println();

        iterator = items.iterator();
//        while (true) {
//            iterator.next();
//        }

        for (String item : items) {
//            if ("Second".equals(item)) {
//                items.remove(item);
//            }
        }
        System.out.println(items);

//        items.stream()
//                .forEach(i -> items.remove(i));

        iterator = items.iterator();
        while (iterator.hasNext()) {
            final String next = iterator.next();
            if ("Third".equals(next)) {
                iterator.remove();
            }
        }

        System.out.println(items);
    }
}
