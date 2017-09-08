package com.epam.lesson.generics.wrong;

import java.util.ArrayList;
import java.util.List;

public class GenericClient {
    public static void main(String[] args) {
        GenericClass<Integer> intClass = new GenericClass<>(10);
        GenericClass<String> stringClass = new GenericClass<>("10");

        GenericClass common = intClass;
        stringClass = common;

        stringClass.setValue("20");

        List<Integer> intList = new ArrayList<>();
        intList.add(10);
        List<String> stringList = new ArrayList<>();
        stringList.add("10");

        List commonList = intList;
        stringList = commonList;

        stringList.add("30");
    }
}
