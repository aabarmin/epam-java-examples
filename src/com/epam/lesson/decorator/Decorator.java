package com.epam.lesson.decorator;

public class Decorator implements ParentInterface {
    private final ParentInterface implementation;

    public Decorator(ParentInterface implementation) {
        this.implementation = implementation;
    }

    @Override
    public String getValue() {
        return "Decorated value";
    }

    @Override
    public String getAnotherValue() {
        return implementation.getAnotherValue();
    }
}
