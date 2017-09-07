package com.epam.lesson.interfaces;

public class CustomListImpl implements CustomList {
    private ListElement[] data = new ListElement[10];
    private int size = 0;

    @Override
    public ListElement[] getAll() {
        return data;
    }

    @Override
    public void add(Object element) {
        data[size] = new ListElementImpl(element);
        size++;
    }

    public class ListElementImpl implements ListElement {
        private Object value;

        public ListElementImpl(Object value) {
            this.value = value;
        }

        @Override
        public Object getValue() {
            return value;
        }

        @Override
        public void setValue(Object value) {
            this.value = value;
        }
    }
}
