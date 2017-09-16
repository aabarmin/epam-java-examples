package com.epam.lesson.enums;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.ByteArrayInputStream;

public class SeasonParser extends DefaultHandler {
    private boolean valueStarted = false;
    private Seasons seasons;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("value".equals(qName)) {
            valueStarted = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("value".equals(qName)) {
            valueStarted = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (valueStarted) {
            final String s = new String(ch, start, length);
            seasons = Seasons.valueOf(s);
        }
    }

    public Seasons getSeasons() {
        return seasons;
    }

    public static void main(String[] args) throws Exception {
        final String value = "<data><value>WINTER</value><other>BAGANZA</other></data>";

        final SAXParserFactory factory = SAXParserFactory.newInstance();
        final SAXParser parser = factory.newSAXParser();

        final SeasonParser seasonParser = new SeasonParser();
        parser.parse(new ByteArrayInputStream(value.getBytes()), seasonParser);

        System.out.println(seasonParser.getSeasons());
    }
}
