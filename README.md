# JAXB Tutorial - Project README

## Project Overview
This project demonstrates the use of JAXB (Java Architecture for XML Binding) to generate Java classes from an XML Schema (XSD) and handle XML-to-POJO (Plain Old Java Object) and POJO-to-XML conversions. The project is built using **Java 11**, Spring Web (**version 2.7.18**), and Jakarta dependencies. It is configured with a Maven plugin to generate Java classes from the `status.xsd` file.

---

## Project Structure

### 1. **Generated Folder**
- Contains the `status` class generated from the `status.xsd` file.
- Ensures `statusIndex` is represented as an `Integer` (to allow null values), achieved by configuring `minOccurs="0"` and `type="int"` in the XSD schema.

### 2. **Model Folder**
- Includes POJO classes like `Company` and `Employee` annotated with JAXB annotations such as:
    - **`@XmlRootElement`**: Maps a class to an XML root element.
    - **`@XmlElement`**: Maps a field or property to an XML element.
    - **`@XmlAttribute`**: Maps a field or property to an XML attribute.
    - **`@XmlValue`**: Maps a field or property to the text content of an XML element.

### 3. **MarshalUnmarshal Folder**
- Contains classes for:
    - **Marshalling:** Converting Java objects into XML.
    - **Unmarshalling:** Converting XML data into Java objects.

---

## How to Create an XSD File

### Step-by-Step Process to Create an XSD File
1. **Understand XML Structure**
    - Analyze the XML document for which the schema is being created.
    - Identify all elements, attributes, and their relationships.

2. **Start with the XML Declaration**
    - Define the schema namespace using `<xs:schema>`.
      ```xml
      <?xml version="1.0"?>
      <xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema" elementFormDefault="qualified">
      ```

3. **Define Elements**
    - Use `<xs:element>` to define elements and their types.
      ```xml
      <xs:element name="status" type="xs:int"/>
      ```

4. **Define Complex Types**
    - Use `<xs:complexType>` to group multiple elements or attributes.
      ```xml
      <xs:complexType name="Employee">
        <xs:sequence>
          <xs:element name="id" type="xs:int"/>
          <xs:element name="name" type="xs:string"/>
        </xs:sequence>
      </xs:complexType>
      ```

5. **Add Attributes**
    - Use `<xs:attribute>` to define attributes for elements.
      ```xml
      <xs:complexType name="Company">
        <xs:attribute name="id" type="xs:int" use="required"/>
      </xs:complexType>
      ```

6. **Set Cardinality**
    - Use `minOccurs` and `maxOccurs` for repeating or optional elements.
      ```xml
      <xs:element name="employee" type="Employee" minOccurs="0" maxOccurs="unbounded"/>
      ```

7. **Close the Schema**
    - Ensure all elements and attributes are properly nested, and close the `<xs:schema>` tag.
      ```xml
      </xs:schema>
      ```

8. **Save the File**
    - Save the schema as `status.xsd` in the `src/main/resources/schema` directory.

---

## How to Convert Between POJO and XML

### 1. **POJO to XML (Marshalling):**
- Create a `JAXBContext` instance with the target class.
- Use a `Marshaller` to write the POJO to an XML file or string.

### 2. **XML to POJO (Unmarshalling):**
- Create a `JAXBContext` instance with the target class.
- Use an `Unmarshaller` to convert XML data into a Java object.

---

## Dependencies

### **For Java 11**
- **Spring Boot Starter Web:** Provides web support.
- **Jakarta XML Bind API and JAXB Runtime:** Required for JAXB as it is not included in Java 11 or higher.

### **For Java Versions Below 11**
- Java 8 and earlier include JAXB in the JDK, but you can also add dependencies like `javax.xml.bind` and `jaxb-impl` if needed.

---

## How to Run the Project
1. Place the `status.xsd` file in the `src/main/resources/schema` directory.
2. Run Maven to generate classes from the XSD.
3. Use the generated classes and utility methods for XML-to-POJO and POJO-to-XML conversions.

---

## Notes
- The `status` class uses `Integer` for `statusIndex` to allow null values.
- Jakarta dependencies are essential for Java 11 and higher as JAXB is no longer bundled with the JDK.
- Key JAXB annotations used in the project include:
    - **`@XmlRootElement`**: Declares the root element of an XML structure.
    - **`@XmlElement`**: Specifies that a field or property is mapped to an XML element.
    - **`@XmlAttribute`**: Maps a field or property to an XML attribute.
    - **`@XmlValue`**: Maps a field or property to the text content of an XML element.

---
References
https://docs.oracle.com/javase/tutorial/jaxb/
---

Feel free to explore, clone, and contribute to this repository. Happy coding!!!