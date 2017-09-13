package com.epam.lesson.datetime;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author ABarmin
 */
public class DateTimeClient {
    public static void main(String[] args) {
        final DateFormat engFormat = DateFormat.getDateInstance(
                DateFormat.FULL,
                Locale.ENGLISH);
        final DateFormat chinaFormat = DateFormat.getDateInstance(
                DateFormat.FULL,
                Locale.CHINESE
        );

        System.out.println(engFormat.format(new Date()));
        System.out.println(chinaFormat.format(new Date()));

        System.out.println(
                DateFormat.getDateInstance(
                        DateFormat.FULL
                ).format(new Date())
        );
        System.out.println(
                DateFormat.getDateInstance(
                        DateFormat.LONG
                ).format(new Date())
        );
        System.out.println(
                DateFormat.getDateInstance(
                        DateFormat.MEDIUM
                ).format(new Date())
        );
        final Date date = new Date();
        System.out.println(
                DateFormat.getDateInstance(
                        DateFormat.SHORT
                ).format(date)
        );
        date.setYear(2020);
        System.out.println(
                DateFormat.getDateInstance(
                        DateFormat.SHORT
                ).format(date)
        );
    }
}
