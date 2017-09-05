package com.epam.lesson.ourset;

public class OurSet {
    private Object[] values = new Object[10];
    private int currentIndex = 0;

    public void add(Object value) {
        values[currentIndex] = value;
        currentIndex++;
    }

    public boolean contains(Object value) {
        boolean contains = false;
        for (Object o : values) {
            if (value.equals(o)) {
                contains = true;
                break;
            }
        }
        return contains;
    }

    public static void main(String[] args) {
        final OurSet set = new OurSet();
        set.add(new Integer(1));
        set.add(new Double(2.0));
        set.add(new String("Hello"));

        System.out.println(set.contains(1));
        System.out.println(set.contains(2.0));
        System.out.println(set.contains("Hello"));
    }
}
