package com.epam.lesson.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class ListIteratorClient {
    public static void main(String[] args) {
        final List<String> items = new ArrayList<>(Arrays.asList(
                "a", "b", "c"
        ));

        boolean direction = true;
        final ListIterator<String> iterator = items.listIterator();
        while (has(iterator, direction)) {
            final String s = get(iterator, direction);
            System.out.println(s);
            direction = new Random().nextBoolean();
        }
    }

    private static <T> T get(ListIterator<T> iterator, boolean isForward) {
        if (isForward) {
            return iterator.next();
        } else {
            return iterator.previous();
        }
    }

    private static <T> boolean has(ListIterator<T> iterator, boolean isForward) {
        if (isForward) {
            return iterator.hasNext();
        } else {
            return iterator.hasPrevious();
        }
    }
}
