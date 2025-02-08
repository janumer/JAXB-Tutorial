package com.jaxb.marshalUnmarshal;

import java.io.StringReader;
import java.io.StringWriter;

import com.jaxb.model.Employee;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

public class Xml_AttributeAnnotation {
//@XmlAttribute : it is kind of id of POJO
	//1. we have to add the annotation in POJO on Id's get method
	//2. Then normal things for conversion
	public static void main(String[] args) throws JAXBException {
		String xml = "<Employee id=\"1234\">"
				+ "<name>XmlAttributeName</name>"
				+ "<age>15</age>"
				+ "</Employee>";
		
		//XML to POJO
		JAXBContext jaxb = JAXBContext.newInstance(Employee.class);
		Employee emp = (Employee)jaxb.createUnmarshaller().unmarshal(new StringReader(xml));
		System.out.println(emp);
		System.out.println("********************************************************************************");

		//POJO to XML
		Employee emp1 = new Employee();
		emp1.setAge(10);
		emp1.setId(56789);
		emp.setName("POJO");
		jaxb.createMarshaller().marshal(emp1, System.out);
		
	}}
