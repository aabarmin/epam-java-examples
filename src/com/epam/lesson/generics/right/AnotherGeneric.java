package com.epam.lesson.generics.right;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AnotherGeneric {
    public static <T> void convert(Collection<T> source, Collection<T> destination) {

    }

    public static <T> void another(Collection<? extends T> source, Collection<? super T> dest) {

    }

    public static void main(String[] args) {
        final List<String> stringList = new ArrayList<>();
        final List<Integer> intList = new ArrayList<>();
        final List<Object> objectList = new ArrayList<>();

        convert(stringList, stringList);
        // convert(stringList, objectList);
        convert(objectList, objectList);

        final List<CharSequence> charList = new ArrayList<>();
        another(stringList, charList);
        another(stringList, stringList);
        // another(charList, stringList);
        another(charList, objectList);
    }
}
