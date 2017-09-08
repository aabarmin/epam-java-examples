package com.epam.lesson.dicontainer;

import java.lang.reflect.Field;

public class Context {
    public <T> T getBean(Class<T> clazz) {
        try {
            final T instance = clazz.newInstance();

            for (Field field : clazz.getDeclaredFields()) {
                final Inject annotation = field.getAnnotation(Inject.class);
                if (annotation != null) {
                    final Class<?> type = field.getType();
                    final Object dependency = getBean(type);

                    field.setAccessible(true);
                    field.set(instance, dependency);
                }
            }

            return instance;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
