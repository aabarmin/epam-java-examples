package com.epam.lesson.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * @author ABarmin
 */
public class ByExampleAdjustments {
    public static void main(String[] args) {
        final LocalDate nextFriday = LocalDate.now().with(
                TemporalAdjusters.firstDayOfMonth()
        );
        System.out.println(nextFriday);

        final LocalDate nextMonday = LocalDate.now().with(new NextWorkDay());
        System.out.println(nextMonday);
    }
}

class NextWorkDay implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal temporal) {
        while (temporal.get(ChronoField.DAY_OF_WEEK) != DayOfWeek.MONDAY.getValue()) {
            temporal = temporal.plus(1, ChronoUnit.DAYS);
        }
        return temporal;
    }
}
