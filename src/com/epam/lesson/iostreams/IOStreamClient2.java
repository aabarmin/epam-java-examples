package com.epam.lesson.iostreams;

import java.io.ByteArrayInputStream;
import java.io.SequenceInputStream;

/**
 * @author ABarmin
 */
public class IOStreamClient2 {
    public static void main(String[] args) throws Exception {
        final ByteArrayInputStream stream1 =
                new ByteArrayInputStream(
                        "First string".getBytes()
                );
        final ByteArrayInputStream stream2 =
                new ByteArrayInputStream(
                        "Second string".getBytes()
                );

        final SequenceInputStream stream =
                new SequenceInputStream(
                        stream1,
                        stream2
                );

        byte b;
        while ((b = (byte) stream.read()) != -1) {
            System.out.println(
                    (char) b
            );
        }
    }
}
