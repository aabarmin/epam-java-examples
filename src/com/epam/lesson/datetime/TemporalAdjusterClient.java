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
public class TemporalAdjusterClient {
    public static void main(String[] args) {
        final LocalDate firstDayOfMonth = LocalDate.now()
                .with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(firstDayOfMonth.getDayOfWeek());

        final LocalDate firstSaturday = LocalDate.now()
                .with(TemporalAdjusters.firstInMonth(
                        DayOfWeek.SATURDAY
                ));
        System.out.println(firstSaturday);

        final LocalDate professionalHoliday = LocalDate.now()
                .with(TemporalAdjusters.lastInMonth(
                        DayOfWeek.SUNDAY
                ));
        System.out.println(professionalHoliday);

        final LocalDate firstMonday = LocalDate.now()
                .plus(2, ChronoUnit.DAYS)
                .with(new FirstWorkDayFinder());
        System.out.println(firstMonday);
    }
}

class FirstWorkDayFinder implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal temporal) {
        while (temporal.get(ChronoField.DAY_OF_WEEK) !=
                DayOfWeek.MONDAY.getValue()) {

            temporal = temporal.plus(1, ChronoUnit.DAYS);
        }
        return temporal;
    }
}