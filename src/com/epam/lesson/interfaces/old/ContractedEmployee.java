package com.epam.lesson.interfaces.old;

public class ContractedEmployee extends AbstractEmployee {
    @Override
    public String[] getSubordinators() throws IllegalArgumentException {
        return new String[0];
    }
}
