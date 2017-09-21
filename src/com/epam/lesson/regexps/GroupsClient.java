package com.epam.lesson.regexps;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ABarmin
 */
public class GroupsClient {
    public static void main(String[] args) {
        final Pattern pattern = Pattern.compile(
                "\\+\\d+(\\(\\d{3}\\))\\d{3}(-\\d{2}){2}"
        );
        final Matcher matcher = pattern.matcher("+7(912)345-67-89");
        matcher.find();
        for (int i = 0; i < matcher.groupCount(); i++) {
            System.out.println(
                    matcher.group(i)
            );
        }
    }
}
