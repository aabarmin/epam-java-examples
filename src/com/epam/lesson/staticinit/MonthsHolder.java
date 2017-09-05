package com.epam.lesson.staticinit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MonthsHolder {
    private static final Collection<String> MONTHS = Arrays.asList(
            "January",
            "February"
    );

    private static final Map<Integer, String> NUM_TO_NAME = new HashMap<Integer, String>() {
        {
            put(2, "February");
        }
    };

    static {
        NUM_TO_NAME.put(1, "January");
    }
}
