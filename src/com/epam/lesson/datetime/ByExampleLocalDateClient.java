package com.epam.lesson.datetime;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * @author ABarmin
 */
public class ByExampleLocalDateClient {
    public static void main(String[] args) {
        final LocalDate now = LocalDate.now();
        final LocalDate newDate = now.plus(10, ChronoUnit.DAYS);
        System.out.println(newDate);

        final LocalDate localDate = now.withMonth(3);
        System.out.println(localDate);
        System.out.println(localDate.getDayOfWeek());
        System.out.println(localDate.getDayOfYear());

        final Period period = localDate.until(now);
        System.out.printf("%s years, %s months, %s days",
                period.getYears(), period.getMonths(), period.getDays());
    }
}
