package com.epam.lesson.dyninit;

public class DynInitExample {
    private static int j = 20;

    {
        System.out.println(j);
        this.i = 10;
        System.out.println("block 1");
        System.out.println(this.i);
    }

    private int i = 10;

    {
        System.out.println("block 2");
        statMethod();
        System.out.println(i);
    }

    public static void statMethod() {
        System.out.println("Static");
    }

    public static void main(String[] args) {
        new DynInitExample();
    }
}
