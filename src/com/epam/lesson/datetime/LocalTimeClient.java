package com.epam.lesson.datetime;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * @author ABarmin
 */
public class LocalTimeClient {
    public static void main(String[] args) {
        final LocalTime lessonStart = LocalTime.of(18, 30);
        final LocalTime lessonEnd = LocalTime.of(22, 00);
        //
        final Duration fromStart = Duration.between(lessonStart,
                LocalTime.now());
        final Duration toEnd = Duration.between(LocalTime.now(),
                lessonEnd);

        System.out.printf("%s:%s", fromStart.toHours(),
                fromStart.toMinutes() - (60 * fromStart.toHours())
        );
        System.out.println();
        System.out.printf("%s:%s", toEnd.toHours(),
                toEnd.toMinutes() - (60 * toEnd.toHours())
        );
        System.out.println();

        final LocalTime plus = LocalTime.now()
                .plus(2, ChronoUnit.HOURS);
        System.out.println(plus);
    }
}
