package com.epam.lesson.locale;

import java.util.Locale;

/**
 * @author ABarmin
 */
public class LocaleClient {
    public static void main(String[] args) {
//        final Locale[] locales = Locale.getAvailableLocales();
//        for (Locale locale : locales) {
//            System.out.println(locale);
//        }

        final Locale locale = new Locale("en", "CA"); //Locale.getDefault();
        System.out.println(
                locale.getDisplayCountry()
        );
        System.out.println(
                locale.getDisplayCountry(
                        Locale.CHINESE
                )
        );
        System.out.println(
                locale.getDisplayLanguage()
        );
        System.out.println(
                locale.getDisplayScript()
        );
        System.out.println(
                locale.getDisplayVariant()
        );

        for (Locale locale1 : Locale.getAvailableLocales()) {
            // System.out.println(locale1);
        }
    }
}
