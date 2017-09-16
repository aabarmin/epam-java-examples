package com.epam.lesson.strings;

/**
 * @author ABarmin
 */
public class IndexOfClient {
    public static void main(String[] args) {
        String s1 = "This is long string";
        System.out.println(s1.indexOf("is"));
        System.out.println(s1.lastIndexOf("is"));

        System.out.println(s1.lastIndexOf("is", 5));

        System.out.println(s1.startsWith("This"));
        System.out.println(s1.endsWith("string"));
        System.out.println(s1.startsWith("is", 5));

        System.out.println("This is source  string"
                .replaceAll("[1-5]*", "-"));
    }
}
