package com.epam.lesson.locale;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author ABarmin
 */
public class ResourceBundleClient {
    public static void main(String[] args) {
        final ResourceBundle bundle =
                ResourceBundle.getBundle(
                        "appData",
                        new Locale("ru", "RU", "windows")
                );
        System.out.println(
                bundle.getString("message1")
        );
        System.out.println(
                bundle.getString("message2")
        );

        System.out.println(
                bundle.getString("message3")
        );

        System.out.println(
                String.format(
                        bundle.getString("message4"),
                        10
                )
        );
    }
}
