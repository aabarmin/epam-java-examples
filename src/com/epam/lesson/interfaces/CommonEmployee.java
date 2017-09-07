package com.epam.lesson.interfaces;

public interface CommonEmployee extends
        Entity, HasManager, HasSubordinators {

    String POSITION = "Default Position";
}
