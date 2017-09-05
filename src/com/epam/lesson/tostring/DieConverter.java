package com.epam.lesson.tostring;

public class DieConverter extends AbstractConverter {
    @Override
    protected String getUnformattedString() {
        return "This was %s, he died in %s";
    }
}
