package com.epam.lesson.observer;

import java.util.ArrayList;
import java.util.Collection;

public class ObserverClient {
    public static void main(String[] args) {
        final Button button = new Button();
        button.register(() -> System.out.println("Hello, from listener 1"));
        button.register(() -> System.out.println("Hello, from listener 2"));
        button.register(() -> System.out.println("Hello, from listener 3"));
        button.click();
    }
}

class Button implements Observer {
    private Collection<Observable> observables = new ArrayList<>();

    @Override
    public void register(Observable ob) {
        observables.add(ob);
    }

    @Override
    public void unregister(Observable ob) {
        observables.remove(ob);
    }

    public void click() {
        System.out.println("Clicked!");
        for (Observable observable : observables) {
            observable.call();
        }
    }
}
