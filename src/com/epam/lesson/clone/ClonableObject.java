package com.epam.lesson.clone;

import java.lang.reflect.Method;
import java.util.Objects;

public class ClonableObject {
    private String value;

    public static void main(String[] args) throws Exception {
        final Method[] declaredMethods = ClonableObject.class.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            // declaredMethod.invoke()
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClonableObject that = (ClonableObject) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
