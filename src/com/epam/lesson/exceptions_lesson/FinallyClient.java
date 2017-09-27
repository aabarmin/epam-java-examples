package com.epam.lesson.exceptions_lesson;

/**
 * @author ABarmin
 */
public class FinallyClient {
    public static void main(String[] args) {
        final FinallyClient client = new FinallyClient();
        client.m();
    }

    public void m() {
        System.out.println("Before");
        int i = 0;
        try {
             i = m1();
//            m1();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Catch 2");
        } finally {

        }
        System.out.println(i);
        System.out.println("After");
    }

    private int m1() throws ClassNotFoundException {
        try {
            System.out.println("Before exception");
            // throw new IllegalAccessException("1");
            return 3;
//        } catch (IllegalAccessException e) {
//            System.out.println("Catch 1");
//            // return 1;
//            throw new ClassNotFoundException();
        } catch (Exception e) {
            System.out.println("Common handler");
            System.out.println(e);
        } finally {
            System.out.println("Finally");
            // throw new RuntimeException("2");
            // throw new ClassNotFoundException();
            return 4;
        }
        // return 2;
    }
}
