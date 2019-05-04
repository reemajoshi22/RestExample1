package com.example.web.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Path("/hello")
public class HelloWorldResource {
	private static ApplicationContext applicationContext;
	private Employee employee;
	private XmlMarshaller xmlMarshaller;

	public HelloWorldResource() {
		applicationContext = new ClassPathXmlApplicationContext(
				"AppContext.xml");
		employee = (Employee) applicationContext.getBean("employee");
		xmlMarshaller = (XmlMarshaller) applicationContext
				.getBean("xmlMarshaller");
	}

	/*
	 * public static ApplicationContext getApplicationContext() {
	 * if(applicationContext==null){ applicationContext=new
	 * ClassPathXmlApplicationContext( "AppContext.xml"); } else{
	 * System.out.println("Already Intialised"); } return applicationContext; }
	 */
	@GET
	@Produces("text/xml")
	public String message() {
		employee.print();
		return xmlMarshaller.marshal(employee);
	}

	@POST
	//@Consumes(MediaType.TEXT_XML)
	@Produces({ "application/xml", "text/xml" })
	/*@Produces(MediaType.TEXT_PLAIN)*/
	public String getXml(String inputXML) {
		XmlMarshaller unmarshaller = new XmlMarshaller();
		return unmarshaller.unmarshal(inputXML);

	}
	
	/*@GET
	@Path("/xmlbind")
	@Produces({MediaType.APPLICATION_XML})
	public Employee bindXml(){
		Employee employee=new Employee();
		employee.setEmp_id(0);
		employee.setEmp_name("reema");
		employee.setEmployee_dept("ece");
		employee.setEmployee_salary(100.1f);
		return employee;
		
	}
*/
}
