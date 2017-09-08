package com.epam.lesson.innerclasses.anonym;

import com.epam.lesson.decorator.ParentInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionClient {
    public static final <T> Collection<? super T> filter(
            Collection<? extends T> source,
            Predicate<T> predicate) {

        final Collection<T> result = new ArrayList<>();
        for (T item : source) {
            if (predicate.satisfies(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        final Collection<Integer> number = Arrays.asList(1, 2, 3, 4, 5, 6);

        final int a = 10;

        final Collection<? super Integer> objects = CollectionClient.filter(number, new Predicate<Integer>() {
            {
                System.out.println("Created");
            }

            @Override
            public boolean satisfies(Integer item) {
                return item % 2 == 0;
            }
        });
        System.out.println(objects);

        number.stream()
                .filter(i -> i % 2 == 0)
                .forEach(System.out::println);
    }
}

interface Predicate<T> {
    boolean satisfies(T item);
}
