package com.epam.lesson.exceptions_lesson;

import java.io.IOException;

/**
 * @author ABarmin
 */
public class ExceptionClient {
    public static void main(String[] args) {
        final ExceptionClient client = new ExceptionClient();
        client.exceptionInternal();

        try {
            client.exceptionExternal();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            client.severalExceptions();
        } catch (ClassCastException | IOException e) {

        }
    }

    public void shootToLeg() throws ClassCastException {
        try {
            int a = 0;
            final int i = 0 / a;
        } catch (ArithmeticException e) {
            throw new ClassCastException();
        }
    }

    public void severalExceptions() throws ClassCastException, IOException {
        if (10 % 2 == 0) {
            throw new ClassCastException();
        }
        throw new IOException();
    }

    public void exceptionExternal() throws Exception {
        throw new Exception();
    }

    public void exceptionInternal() {
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
