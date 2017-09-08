package com.epam.lesson.generics.wrong;

import java.util.ArrayList;
import java.util.List;

public class RestrictedGenericClient {
    public static void main(String[] args) {
        RestrictedGeneric<ParentClass> p = new RestrictedGeneric<>();
        RestrictedGeneric<ChildClass> c = new RestrictedGeneric<>();
        RestrictedGeneric<Object> o = new RestrictedGeneric<Object>();

        p.method(p);
        c.method2(p);
        c.method2(c);
        c.method2(o);

        // PECS - producer extends, consumer super

        List<? super Integer> intList = new ArrayList<>();
        intList.add(null);
        intList.add(new Integer(10));
//        intList.add(new Object());

        Holder<Integer> integerHolder = new Holder<>();
        some(integerHolder);
    }

    public static void some(Holder<? extends Integer> ss) {};

    public static <T extends CharSequence> Holder<T> produce() {
        return new Holder<>();
    }

    public static void consume(Holder<? super String> value) {

    }

    public static class Holder<T> {
        private T value;
    }
}
