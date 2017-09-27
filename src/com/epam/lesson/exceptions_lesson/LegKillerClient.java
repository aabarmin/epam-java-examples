package com.epam.lesson.exceptions_lesson;

/**
 * @author ABarmin
 */
public class LegKillerClient {
    public static void main(String[] args) {
        final LegKillerClient client = new LegKillerClient();
        client.someMethod();
    }

    @SuppressWarnings("all")
    public void someMethod() {
        // throw new Exception();
    }
}
