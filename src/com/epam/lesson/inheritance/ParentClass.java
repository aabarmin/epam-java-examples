package com.epam.lesson.inheritance;

public class ParentClass {
    public String parentValue;

    static {
        System.out.println("static parent");
    }

    {
        System.out.println("dynamic parent");
    }

    public ParentClass(int i) {
        System.out.println("constructor parent");
    }
}
