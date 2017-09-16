package com.epam.lesson.stringbuilders;

/**
 * @author ABarmin
 */
public class StringBuilderClient {
    public static void main(String[] args) {
        final StringBuilder builder = new StringBuilder();
        builder.append("This is some string");
        builder.insert(7, " awesome");

        System.out.println(builder);

        builder.delete(3, 5);
        builder.trimToSize();
    }
}
