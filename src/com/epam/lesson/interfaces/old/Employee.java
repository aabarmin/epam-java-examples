package com.epam.lesson.interfaces.old;

public class Employee implements HasManager, HasSubordinators {
    @Override
    public String getManagerName() throws IllegalArgumentException {
        return null;
    }

    @Override
    public String[] getSubordinators() throws IllegalArgumentException {
        return new String[0];
    }
}
