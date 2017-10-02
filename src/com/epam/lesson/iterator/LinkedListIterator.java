package com.epam.lesson.iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListIterator {
    public static void main(String[] args) {
        LinkedList<String> items = new LinkedList<>(Arrays.asList(
                "a", "b", "c"
        ));
        final Iterator<String> iterator = items.descendingIterator();
        while (iterator.hasNext()) {
            final String next = iterator.next();
            System.out.print(next + " ");
        }
    }
}
