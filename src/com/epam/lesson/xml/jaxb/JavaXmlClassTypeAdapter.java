package com.epam.lesson.xml.jaxb;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class JavaXmlClassTypeAdapter extends XmlAdapter<String, Class<?>> {
    @Override
    public Class<?> unmarshal(String v) throws Exception {
        return Class.forName(v);
    }

    @Override
    public String marshal(Class<?> v) throws Exception {
        return v.getName();
    }
}
