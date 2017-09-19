package com.epam.lesson.datetime;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author ABarmin
 */
public class LegacyClient {
    public static void main(String[] args) {
        final Date date = new Date();
        final Instant instant = date.toInstant();

        final TimeZone timeZone =
                TimeZone.getTimeZone(ZoneId.of("Europe/Moscow"));

        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getDefault());
        calendar.toInstant();
    }
}
