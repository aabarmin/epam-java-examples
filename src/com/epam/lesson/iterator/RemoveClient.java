package com.epam.lesson.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveClient {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList(
                "a", "b", "c"
        ));
        if (list.remove("a")) {
            System.out.println("removed");
            if (list.remove(0).equals("b")) {
                System.out.println("b removed");
            }
        }
    }
}
