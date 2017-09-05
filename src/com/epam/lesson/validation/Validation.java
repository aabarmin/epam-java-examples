package com.epam.lesson.validation;

public class Validation {
    protected Validation() {

    }

    public static void assertNotNull(Object value) {
        if (value == null) {
            throw new IllegalArgumentException();
        }
    }
}
