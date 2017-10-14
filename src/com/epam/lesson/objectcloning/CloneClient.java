package com.epam.lesson.objectcloning;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * @author ABarmin
 */
public class CloneClient {
    public static void main(String[] args) {
        final Date date = new Date();

        ByteArrayOutputStream arrayOutputStream = null;
        try {
            arrayOutputStream = new ByteArrayOutputStream();

            try (
                    final ObjectOutputStream outputStream =
                         new ObjectOutputStream(arrayOutputStream);
                    ) {

                outputStream.writeObject(date);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try (final ObjectInputStream inputStream =
                         new ObjectInputStream(
                                 new ByteArrayInputStream(
                                         arrayOutputStream.toByteArray()
                                 )
                         )) {

                final Object o = inputStream.readObject();
                System.out.println(o);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } finally {
            if (arrayOutputStream != null) {
                try {
                    arrayOutputStream.close();
                } catch (IOException ignored) {}
            }
        }

    }
}
