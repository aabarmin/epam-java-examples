package com.epam.lesson.exceptions_origin;

import java.io.IOException;

/**
 * @author ABarmin
 */
public class ExceptionClient {
    public static void main(String[] args) {
        final ExceptionClient client = new ExceptionClient();

        System.out.println("Before");

        try {
            client.anotherMethod();
        } catch (IOException e) {
            System.out.println("Exception processed");
        } finally {
            System.out.println("Always");
        }

        System.out.println("After");
    }

    public void anotherMethod() throws IOException {
        someMethod();
    }

    public void someMethod() throws IOException {
        throw new IOException("Something happens");
    }
}
