package com.epam.lesson.exceptions_lesson;

/**
 * @author ABarmin
 */
public class UnaccessibleCodeClient {
    public static void main(String[] args) throws Exception {
        if (false) {
            System.out.println("111");
        } else {
            System.out.println("555");
        }
        // throw new Exception();
        System.out.println("222");

        while (true) {
            System.out.println("333");
        }
        // System.out.println("444");
    }
}
