package com.jaxb.model;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Employee")
public class Employee {
	private String name;
	private Integer age;
	private Integer id;
	private Company company;

	//@XmlAttribute : it is id of POJO
	//1. we have to add the annotation in POJO on Id's get method
	//2. Then normal things for conversion
	@XmlAttribute
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	@XmlElement(name = "Company")
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", id=" + id + ", company=" + company + "]";
	}

}
