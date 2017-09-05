package com.epam.lesson.leg;

/**
 * @author ABarmin
 */
public class Pistol {
    public void shoot(Leg leg) {
        System.out.println(leg);
    }

    public static void main(String[] args) {
        final Pistol pistol = new Pistol();
        final Leg leg = new Leg(2, pistol);
        System.out.println(leg);
    }
}
