package com.epam.lesson.getters;

/**
 * @author ABarmin
 */
public class CollectionExample {
    private int index = 0;
    private final String[] values = new String[10];

    public void addValue(String value) {
        values[index++] = value;
        //
        // getValues()[index++] = value;
    }

    public String[] getValues() {
        // return System.arraycopy();
        return null;
    }
}
