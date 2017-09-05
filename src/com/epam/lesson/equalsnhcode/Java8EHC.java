package com.epam.lesson.equalsnhcode;

public class Java8EHC {
    public static void main(String[] args) {
        final Java8EHC objA = new Java8EHC();
        final Java8EHC objB = new Java8EHC();

        System.out.println(objA.hashCode());
        System.out.println(objB.hashCode());
    }
}
