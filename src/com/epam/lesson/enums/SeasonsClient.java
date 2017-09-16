package com.epam.lesson.enums;

public class SeasonsClient {
    public static void main(String[] args) {
        System.out.println(
                Seasons.AUTUMN.hasRain()
        );
        System.out.println(
                Seasons.SPRING.hasRain()
        );

        System.out.println(
                Seasons.SPRING.getNumber()
        );
        System.out.println(
                Seasons.WINTER.getRussianName()
        );

        System.out.println(
                Seasons.WINTER.getSong()
        );

        for (Seasons season : Seasons.values()) {
            System.out.println(season);
            System.out.println(season.ordinal());
        }

        final Seasons any = Seasons.valueOf("ANY");
        // final Seasons another = Seasons.valueOf("another");
    }
}
