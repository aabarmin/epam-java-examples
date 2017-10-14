package com.epam.lesson.wsdl;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.BindingType;
import javax.xml.ws.Endpoint;

public class WsdlServicePublisher {
    public static void main(String[] args) {
        Endpoint.publish(
                "http://localhost:1212/hello",
                new PublicService()
        );
        System.out.println("Started");
    }
}
