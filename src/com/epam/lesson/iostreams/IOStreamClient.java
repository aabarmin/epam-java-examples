package com.epam.lesson.iostreams;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.util.Arrays;

/**
 * @author ABarmin
 */
public class IOStreamClient {
    public static void main(String[] args) throws Exception {
        final String hardCore = "This is Java Hardcore!";
        final ByteArrayInputStream stream =
                new ByteArrayInputStream(hardCore.getBytes());

        final BufferedInputStream inputStream =
                new BufferedInputStream(stream);

        System.out.println(
                inputStream.markSupported()
        );

        byte[] buffer = new byte[5];
        int count = 0;
        while (inputStream.read(buffer) > 0) {
            if (count == 1) {
                inputStream.mark(15);
            }
            if (count == 4) {
                count = 0;
                inputStream.reset();
            }
            count++;
            System.out.println(
                    Arrays.toString(
                            buffer
                    )
            );
        }
    }
}
