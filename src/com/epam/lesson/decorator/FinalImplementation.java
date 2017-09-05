package com.epam.lesson.decorator;

public final class FinalImplementation implements ParentInterface {
    @Override
    public String getValue() {
        return "Hello, World!";
    }

    @Override
    public String getAnotherValue() {
        return "Real value";
    }
}
