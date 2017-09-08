package com.epam.lesson.interfaces.old;

public interface CustomList {
    ListElement[] getAll();

    void add(Object element);

    interface ListElement {
        Object getValue();

        void setValue(Object value);
    }
}
