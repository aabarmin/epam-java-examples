package com.epam.lesson.locale;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * @author ABarmin
 */
public class NumberFormatClient {
    public static void main(String[] args) throws Exception {
        final NumberFormat russianNumbers =
                NumberFormat.getCurrencyInstance(
                        new Locale("ru", "RU"));

        final NumberFormat chineseNumbers =
                NumberFormat.getCurrencyInstance(Locale.FRANCE);

        System.out.println(
                russianNumbers.format(1.46)
        );
        System.out.println(
                chineseNumbers.format(1.46)
        );

        final Number number = russianNumbers.parse("1,46 руб.");
        System.out.println(number);

        // russianNumbers.parse("1,46 €");
        System.out.println(
                chineseNumbers.parse("1,46 €")
        );

        System.out.println(
                NumberFormat.getNumberInstance()
                        .format(1.1236567)
        );
    }
}
