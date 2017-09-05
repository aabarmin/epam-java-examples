package com.epam.lesson.beans;

import sun.tools.tree.LessExpression;

import java.util.Collection;

public class LessonClient {
    public static void main(String[] args) {
        final LessonBean.Builder builder = LessonBean.builder()
                .setTitle("Lesson1")
                .passed();

        builder.passed().build();
    }
}
