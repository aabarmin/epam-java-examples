package com.epam.lesson.generics;

import java.util.ArrayList;
import java.util.List;

public class AnotherGenericClient {
    public static void main(String[] args) {
        final GenericClass<ParentClass> parentGeneric = new GenericClass<ParentClass>();
        parentGeneric.setValue(new ChildClass());

        final List<Number> list = new ArrayList<>();
        list.add(10);
    }
}
