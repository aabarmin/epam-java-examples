package com.epam.lesson.generics.right;

import java.io.Serializable;
import java.util.Date;

public class GenericClient {
    public static void main(String[] args) {
        final DefaultGeneric<Object> objectDefaultGeneric = new DefaultGeneric<>();
        objectDefaultGeneric.setValue(new Integer(10));

        final DefaultGeneric<Number> numberDefaultGeneric = new DefaultGeneric<>();
        numberDefaultGeneric.setValue(10);
        numberDefaultGeneric.setValue(10.0);
        // numberDefaultGeneric.setValue(new Object()); not a Number child

        final DefaultGeneric<?> anyDefaultGeneric = new DefaultGeneric<>();
        anyDefaultGeneric.setValue(null);
        // anyDefaultGeneric.setValue(new Object()); we can't determine output type
        // anyDefaultGeneric.setValue(20);
        final Object value = anyDefaultGeneric.getValue();

        final DefaultGeneric<? extends Number> extNumber = new DefaultGeneric<Integer>();
        extNumber.setValue(null);
        // extNumber.setValue(new Object());
        // extNumber.setValue(new Integer(10)); ????
        // extNumber.setValue(10.0);
        final Number value1 = extNumber.getValue();

        final DefaultGeneric<? extends Serializable> serializableGeneric = new DefaultGeneric<>();
        serializableGeneric.setValue(null);
        // serializableGeneric.setValue(new Date());
        final Serializable value2 = serializableGeneric.getValue();

        final DefaultGeneric<? super Number> superNumber = new DefaultGeneric<>();
        superNumber.setValue(new Integer(10));
        superNumber.setValue(10.0);
        superNumber.setValue(10L);
        // superNumber.setValue(new Object());
        superNumber.setValue(null);

        final DefaultGeneric<? extends Object> objectGeneric = new DefaultGeneric<>();
        // objectGeneric.setValue(10);
        objectGeneric.setValue(null);
        final Object value3 = objectGeneric.getValue();
    }
}
