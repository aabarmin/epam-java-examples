package com.epam.lesson.validation;

public class Validator {
    private Class targetClass;

    protected Validator(Class targetClass) {
        this.targetClass = targetClass;
    }

    public static Validator newInstance(Class clazz) {
        return new Validator(clazz);
    }

    public void assertNotNull(Object value) {
        if (value == null) {
            throw new IllegalArgumentException(String.format(
                    "Exception in class %s",
                    targetClass
            ));
        }
    }
}
