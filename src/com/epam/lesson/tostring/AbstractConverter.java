package com.epam.lesson.tostring;

public abstract class AbstractConverter implements Converter {
    @Override
    public String convert(ToStringHolder holder) {
        return String.format(
                getUnformattedString(),
                holder.getName(),
                holder.getAge()
        );
    }

    protected abstract String getUnformattedString();
}
