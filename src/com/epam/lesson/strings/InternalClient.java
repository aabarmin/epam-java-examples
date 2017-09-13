package com.epam.lesson.strings;

import java.util.Scanner;

/**
 * @author ABarmin
 */
public class InternalClient {
    public static void main(String[] args) {
        String userInput = "0";
        String previousValue = "0";
        final Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Input string");
            userInput = scanner.nextLine();

            System.out.println("prev: " + previousValue);
            System.out.println("==: " + (userInput == previousValue));
            System.out.println("eq: " + (userInput.equals(previousValue)));
            System.out.println("hc: " + userInput.hashCode());
            System.out.println("in: " + (userInput.intern() == previousValue.intern()));

            previousValue = userInput;

        } while (!userInput.equals("0"));
    }
}
