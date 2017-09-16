package com.epam.lesson.observer;

public interface Observer {
    void register(Observable ob);

    void unregister(Observable ob);
}
