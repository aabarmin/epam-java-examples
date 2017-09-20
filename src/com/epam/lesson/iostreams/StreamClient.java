package com.epam.lesson.iostreams;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author ABarmin
 */
public class StreamClient {
    public static void main(String[] args) throws Exception {
        final PipedInputStream inputStream = new PipedInputStream();
        final PipedOutputStream outputStream = new PipedOutputStream(inputStream);

        outputStream.write(1);
        outputStream.write(2);

        System.out.println(inputStream.available());
        while (inputStream.available() > 0) {
            final int read = inputStream.read();
            System.out.println(read);
        }
    }
}
