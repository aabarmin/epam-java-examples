package com.epam.lesson.strings;

/**
 * @author ABarmin
 */
public class NullPrinterClient {
    public static void main(String[] args) {
        String s1 = null;
        System.out.println((s1 + Float.NaN + 2 + s1 + null));

        String s2 = "str";
        String s3 = s2.concat("").concat("").concat("");
        System.out.println(s2 == s3);

        String s4 = "";
        System.out.println(s2.concat(s2) == s4.concat(s2));
        System.out.println(s2 == s2.concat(s4));
    }
}
