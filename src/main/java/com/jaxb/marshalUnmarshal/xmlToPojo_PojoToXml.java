package com.jaxb.marshalUnmarshal;

import java.io.StringReader;

import com.jaxb.model.Employee;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class xmlToPojo_PojoToXml {

	public static void main(String[] args) throws JAXBException {
		//XML to POJO
		//1. create POJO to bind into.
		//2. create jaxbContext object, call newInstance & pass that POJO class
		//3. call createUnmarshaller method
		//4. from 3, call unmarshal, pass xml and return POJO
		String xml = "<Employee id=\"1234\"> "
				+ "<name>UmerJan</name>"
				+ "<age>18</age>"
				+ "</Employee>";
		JAXBContext jaxb = JAXBContext.newInstance(Employee.class);
		Unmarshaller unmarshaller = jaxb.createUnmarshaller();
		Employee emp = (Employee)unmarshaller.unmarshal(new StringReader(xml));
		System.out.println(emp);
		System.out.println("********************************************************************************");

		//POJO to xml
		//1. create BEAN to bind into.
		//2. create jaxbContext object, call newInstance & pass that POJO class
		//3. call createMarshaller method
		//4. from 3, call marshal, pass POJO, StringWriter obj and return XML
		
		Marshaller marshaller = jaxb.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		Employee emp1 = new Employee();
		emp1.setAge(19);emp1.setName("Windows");
		emp1.setId(9999);

		marshaller.marshal(emp1, System.out);

	}
}
