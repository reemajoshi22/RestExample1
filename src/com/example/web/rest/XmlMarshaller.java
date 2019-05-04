package com.example.web.rest;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XmlMarshaller {

	String unmarshal(String inputXML) {
		String response = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			StringReader readerXML = new StringReader(inputXML);
			Employee employee = (Employee) unmarshaller.unmarshal(readerXML);
			System.out.println("employee " + employee.getEmp_id());
			response = employee.getEmp_name();
		} catch (JAXBException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
	
	String marshal(Employee employee) {
		String response = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			  StringWriter writer = new StringWriter();
			marshaller.marshal(employee,writer );
			response=writer.toString();
			System.out.println(response);
		} catch (JAXBException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

}
