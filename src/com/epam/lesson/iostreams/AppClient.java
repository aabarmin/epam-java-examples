package com.epam.lesson.iostreams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author ABarmin
 */
public class AppClient {
    public static void main(String[] args) throws Exception {
        System.out.println("Client started");

        final Socket socket = new Socket(InetAddress.getLocalHost(), 6000);
        System.out.println("Connected to server");

        try (
                final BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(
                                socket.getOutputStream()
                        )
                );
                final BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                socket.getInputStream()
                        )
                )
        ) {

            final Scanner scanner = new Scanner(System.in);
            String userInput;
            do {
                userInput = scanner.nextLine();

                writer.write(userInput + "\n");
                writer.flush();

                //
                boolean isDone = false;
                while (!isDone) {
                    if (reader.ready()) {
                        final String s = reader.readLine();
                        System.out.println(s);
                        isDone = true;
                    }
                }

            } while (!"0".equals(userInput));
        }

        System.out.println("Client terminated");
    }
}
