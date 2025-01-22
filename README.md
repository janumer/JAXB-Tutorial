# JAXB Tutorial Repository

Welcome to the JAXB (Java Architecture for XML Binding) Tutorial repository! This repository contains examples, use cases, and resources to help you understand and use JAXB effectively for XML processing in Java.

## Table of Contents

1. [Introduction](#introduction)
2. [Key Concepts](#key-concepts)
3. [Setup and Configuration](#setup-and-configuration)
4. [Examples](#examples)
    - [Marshalling Example](#marshalling-example)
    - [Unmarshalling Example](#unmarshalling-example)
    - [Customizing Bindings](#customizing-bindings)
    - [Using Annotations](#using-annotations)
5. [Common Issues and Solutions](#common-issues-and-solutions)
6. [References](#references)

## Introduction

JAXB is a framework that allows Java developers to map Java objects to XML representations and vice versa. It is part of the Java EE platform and is commonly used in enterprise applications for XML parsing and generation.

## Key Concepts

- **Marshalling**: Converting Java objects into XML.
- **Unmarshalling**: Converting XML into Java objects.
- **Schema Binding**: Generating Java classes from an XML schema (XSD).
- **Annotations**: Using JAXB annotations to define mappings between Java fields and XML elements.

## Setup and Configuration

To use JAXB in your project, follow these steps:

1. **Add Maven Dependency**:

   ```xml
   <dependency>
       <groupId>javax.xml.bind</groupId>
       <artifactId>jaxb-api</artifactId>
       <version>2.3.1</version>
   </dependency>
   <dependency>
       <groupId>com.sun.xml.bind</groupId>
       <artifactId>jaxb-impl</artifactId>
       <version>2.3.1</version>
   </dependency>
   ```

2. **Import JAXB Classes**:

   ```java
   import javax.xml.bind.JAXBContext;
   import javax.xml.bind.JAXBException;
   import javax.xml.bind.Marshaller;
   import javax.xml.bind.Unmarshaller;
   ```

## Examples

### Marshalling Example

Convert a Java object to an XML string.

```java
@XmlRootElement
public class Employee {
    private String name;
    private int id;

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
}

// Marshalling Code
Employee employee = new Employee();
employee.setName("John Doe");
employee.setId(123);

JAXBContext context = JAXBContext.newInstance(Employee.class);
Marshaller marshaller = context.createMarshaller();
marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
marshaller.marshal(employee, System.out);
```

### Unmarshalling Example

Convert an XML string to a Java object.

```java
String xml = "<employee><name>John Doe</name><id>123</id></employee>";

JAXBContext context = JAXBContext.newInstance(Employee.class);
Unmarshaller unmarshaller = context.createUnmarshaller();
Employee employee = (Employee) unmarshaller.unmarshal(new StringReader(xml));

System.out.println(employee.getName()); // Output: John Doe
```

### Customizing Bindings

Customize the mapping using `@XmlElement` and `@XmlAttribute` annotations.

```java
@XmlRootElement
public class Employee {
    @XmlAttribute
    private int id;
    @XmlElement
    private String name;

    // Getters and setters
}
```

### Using Annotations

Some common JAXB annotations:

- `@XmlRootElement`: Marks a class as the root of the XML.
- `@XmlElement`: Maps a field to an XML element.
- `@XmlAttribute`: Maps a field to an XML attribute.
- `@XmlTransient`: Excludes a field from XML.

## Common Issues and Solutions

- **Missing JAXB in JDK 11+**: Add the JAXB dependencies manually since it's not included in Java SE 11 and later.
- **Namespace Issues**: Use the `@XmlSchema` annotation to define namespaces at the package level.

## References

- [JAXB Documentation](https://docs.oracle.com/javase/tutorial/jaxb/)
- [Oracle JAXB Guide](https://www.oracle.com/java/technologies/javase/jaxb.html)

Feel free to explore, clone, and contribute to this repository. Happy coding!
