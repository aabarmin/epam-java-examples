package com.epam.lesson.enums;

public enum Seasons implements ToStringConvertable {
    WINTER("Zima", 1) {
        public String getSong() {
            return "Eslib  ne bilo zimi";
        }
    },
    SUMMER("Leto", 2) {
        @Override
        public String getFormattedString() {
            return getRussianName() + " - " + getNumber();
        }
    },
    AUTUMN("Osen'", 3),
    SPRING("Vesna", 4),
    ANY(1);

    private final String russianName;
    private final int number;

    Seasons(String russianName, int number) {
        this.russianName = russianName;
        this.number = number;
    }

    Seasons() {
        this.russianName = "Not defined";
        this.number = 0;
    }

    Seasons(int number) {
        this();
    }

    public String getRussianName() {
        return russianName;
    }

    public int getNumber() {
        return number;
    }

    public boolean hasRain() {
        return this.equals(Seasons.AUTUMN);
    }

    public String getSong() {
        return "";
    }

    @Override
    public String getFormattedString() {
        return null;
    }
}
