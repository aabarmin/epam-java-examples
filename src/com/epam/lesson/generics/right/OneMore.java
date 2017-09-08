package com.epam.lesson.generics.right;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class OneMore {

    public static <T> void copy(Collection<? extends T> src, Collection<? super T> dest) {

    }

    public static <T> Collection<? super T> map(Collection<? extends T> src) {
        return Collections.emptyList();
    }

    public static <T> void straight(Collection<T> src, Collection<T> dest) {

    }

    public static void main(String[] args) {
        Collection<Pet> pets = new ArrayList<>();
        Collection<Cat> cats = new ArrayList<>();
        Collection<Dog> dogs = new ArrayList<>();
        Collection<Animal> animals = new ArrayList<>();
        // copy(pets, cats);
        copy(pets, animals);
        copy(pets, pets);

        animals = (Collection<Animal>) map(pets);
        pets = (Collection<Pet>) map(pets);

        copy(cats, cats);
        copy(cats, pets);
        copy(cats, animals);
        // copy(cats, dogs);

        // straight(cats, pets);
        straight(cats, cats);
    }

}

class Animal {
    void feed() {

    }
}

class Pet extends Animal {
    void call() {

    }
}

class Cat extends Pet {
    void meow() {

    }
}

class Dog extends Pet {
    void gav() {

    }
}