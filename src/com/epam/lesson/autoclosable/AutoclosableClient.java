package com.epam.lesson.autoclosable;

/**
 * @author ABarmin
 */
public class AutoclosableClient {
    public static void main(String[] args) {
        try (final OurClosable closable = new OurClosable()) {
            System.out.println("In the try block");
        } catch (Exception e) {
            System.out.println("Exception handling");
        } finally {
            System.out.println("Finally called");
        }
    }
}

class OurClosable implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("Close method called");
    }
}
