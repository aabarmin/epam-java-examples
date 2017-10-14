package com.epam.lesson.exceptions_lesson;

/**
 * @author ABarmin
 */
public class ExceptionInheritanceClient {
    public static void main(String[] args) {
        Parent p = new Child();
    }
}

class Parent {
    public void m() throws MyException {

    }
}

class Child extends Parent {
    @Override
    public void m() throws MyThirdException, MySecondException {

    }
}

class MyException extends Exception {

}

class MySecondException extends MyException {

}

class MyThirdException extends MyException {

}