package com.epam.lesson.leg;

/**
 * @author ABarmin
 */
public class Leg {
    private final int number;

    public Leg(int number, Pistol pistol) {
        this.number = number;
        pistol.shoot(this);
    }
}
