package com.epam.lesson.xml.xslt;

import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.nio.file.Files;

public class XsltClient {
    public void run() throws Exception {
        final TransformerFactory cyberThron = TransformerFactory.newInstance();
        final Templates templates = cyberThron.newTemplates(
                new StreamSource(
                        getClass().getResourceAsStream("/template.xsl")
                )
        );
        final Transformer optimusPrime = templates.newTransformer();
        final StringWriter output = new StringWriter();
        optimusPrime.transform(
                new StreamSource(
                        getClass().getResourceAsStream("/source.xml")
                ),
                new StreamResult(
                        output
                )
        );
        System.out.println(output.getBuffer().toString());
    }

    public static void main(String[] args)throws Exception {
        new XsltClient().run();
    }
}
