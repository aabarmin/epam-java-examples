package com.epam.lesson.publicmorozov.gkcp;

import com.epam.lesson.publicmorozov.Dedushka;
import com.epam.lesson.publicmorozov.Pavlik;

public class Client {
    public static void main(String[] args) {
        Pavlik pavlik = new Pavlik();
        pavlik.realty();

        Dedushka dedushka = new Pavlik();
        ((Pavlik) dedushka).realty();
    }
}
