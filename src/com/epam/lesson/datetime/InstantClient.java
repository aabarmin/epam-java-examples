package com.epam.lesson.datetime;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;

/**
 * @author ABarmin
 */
public class InstantClient {
    public static void main(String[] args) throws Exception {
//        final Instant instant1 = Instant.now();
//        Thread.sleep(2000);
//        final Instant instant2 = Instant.now();
//
//        final Duration between = Duration.between(instant1, instant2);
//        System.out.println(between.toNanos());
//        System.out.println(between.toMillis());
//        System.out.println(between.toMinutes());
//        System.out.println(between.toString());

        System.out.println(" ----- ");

        final LocalDate now = LocalDate.now();
        System.out.println(now);

        final LocalDate newDate = now.plusDays(5);
        System.out.println(newDate);

        final Duration betweenLocalDates = Duration.between(
                now.atStartOfDay(),
                newDate.atStartOfDay()
        );
        System.out.println(betweenLocalDates.toDays());

        final LocalDate secondDate = newDate.plusDays(
                betweenLocalDates.toDays()
        );
        System.out.println(secondDate);

        final LocalDate of1 = LocalDate.of(2017, 9, 30);
        System.out.println(of1);

        System.out.println(of1.plusDays(1));
        System.out.println(of1.isLeapYear());

        final LocalDate nextProgrammersDay = LocalDate.of(2018, 01, 01).plusDays(255);
        System.out.println(
                LocalDate.now()
                        .until(nextProgrammersDay)
                        .getYears()
        );

        System.out.println(DayOfWeek.of(1));
    }
}
