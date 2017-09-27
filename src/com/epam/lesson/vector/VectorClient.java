package com.epam.lesson.vector;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author ABarmin
 */
public class VectorClient {
    public static void main(String[] args) {
        final Vector<Integer> vector = new Vector<>(3);//, 2);
        System.out.println(vector.size());
        System.out.println(vector.capacity());
        vector.addElement(2);
        vector.addElement(2);
        vector.addElement(2);
        vector.addElement(2);
        System.out.println(vector.size());
        System.out.println(vector.capacity());
        vector.addElement(1);
        System.out.println(vector.size());
        System.out.println(vector.capacity());


        final Enumeration<Integer> elements = vector.elements();
        while (elements.hasMoreElements()) {
            final Integer integer = elements.nextElement();
            System.out.print(integer + " ");
        }
    }
}
