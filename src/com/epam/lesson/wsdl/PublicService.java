package com.epam.lesson.wsdl;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class PublicService {
    public String someMethod(String first,
                             String second) {

        return first + " " + second;
    }
}
