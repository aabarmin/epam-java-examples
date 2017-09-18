package com.epam.lesson.datetime;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * @author ABarmin
 */
public class ByExampleInstantClient {
    public static void main(String[] args) {
        final Instant now = Instant.now();
        System.out.println(now);

        // plus 5 minutes
        final Instant plus = now.plus(5, ChronoUnit.MINUTES);
        System.out.println(plus);

        // plus 5 minutes
        final Instant tenMinutes = now.plusSeconds(600);
        System.out.println(tenMinutes);


        // between
        final Duration duration = Duration.between(plus, tenMinutes);
        final Duration increased = duration.plusMinutes(5);
        final Instant withDuration = now.plus(increased);
        System.out.println(withDuration);
    }
}
