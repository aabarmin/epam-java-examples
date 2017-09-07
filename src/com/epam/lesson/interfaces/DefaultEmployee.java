package com.epam.lesson.interfaces;

public class DefaultEmployee implements CommonEmployee {
    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getManagerName() throws IllegalArgumentException {
        return null;
    }

    @Override
    public String[] getSubordinators() throws IllegalArgumentException {
        return new String[0];
    }
}
