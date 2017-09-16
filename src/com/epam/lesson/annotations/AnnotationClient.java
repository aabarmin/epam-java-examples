package com.epam.lesson.annotations;

import java.lang.annotation.Annotation;

@SuperAnnotation(
        value = "Kryptonite",
        killer = "Manhattan",
        anotherValue = @AnotherAnnotation
)
@SuperAnnotation(
        value = "Another value",
        anotherValue = @AnotherAnnotation
)
@AnotherAnnotation
public class AnnotationClient {
    public static void main(String[] args) {
        final Annotation[] annotations = AnnotationClient.class.getDeclaredAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof SuperAnnotation) {
                final SuperAnnotation superAnnotation = (SuperAnnotation) annotation;
                System.out.println(superAnnotation.value());
            }
        }

        final SuperAnnotation superAnnotation = AnnotationClient.class.getDeclaredAnnotation(SuperAnnotation.class);
        System.out.println(superAnnotation.killer());
    }
}
