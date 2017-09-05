package com.epam.lesson.decorator;

public class DecoratorClient {
    public static void main(String[] args) {
        ParentInterface instance =
                new Decorator(new FinalImplementation());

        System.out.println(instance.getValue());
        System.out.println(instance.getAnotherValue());
    }
}
