package com.epam.lesson.strings;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;

/**
 * @author ABarmin
 */
public class StringExample {
    public static void main(String[] args) {
        final String value = "Привет!";
        System.out.println(value.length());
        System.out.println(value.getBytes().length);

        final CharSequence sequence = value;
        System.out.println(value.charAt(0));
        System.out.println(value.codePointAt(0));

        final StringBuilder builder = new StringBuilder();
        builder.equals(null);
        builder.hashCode();

        new Date(2010, 10, 10, 20, 20);

        final Instant now = Instant.now();
        final Duration between = Duration.between(now, Instant.now());
        // between.plus()

        final LocalDate localDate = LocalDate.now();
        final String format = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                .withLocale(Locale.ENGLISH)
                .format(localDate);

        // DateTimeFormatter.ofPattern("")

        System.out.println(format);
    }
}
