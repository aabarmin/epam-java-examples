package com.epam.lesson.datetime;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

/**
 * @author ABarmin
 */
public class ByExampleZoneDateTime {
    public static void main(String[] args) {
        final ZonedDateTime now = ZonedDateTime.now();
        final Instant instant = now.toInstant();
        System.out.println(now);
        System.out.println(instant);

        final Set<String> zones = ZoneId.getAvailableZoneIds();
        System.out.println(zones);

        final ZonedDateTime atJersey = instant.atZone(ZoneId.of("Europe/Jersey"));
        System.out.println(atJersey);
    }
}
