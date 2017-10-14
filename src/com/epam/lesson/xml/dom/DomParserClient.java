package com.epam.lesson.xml.dom;

import com.sun.org.apache.xerces.internal.impl.xs.identity.Field;
import com.sun.org.apache.xerces.internal.impl.xs.identity.Selector;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import com.sun.org.apache.xpath.internal.XPath;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DomParserClient {
    public static void main(String[] args) throws Exception {
        final DOMParser parser = new DOMParser();
        parser.parse(
                new InputSource(
                        DomParserClient.class.getResourceAsStream("/source.xml")
                )
        );
        final Document document = parser.getDocument();
        final NodeList transitions = document.getElementsByTagName("transition");

        for (int i = 0; i < transitions.getLength(); i++) {
            final Node item = transitions.item(i);
            System.out.println(item.getNodeName());

            final NamedNodeMap attributes = item.getAttributes();
            for (int j = 0; j < attributes.getLength(); j++) {
                final Attr attribute = (Attr) attributes.item(j);
                System.out.println(" " +
                        attribute.getName() + " - " +
                        attribute.getValue()
                );
            }
        }
    }
}
