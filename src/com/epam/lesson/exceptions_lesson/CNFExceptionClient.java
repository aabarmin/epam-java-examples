package com.epam.lesson.exceptions_lesson;

/**
 * @author ABarmin
 */
public class CNFExceptionClient {
    public static void main(String[] args) {
        final Class<CNFExceptionClient> aClass =
                CNFExceptionClient.class;

        new Object().getClass();

        try {
            final Class<?> forName =
                    Class.forName(
                            "com.epam.lesson.exceptions_lesson.CNFExceptionClient"
                    );

            final Object instance = forName.newInstance();
            System.out.println(instance == null);
        } catch (Exception ignored) {}

        try {
            final Class<?> forName =
                    Class.forName(
                            "com.CNFExceptionClient"
                    );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
