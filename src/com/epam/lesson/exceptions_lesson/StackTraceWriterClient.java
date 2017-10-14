package com.epam.lesson.exceptions_lesson;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author ABarmin
 */
public class StackTraceWriterClient {
    public static void main(String[] args) {
        final StackTraceWriterClient client =
                new StackTraceWriterClient();

        String msg = "";

        try {
            client.m();
        } catch (Exception e) {
//            final StringWriter stringWriter = new StringWriter();
//            final PrintWriter writer =
//                    new PrintWriter(stringWriter);
//
//            e.printStackTrace(writer);
//
//            msg = stringWriter.getBuffer().toString();
            msg = exceptionToString(e);
        }

        System.out.println(msg);
    }

    public void m() {
        throw new RuntimeException("Something goes wrong");
    }

    public static String exceptionToString(Exception e) {
        final StringWriter stringWriter = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);
        return stringWriter.toString();
    }
}
