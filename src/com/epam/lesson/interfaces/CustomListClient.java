package com.epam.lesson.interfaces;

public class CustomListClient {
    public static void main(String[] args) {
        final CustomList list = new CustomListImpl();
        list.add(1);
        list.add(2);

        final CustomList.ListElement[] all = list.getAll();
        for (CustomList.ListElement listElement : all) {
            System.out.println(listElement);
        }
    }
}
