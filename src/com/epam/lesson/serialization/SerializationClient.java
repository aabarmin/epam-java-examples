package com.epam.lesson.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author ABarmin
 */
public class SerializationClient {
    public static void main(String[] args) throws Exception {
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        final SomeClass aClass = new SomeClass();
        objectOutputStream.writeObject(aClass);

        objectOutputStream.close();

        System.out.println(outputStream.toByteArray());

        final ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        final ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        final Object readObject = objectInputStream.readObject();

        System.out.println(readObject);

        inputStream.close();
    }
}

class SomeClass implements Serializable {

}
