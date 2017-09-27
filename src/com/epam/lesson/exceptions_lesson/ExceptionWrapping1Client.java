package com.epam.lesson.exceptions_lesson;

/**
 * @author ABarmin
 */
public class ExceptionWrapping1Client {
    public static void main(String[] args) {
        try {
            run(() -> m());
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }

    public static int m() throws Exception {
        int i = (1 / 0);
        return 10;
    }

    public static <T> T run(Callback<T> callback) {
        try {
            return callback.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

interface Callback<T> {
    T run() throws Exception;
}
