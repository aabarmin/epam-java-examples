package com.epam.lesson.segregation;

/**
 * @author ABarmin
 */
public class CatClient {
    public static void main(String[] args) {
        Cat cat = new Cat();

        Mammal mammal = (Mammal) cat;
        mammal.eat();

        Pet pet = (Pet) cat;
        pet.feed();

    }
}
