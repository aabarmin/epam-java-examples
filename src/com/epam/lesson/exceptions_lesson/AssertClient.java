package com.epam.lesson.exceptions_lesson;

/**
 * @author ABarmin
 */
public class AssertClient {
    public static void main(String[] args) {
        final AssertClient client = new AssertClient();
        try {
            client.someMethod(null);
        } catch (AssertionError e) {

        }
        System.out.println("After tomorrow");
    }

    public void someMethod(String value) {
        assert value != null;
        System.out.println("Done!");
    }
}
