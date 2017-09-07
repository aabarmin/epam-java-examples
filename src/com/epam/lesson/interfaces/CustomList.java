package com.epam.lesson.interfaces;

public interface CustomList {
    ListElement[] getAll();

    void add(Object element);

    interface ListElement {
        Object getValue();

        void setValue(Object value);
    }
}
