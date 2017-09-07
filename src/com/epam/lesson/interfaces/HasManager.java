package com.epam.lesson.interfaces;

public interface HasManager {
    String getManagerName() throws IllegalArgumentException;

    interface HasSalary {
        int getSalary();
    }
}
