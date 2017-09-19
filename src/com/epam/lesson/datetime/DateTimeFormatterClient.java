package com.epam.lesson.datetime;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;

/**
 * @author ABarmin
 */
public class DateTimeFormatterClient {
    public static void main(String[] args) {
        final ZonedDateTime now = ZonedDateTime.now();

        System.out.println(
                DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(now)
        );
        System.out.println(
                DateTimeFormatter.BASIC_ISO_DATE.format(now)
        );

        System.out.println(
                DateTimeFormatter
                        .ofLocalizedDate(FormatStyle.FULL)
                        .withLocale(Locale.FRANCE)
                        .format(now)
        );
        System.out.println(
                DateTimeFormatter
                        .ofLocalizedDate(FormatStyle.LONG)
                        .withLocale(Locale.TRADITIONAL_CHINESE)
                        .format(now)
        );
        System.out.println(
                DateTimeFormatter
                        .ofLocalizedDate(FormatStyle.MEDIUM)
                        .withLocale(Locale.TRADITIONAL_CHINESE)
                        .format(now)
        );
        System.out.println(
                DateTimeFormatter
                        .ofLocalizedDate(FormatStyle.SHORT)
                        .withLocale(Locale.FRANCE)
                        .format(now)
        );

        System.out.println(
                DateTimeFormatter
                        .ofPattern("dd.MM.yyyy n")
                        .format(now)
        );

        final TemporalAccessor parse = DateTimeFormatter
                .ofPattern("dd.MM.yyyy")
                .parse("25.12.2010");
        System.out.println(parse);


    }
}
