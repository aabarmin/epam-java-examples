package com.epam.lesson.datetime;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ABarmin
 */
public class SimpleDateFormatClient {
    public static void main(String[] args) throws Exception {
        final SimpleDateFormat format =
                new SimpleDateFormat("dd.MM.yyyy");
        final Date date = format.parse("23.12.2010");

        System.out.println(date);

        System.out.println(
                new SimpleDateFormat("dd.MM.yyyy")
                        .format(new Date())
        );
    }
}
