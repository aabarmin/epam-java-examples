package com.epam.lesson.lambdas;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CollectionUtils {
    public static <T> T reduce(Collection<T> source,
                               T initial,
                               BinFunction<T> function) {

        T currentValue = initial;
        for (T item : source) {
            currentValue = function.apply(currentValue, item);
        }
        return currentValue;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        final Integer integer = CollectionUtils.reduce(numbers, 0, new BinFunction<Integer>() {
            @Override
            public Integer apply(Integer a, Integer b) {
                return a + b;
            }
        });
        System.out.println(integer);
    }
}

interface BinFunction<T> {
    T apply(T a, T b);
}