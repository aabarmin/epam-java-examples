package com.epam.lesson.exceptions_lesson;

import java.io.IOException;

/**
 * @author ABarmin
 */
public class MultipleTryClient {
    public static void main(String[] args) throws Exception {
        final MultipleTryClient client = new MultipleTryClient();
        client.run();
    }

    public void run() {
        try {
            try {
                methodSome();
            } catch (ClassNotFoundException e) {

            }
        } catch (IOException e) {

        }
    }

    private void methodSome() throws IOException, ClassNotFoundException {

    }
}
