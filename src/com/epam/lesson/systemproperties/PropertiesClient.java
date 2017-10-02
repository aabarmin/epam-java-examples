package com.epam.lesson.systemproperties;

import java.util.Map;
import java.util.Properties;

public class PropertiesClient {
    public static void main(String[] args) {
        final Properties properties = System.getProperties();
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
