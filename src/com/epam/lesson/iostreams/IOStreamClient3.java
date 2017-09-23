package com.epam.lesson.iostreams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

/**
 * @author ABarmin
 */
public class IOStreamClient3 {
    public static void main(String[] args) throws IOException {
        final URL url = IOStreamClient3.class.getResource("/MyFile.txt");
        final String file = url.getFile();

        System.out.println(url);
        System.out.println(file);

        final File dataFile = new File(file);
        System.out.println(dataFile.isFile());
        System.out.println(dataFile.isDirectory());
        System.out.println(dataFile.toString());

//        try (final FileOutputStream outputStream = new FileOutputStream(dataFile)) {
//            for (int i = 0; i < 10; i++) {
//                outputStream.write(
//                        "Это супер строка".getBytes()
//                );
//            }
//        }

/*        try (final BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter(dataFile))) {

            for (int i = 0; i < 10; i++) {
                bufferedWriter.write(
                        "Это супер строка"
                );
            }
        }*/

        try (final PrintWriter printWriter = new PrintWriter(new FileWriter(dataFile))) {
            for (int i = 0; i < 10; i++) {
                printWriter.println(
                        "Это супер строка"
                );
            }
        }

        try (final BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(dataFile))) {

            while (bufferedReader.ready()) {
                final String readLine = bufferedReader.readLine();
                System.out.println(readLine);
            }
        }
    }
}
