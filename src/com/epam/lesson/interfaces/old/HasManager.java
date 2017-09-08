package com.epam.lesson.interfaces.old;

public interface HasManager {
    String getManagerName() throws IllegalArgumentException;

    interface HasSalary {
        int getSalary();
    }
}
