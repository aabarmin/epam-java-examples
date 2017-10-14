package com.epam.lesson.xml.stax;

import com.sun.xml.internal.stream.events.StartElementEvent;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.XMLEvent;
import java.util.Iterator;
import java.util.LinkedList;

public class StaxEventClient {
    public void run() throws Exception {
        final XMLInputFactory factory = XMLInputFactory.newFactory();
        final XMLEventReader reader = factory.createXMLEventReader(
                getClass().getResourceAsStream(
                        "/source.xml"
                )
        );


        final LinkedList<Node> elements = new LinkedList<>();
        Node currentNode = new Node("root");
        elements.addLast(currentNode);
        while (reader.hasNext()) {
            final XMLEvent next = reader.nextEvent();
            if (XMLEvent.START_ELEMENT == next.getEventType()) {
                if (next instanceof StartElementEvent) {
                    final StartElementEvent startElementEvent = (StartElementEvent) next;
                    currentNode = new Node(
                            startElementEvent.getName().toString()
                    );
                    final Iterator iterator = startElementEvent.getAttributes();
                    while (iterator.hasNext()) {
                        final Attribute attribute = (Attribute) iterator.next();
                        currentNode.addAttribute(
                                attribute.getName().toString(),
                                attribute.getValue()
                        );
                    }
                    elements.addLast(currentNode);
                }
                /*
                currentNode.addAttribute(
                        "from", reader.getProperty("from").toString()
                );
                currentNode.addAttribute(
                        "to", reader.getProperty("to").toString()
                );
                currentNode.addAttribute(
                        "on", reader.getProperty("on").toString()
                );
                */
            } else if (XMLEvent.END_ELEMENT == next.getEventType()) {
                final Node last = elements.removeLast();
                elements.getLast().addChild(last);
            }
        }

        final Node root = elements.getLast();
        System.out.println(root);
    }

    public static void main(String[] args) throws Exception {
        new StaxEventClient().run();
    }
}
