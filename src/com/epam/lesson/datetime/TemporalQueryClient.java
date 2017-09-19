package com.epam.lesson.datetime;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author ABarmin
 */
public class TemporalQueryClient {
    public static void main(String[] args) {
        final AlienMovieSelector selector = new AlienMovieSelector();
        final LocalDate sourceDate = LocalDate.now();
        final LocalDate anotherDate = sourceDate.minus(25, ChronoUnit.YEARS);
        final Collection<AlienMovies> movies = selector.queryFrom(anotherDate);
        System.out.println(movies);
    }
}

class AlienMovieSelector implements TemporalQuery<Collection<AlienMovies>> {
    @Override
    public Collection<AlienMovies> queryFrom(TemporalAccessor temporal) {
        final int year = temporal.get(ChronoField.YEAR);
        return Arrays.stream(AlienMovies.values())
                .sorted((b, a) -> Integer.compare(a.getYear(), b.getYear()))
                .filter(i -> i.getYear() <= year)
                .collect(Collectors.toList());
    }
}

enum AlienMovies {
    ALIEN(1979),
    ALIENS(1986),
    ALIEN_3(1992),
    ALIEN_RESURRECTION(1997),
    PROMETHEUS(2012),
    ALIEN_COVENANT(2017);

    private final int year;

    AlienMovies(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }
}