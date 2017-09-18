package com.epam.lesson.generics.right;

public class HolderClient {
    public static void main(String[] args) {
        final Holder<String> stringHolder = new Holder<>();
        stringHolder.setValue("");

        final Holder<Number> numberHolder = new Holder<>();
        numberHolder.setValue(10);
        numberHolder.setValue(10.0);

        // final Holder<Number> wrongHolder = new Holder<Integer>();
        // final Holder<Pet> animalHolder = new Holder<Animal>();
        Holder<? extends Pet> extPetHolder = new Holder<Pet>();
        extPetHolder = new Holder<Cat>();
        extPetHolder = new Holder<Dog>();
        // extPetHolder = new Holder<Animal>();

        // extPetHolder.setValue(new Pet());
        extPetHolder.setValue(null);
//        extPetHolder.setValue(new Animal());
//        extPetHolder.setValue(new Pet());
        ((Holder<Dog>) extPetHolder).setValue(new Dog());

        Holder<? super Pet> superPetHolder = new Holder<Pet>();
        superPetHolder = new Holder<Animal>();
        superPetHolder.setValue(new Pet());
        superPetHolder.setValue(new Cat());
        superPetHolder.setValue(new Dog());
        superPetHolder.setValue(null);
        // superPetHolder.setValue(new Animal());

        // pecs
        final Holder<Animal> animalHolder = new Holder<>();
        final Holder<Pet> petHolder = new Holder<>();
        final Holder<Cat> catHolder = new Holder<>();
        final Holder<Dog> dogHolder = new Holder<>();

        convertStraight(animalHolder, animalHolder);
//        convertStraight(animalHolder, petHolder);
//        convertStraight(petHolder, animalHolder);

        convert(catHolder, animalHolder);
        // convert(animalHolder, catHolder);
        convert(dogHolder, animalHolder);
        convert(dogHolder, petHolder);
        // convert(catHolder, dogHolder);
        convert(catHolder, catHolder);
    }

    public static final <T> void convertStraight(Holder<T> source,
                                                 Holder<T> destination) {

    }

    public static final <T> void convert(Holder<? extends T> source,
                                         Holder<? super T> destination) {

    }

    public static final <T> Holder<? super T> convert(Holder<? extends T> source) {
        return null;
    }
}

class AnotherHolder<T extends Pet> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

