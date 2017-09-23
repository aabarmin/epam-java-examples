package com.epam.lesson.iostreams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ABarmin
 */
public class AppServer {
    public static void main(String[] args) throws Exception {
        System.out.println("Server started");
        final ServerSocket serverSocket = new ServerSocket(6000);
        final Socket clientSocket = serverSocket.accept();

        System.out.println("Client connected");
        try (
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                clientSocket.getInputStream()
                        )
                );
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(
                                clientSocket.getOutputStream()
                        )
                )
        ) {

            System.out.println("Readers created");
            while (true) {
                if (reader.ready()) {
                    final String fromClient = reader.readLine();
                    System.out.println(
                            fromClient
                    );

                    writer.write("From server: " + fromClient + "\n");
                    writer.flush();
                }
            }

        }
    }
}
