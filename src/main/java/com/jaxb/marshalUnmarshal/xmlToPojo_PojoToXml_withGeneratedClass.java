package com.jaxb.marshalUnmarshal;


import com.jaxb.generated.Status;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.StringReader;

public class xmlToPojo_PojoToXml_withGeneratedClass {
    public static void main(String[] args) throws JAXBException {
        String xml = "<status id=\"1111\">" +
                "<name>StatusClass</name>" +
                "<statusIndex>YES</statusIndex>" +
                "</status>";

        JAXBContext jaxb = JAXBContext.newInstance(Status.class);
        Status status = (Status) jaxb.createUnmarshaller().unmarshal(new StringReader(xml));
        System.out.println("ID: "+status.getId());
        System.out.println("STATUS: "+status.getStatusIndex());
        System.out.println("NAME: "+status.getName());
        System.out.println("******************************************************************************************");

    }
}
