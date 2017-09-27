package com.epam.lesson.objectstreams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.net.URL;

/**
 * @author ABarmin
 */
public class ObjectStreamClient {
    public static void main(String[] args) {
        final URL url =
                ObjectStreamClient.class.getResource("/MyFile.txt");
        final File destination = new File(url.getFile());

        try (final ObjectOutputStream outputStream =
                     new ObjectOutputStream(
                             new FileOutputStream(destination))) {

            final WrapperClass object =
                    new WrapperClass("Constructor value");

            object.setValue("Another value");

            outputStream.writeObject(object);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("---------");

        try (final ObjectInputStream inputStream =
                     new ObjectInputStream(new FileInputStream(destination))) {

            final Object object = inputStream.readObject();
            System.out.println(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class WrapperClass extends NonSerializable implements Serializable {
//    public WrapperClass() {
//        System.out.println("WrapperClass constructor");
//    }


    public WrapperClass(String value) {
        super(value);
    }

  private void writeObject(java.io.ObjectOutputStream stream)
      throws IOException {

      System.out.println("writeObject");
  }
  private void readObject(java.io.ObjectInputStream stream)
      throws IOException, ClassNotFoundException {

      System.out.println("readObject");
  }
  private void readObjectNoData()
      throws ObjectStreamException {

      System.out.println("readObjectNoData");
  }
}

class NonSerializable {
    private String value;

    public NonSerializable() {
        value = "NonSerializable value";
        System.out.println("NonSerializable constructor");
    }

    public NonSerializable(String value) {
        this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "NonSerializable{" +
                "value='" + value + '\'' +
                '}';
    }
}