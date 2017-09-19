package com.epam.lesson.datetime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author ABarmin
 */
public class ZonedDateClient {
    public static void main(String[] args) {
        System.out.println(
                ZoneId.getAvailableZoneIds()
        );
        System.out.println(
                ZoneId.systemDefault()
        );

        final ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);

        System.out.println(ZonedDateTime.now(
                ZoneId.of("Asia/Yekaterinburg")
        ));

        System.out.println(ZonedDateTime.ofInstant(
                Instant.now(),
                ZoneId.of("Africa/Nairobi")
        ));

        final LocalDateTime localDate = ZonedDateTime.now()
                .toLocalDateTime();
        System.out.println(localDate);
    }
}
