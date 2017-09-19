package com.epam.lesson.formatters;

import java.util.Formatter;

/**
 * @author ABarmin
 */
public class FormatterClient {
    public static void main(String[] args) {
        System.out.printf(
                "Hello, %s",
                "world"
        );
        System.out.println();
        System.out.println(String.format(
                "Hello, %s",
                "John Snow!"
        ));
        final Formatter formatter = new Formatter();
        System.out.println(
                formatter.format(
                        "Hello, %s, %s, %s",
                        "John Snow",
                        "Igrid",
                        "Jorah"
                )
        );

        System.out.println(String.format(
                "You know %2$s, %<s",
                "nothing",
                "John Snow"
        ));
    }
}
