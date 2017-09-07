package com.epam.lesson.interfaces;

public abstract class AbstractEmployee implements
                            HasSubordinators, HasManager {
    @Override
    public String getManagerName() throws IllegalArgumentException {
        return null;
    }
}
