package com.epam.lesson.exceptions_lesson;

/**
 * @author ABarmin
 */
public class ExceptionWrappingClient {
    public static void main(String[] args) {
        final ExceptionWrappingClient client =
                new ExceptionWrappingClient();

        client.m();
    }

    public void m() {
        new RuntimeException("Something happens");
    }

    public void m2() {
        try {
            m1();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void m3() {
        try {
            m1();
        } catch (Exception ignored) {
            System.out.println("Something goes wrong");
        }
    }

    public void m1() throws Exception {

    }
}
