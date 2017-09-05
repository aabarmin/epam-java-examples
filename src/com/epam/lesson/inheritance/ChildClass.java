package com.epam.lesson.inheritance;

public class ChildClass extends ParentClass {
    public String childValue;

    static {
        System.out.println("child static");
    }

    {
        System.out.println("child dynamic");
    }

    public ChildClass() {
        super(1);
        System.out.println("child constructor");
    }
}
