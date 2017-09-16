package com.epam.lesson.strings;

import java.nio.charset.StandardCharsets;

public class StringsClient {
    public static void main(String[] args) {
        final String string = new String("Hello");
        System.out.println("1 " + string.getBytes().length);
        System.out.println("2 " + string.getBytes(StandardCharsets.UTF_8).length);
        System.out.println("3 " + string.getBytes(StandardCharsets.US_ASCII).length);
        System.out.println("4 " + string.getBytes(StandardCharsets.UTF_16).length);
    }
}
