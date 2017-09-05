package com.epam.lesson.equalsnhcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DataHolder {
    private final int value;

    public DataHolder(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataHolder that = (DataHolder) o;

        return value == that.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    public static void main(String[] args) {
        final DataHolder holder = new DataHolder(1);
        System.out.println(holder.equals(holder)); // true
        System.out.println(holder.equals(null)); // false

        final DataHolder anotherHolder = new DataHolder(2);
        System.out.println(holder.equals(anotherHolder)); // true

        // holder.setValue(1);
        System.out.println(holder.equals(anotherHolder)); // false

        final DataHolder inheritedHolder = new InheritedHolder(1, 2);
        // inheritedHolder.setValue(1);
        // inheritedHolder.setAnotherValue(2);

        System.out.println(holder.equals(inheritedHolder));
        System.out.println(inheritedHolder.equals(holder));

        Set<DataHolder> set = new HashSet<>();
        set.add(holder);
        // holder.setValue(2);
        set.add(holder);

        System.out.println(set.size());

        Map<DataHolder, String> map = new HashMap<>();
        map.put(holder, "This value");

        System.out.println(map.get(holder));

        // holder.setValue(3);

        System.out.println(map.get(holder));
    }
}

class InheritedHolder extends DataHolder {
    private final int anotherValue;

    public int getAnotherValue() {
        return anotherValue;
    }

    public InheritedHolder(int value, int anotherValue) {
        super(value);
        this.anotherValue = anotherValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        InheritedHolder that = (InheritedHolder) o;

        return anotherValue == that.anotherValue;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + anotherValue;
        return result;
    }
}