package com.jaxb.marshalUnmarshal;

import java.io.StringReader;
import java.io.StringWriter;

import com.jaxb.model.Company;
import com.jaxb.model.Employee;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

public class Xml_ValueAnnotation {
	//used to pass heading for xml
	//like company class is having id i.e attribute but we have name as well in company but that wont be treated as field
	//that will be treated as heading.
	public static void main(String[] args) throws JAXBException {
		String xml = "<Employee id = \"1234\">" 
				+ "<name>Umer</name>" 
				+ "<age>30</age>"
				+ "<Company id = \"9999\">This is my company</Company>"
				+ "</Employee>";
		//xml to pojo
		JAXBContext jaxb = JAXBContext.newInstance(Employee.class);
		Employee empEntity = (Employee) jaxb.createUnmarshaller().unmarshal(new StringReader(xml));
		System.out.println(empEntity);
		System.out.println("********************************************************************************");

		//pojo to xml
		Employee emp = new Employee();
		Company com = new Company();
		com.setId(1111);
		com.setName("Umi");
		
		emp.setCompany(com);
		
		emp.setAge(21);
		emp.setId(1122);
		emp.setName("Fulki");
		
		StringWriter sw = new StringWriter();
		jaxb.createMarshaller().marshal(emp, sw);
		System.out.println(sw);
	}
}
