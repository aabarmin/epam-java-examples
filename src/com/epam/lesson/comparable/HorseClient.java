package com.epam.lesson.comparable;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class HorseClient {
    public static void main(String[] args) {
        final Set<Horse> horses = new TreeSet(new HorseComparator());
        horses.add(new Horse(4));
    }

    public static class HorseComparator implements Comparator<Horse>{
        @Override
        public int compare(Horse o1, Horse o2) {
            return o1.getLegs() - o2.getLegs();
        }
    }
}
