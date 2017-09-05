package com.epam.lesson.doc;

import java.io.IOException;
import java.util.Arrays;

/**
 * This class is useful for demonstration purposes.
 *
 * @author Aleksandr
 * @since 1.0
 * @version 2.0
 */
public class ClassForDocumentation {
    // One line comment
    private String value; // one line

    /**
     * This method is very useful.
     *
     * Description of method {@link System}, {@link javax.xml.crypto.Data}
     *
     * @param input source string
     * @return new string
     * @throws IOException if can't convert source to new
     * @throws RuntimeException if weather is cloudy
     */
    public String someMethod(final String input) throws IOException {
        return "";
    }

    /**
     * @deprecated {@link ClassForDocumentation#someMethod(String)}
     * @return
     */
    @Deprecated
    public String deprecatedMethod() {
        return "";
    }

    public static void main(String[] args) {
        final ClassForDocumentation instance = new ClassForDocumentation();
        instance.deprecatedMethod();

        Arrays.asList(
                "First",
                // "Second",
                "Third"
        );

        Arrays.asList("First", /* "Second" ,*/ "Third");

        /*
        First
        Second
        Third
         */
    }
}
