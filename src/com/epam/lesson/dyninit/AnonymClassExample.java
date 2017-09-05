package com.epam.lesson.dyninit;

import java.util.HashMap;
import java.util.Map;

public class AnonymClassExample {
    public static final AnonymInterface INST = new AnonymInterface() {
        @Override
        public void method() {

        }
    };

    public static final Map<String, String> MAP = new HashMap<String, String>(){
        @Override
        public int size() {
            return super.size();
        }
    };

    public static void main(String[] args) {
        method(new AnonymInterface(){
            {
                System.out.println("I'm anonym class");
            }

            @Override
            public void method() {
                System.out.println("Invocation inside");
                System.out.println(getClass().getName());
            }
        });
    }

    public static void method(AnonymInterface instance) {
        instance.method();
    }
}

interface AnonymInterface {
    void method();
}
