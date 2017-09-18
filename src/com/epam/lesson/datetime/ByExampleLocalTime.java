package com.epam.lesson.datetime;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * @author ABarmin
 */
public class ByExampleLocalTime {
    public static void main(String[] args) {
        final LocalTime now = LocalTime.now();
        final LocalTime newDate = now.plus(10, ChronoUnit.MINUTES);

        System.out.println(now);
        System.out.println(newDate);

        final Duration duration = Duration.between(now, newDate);
        System.out.println(duration);
    }
}
