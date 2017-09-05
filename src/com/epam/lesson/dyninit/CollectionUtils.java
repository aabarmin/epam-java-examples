package com.epam.lesson.dyninit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionUtils {
    public static <S, T> Collection<T> map(Collection<S> source,
                                           Mapper<S, T> mapper) {
        final Collection<T> result = new ArrayList<>();
        for (S s : source) {
            result.add(mapper.map(s));
        }
        return result;
    }

    public static void main(String[] args) {
        final List<String> source = Arrays.asList("1", "2", "3");
        final Collection<Integer> integers = CollectionUtils.map(source, new Mapper<String, Integer>() {
            @Override
            public Integer map(String item) {
                return Integer.parseInt(item);
            }
        });
        System.out.println(integers);

        final List<Integer> collect =
                source.parallelStream()
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
    }
}

interface Mapper<S, T> {
    T map(S item);
}