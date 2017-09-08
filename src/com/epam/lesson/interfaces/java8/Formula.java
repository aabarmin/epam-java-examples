package com.epam.lesson.interfaces.java8;

interface Formula {
    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}

class FormulaImpl implements Formula {
    @Override
    public double calculate(int a) {
        return sqrt(a);
    }
}