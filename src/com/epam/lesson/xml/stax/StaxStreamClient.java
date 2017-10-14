package com.epam.lesson.xml.stax;

import com.epam.lesson.innerclasses.statical.StaticClassClient;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class StaxStreamClient {
    public void run() throws Exception {
        final XMLInputFactory factory = XMLInputFactory.newFactory();
        final XMLStreamReader reader = factory.createXMLStreamReader(
                getClass().getResourceAsStream(
                        "/source.xml"
                )
        );

        final LinkedList<Node> elements = new LinkedList<>();
        Node currentNode = new Node("root");
        elements.addLast(currentNode);
        while (reader.hasNext()) {
            final int next = reader.next();
            if (XMLStreamConstants.START_ELEMENT == next) {
                currentNode = new Node(
                        reader.getName().toString()
                );
                elements.addLast(currentNode);
                currentNode.addAttribute(
                        "from", reader.getAttributeValue(0)
                );
                currentNode.addAttribute(
                        "to", reader.getAttributeValue(1)
                );
                currentNode.addAttribute(
                        "on", reader.getAttributeValue(2)
                );
            } else if (XMLStreamConstants.END_ELEMENT == next) {
                final Node last = elements.removeLast();
                elements.getLast().addChild(last);
            }
        }

        final Node root = elements.getLast();
        System.out.println(root);
    }

    public static void main(String[] args) throws Exception {
        new StaxStreamClient().run();
    }
}

class Node {
    private final Map<String, String> attributes = new HashMap<>();
    private final Collection<Node> children = new ArrayList<>();
    private final String name;
    private String value;

    public Node(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void addAttribute(String name, String value) {
        this.attributes.put(name, value);
    }

    public void addChild(Node child) {
        this.children.add(child);
    }
}
