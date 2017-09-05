package com.epam.lesson.tostring;

public class FormattedConverter extends AbstractConverter {
    @Override
    protected String getUnformattedString() {
        return "This is %s, he is %s age old";
    }
}
