package com.epam.lesson.enums;

public enum EnumSingleton {
    INSTANCE;

    public String getName() {
        return "";
    }

    public static void main(String[] args) {
        EnumSingleton.INSTANCE.getName();
    }
}
