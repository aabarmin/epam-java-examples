package com.epam.lesson.locale;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @author ABarmin
 */
public class DateFormatClient {
    private static final String FORMAT = "dd.MM.yyyy";

    public static void main(String[] args) {
        final List<Integer> formats = Arrays.asList(
                DateFormat.DEFAULT,
                DateFormat.FULL,
                DateFormat.LONG,
                DateFormat.MEDIUM,
                DateFormat.SHORT
        );
        final List<Locale> locales = Arrays.asList(
                new Locale("ru", "RU"),
                Locale.US
        );
        for (Locale locale : locales) {
            for (Integer format : formats) {
                final DateFormat formatter =
                        DateFormat.getDateInstance(format, locale);
                System.out.printf(
                        "%s, %s: %s",
                        locale,
                        format,
                        formatter.format(new Date())
                );
                System.out.println();
            }
        }

        final SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT);
    }
}
