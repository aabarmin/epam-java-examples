package com.epam.lesson.di;

public class Computer {
    private final Keyboard keyboard;
    private final Monitor monitor;

    public Computer(Keyboard keyboard, Monitor monitor) {
        this.keyboard = keyboard;
        this.monitor = monitor;
    }

    public static void main(String[] args) {
        final Computer computer = new Computer(
                new Keyboard(),
                new Monitor()
        );
//        computer.setKeyboard(new Keyboard());
//        computer.setMonitor(new Monitor());
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public Monitor getMonitor() {
        return monitor;
    }
}
