package com.epam.lesson.xml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class SaxParserClient {
    public void run() throws Exception {
        final SAXParserFactory factory = SAXParserFactory.newInstance();
        final SAXParser parser = factory.newSAXParser();
        //
        final SourceHandler handler = new SourceHandler();
        InputSource source = new InputSource(
                getClass().getResourceAsStream("/source.xml")
        );

        parser.parse(
                source,
                handler
        );

        System.out.println(handler.getNode());

        source = new InputSource(
                getClass().getResourceAsStream("/source.xml")
        );

        final ObjectHandler objectHandler = new ObjectHandler();
        parser.parse(source, objectHandler);

        System.out.println(objectHandler.getDefinition());
    }

    public static void main(String[] args) throws Exception {
        final SaxParserClient client = new SaxParserClient();
        client.run();
    }
}

class Definition {
    private final Collection<Transition> transitions = new ArrayList<>();

    public void addTransition(Transition transition) {
        this.transitions.add(transition);
    }
}

class Transition {
    private String from;
    private String to;
    private String on;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getOn() {
        return on;
    }

    public void setOn(String on) {
        this.on = on;
    }
}

class ObjectHandler extends DefaultHandler {
    private Definition definition;
    private Transition currentTransition;

    public Definition getDefinition() {
        return definition;
    }

    @Override
    public void startDocument() throws SAXException {
        this.definition = new Definition();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("transition".equals(qName)) {
            currentTransition = new Transition();
            currentTransition.setFrom(
                    attributes.getValue("from")
            );
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("transition".equals(qName)) {
            this.definition.addTransition(this.currentTransition);
        }
    }
}

class SourceHandler extends DefaultHandler {
    private Node currentNode;
    private Node node = new Node("root");
    private LinkedList<Node> elements = new LinkedList<>();

    public Node getNode() {
        return this.node;
    }

    @Override
    public void startDocument() throws SAXException {
        this.elements.addLast(node);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentNode = new Node(qName);
        this.elements.addLast(currentNode);
        System.out.println("start " + qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            currentNode.addAttribute(
                    attributes.getQName(i),
                    attributes.getValue(i)
            );
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End " + qName);
        //
        final Node lastNode = this.elements.removeLast();
        //
        this.elements.getLast().addChild(lastNode);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (this.currentNode != null) {
            this.currentNode.setValue(
                    new String(ch, start, length)
            );
        }
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        super.warning(e);
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        super.error(e);
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        System.out.println("Something goes wrong");
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