package com.epam.lesson.datetime;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;
import java.util.Arrays;

/**
 * @author ABarmin
 */
public class ByExampleTemporalQuery {
    public static void main(String[] args) {
        final AlienMovieSelector selector = new AlienMovieSelector();
        final AlienMovies movie = selector.queryFrom(LocalDate.of(1995, Month.JUNE, 5));
        System.out.println(movie);
    }
}

class AlienMovieSelector implements TemporalQuery<AlienMovies> {

    @Override
    public AlienMovies queryFrom(TemporalAccessor temporal) {
        final int year = temporal.get(ChronoField.YEAR);
        return Arrays.stream(AlienMovies.values())
                .sorted((m1, m2) -> Integer.compare(m2.getYear(), m1.getYear()))
                .filter(m -> year > m.getYear())
                .findFirst()
                .orElse(null);
    }
}

enum AlienMovies {
    ALIEN(1979),
    ALIENS(1986),
    ALIEN_3(1992),
    ALIEN_RESURRECTION(1997),
    ALIEN_COVENANT(2017);

    private final int year;

    AlienMovies(final int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }
}
