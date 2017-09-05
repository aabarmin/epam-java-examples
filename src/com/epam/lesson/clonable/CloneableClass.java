package com.epam.lesson.clonable;

import java.util.ArrayList;
import java.util.Collection;

public class CloneableClass implements Cloneable {
    private String value = new String("property value");
    public Collection<String> values = new ArrayList<>();

    {
        System.out.println("Dynamic block");
    }

    public CloneableClass() {
        System.out.println("Constructor called");
    }

    public CloneableClass(CloneableClass toCopy) {
        this.values = new ArrayList<>(toCopy.values);
    }

    public static void main(String[] args) throws Exception {
        final CloneableClass aClass = new CloneableClass();
        aClass.values.add("First value");
        final CloneableClass clone = (CloneableClass) aClass.clone();
        aClass.values.add("Second value");

        System.out.println(aClass == clone);
        System.out.println(aClass.value);
        System.out.println(clone.value);
        System.out.println(aClass.value == clone.value);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
