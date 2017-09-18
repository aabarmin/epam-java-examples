package com.epam.lesson.datetime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
 * @author ABarmin
 */
public class ByExampleFormatter {
    public static void main(String[] args) {
        final String formatted = DateTimeFormatter.ISO_DATE_TIME.format(
                ZonedDateTime.now()
        );
        System.out.println(formatted);

        System.out.println(
                DateTimeFormatter.ISO_INSTANT.format(
                        Instant.now()
                )
        );

        //

        final DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
        System.out.println(
                formatter.withLocale(Locale.CHINESE)
                .format(
                        ZonedDateTime.now()
                )
        );

        final DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        final LocalDate localDate = LocalDate.parse(
                "2017-03-20",
                pattern
        );
        System.out.println(localDate);
    }
}
