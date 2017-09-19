package com.epam.lesson.formatters;

import java.util.Date;

/**
 * @author ABarmin
 */
public class NumberFormatterClient {
    public static void main(String[] args) {
        System.out.println(String.format(
                "Value is %#o",
                10
        ));
        System.out.println(String.format(
                "Value is %#-+15.7f",
                10d
        ));
        System.out.println(String.format(
                "Value is %#x",
                20
        ));

        System.out.println(String.format(
                "%td.%<tm.%<tY %<tH:%<tM",
                new Date()
        ));
    }
}
