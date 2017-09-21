package com.epam.lesson.regexps;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ABarmin
 */
public class PatternClient {
    public static void main(String[] args) {
        final Pattern pattern = Pattern.compile(
                "\\+\\d+\\(\\d{3}\\)\\d{3}(-\\d{2}){2}"
        );
        final Matcher matcher = pattern.matcher("+7(912)123-56-78");
        System.out.println(matcher.matches());

        final Pattern splitPattern = Pattern.compile(
                "[\\(|\\)|-]"
        );
        final String[] parts = splitPattern.split("+7(912)123-56-78");
        System.out.println(
                Arrays.toString(parts)
        );

        final String[] split = "+7(912)123-56-78".split("[\\(\\)-]");
        System.out.println(
                Arrays.toString(split)
        );
    }
}
