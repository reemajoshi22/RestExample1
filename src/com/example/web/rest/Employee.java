package com.example.web.rest;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Employee {
	int emp_id;
	String emp_name;
	String employee_dept;
	Float employee_salary;

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public void setEmployee_dept(String employee_dept) {
		this.employee_dept = employee_dept;
	}

	public void setEmployee_salary(Float employee_salary) {
		this.employee_salary = employee_salary;
	}

	public void print() {
		System.out.println("employee id is " + emp_id + "\n employee name is"
				+ emp_name + "\n employee department is" + employee_dept
				+ "\n employee salary is" + employee_salary);
	}
	/*
	 * @XmlAttribute public int getEmp_id() { return emp_id; }
	 * 
	 * @XmlAttribute public String getEmp_name() { return emp_name; }
	 * 
	 * @XmlAttribute public String getEmployee_dept() { return employee_dept; }
	 * 
	 * @XmlAttribute public Float getEmployee_salary() { return employee_salary;
	 * }
	 */
	@XmlAttribute
	public int getEmp_id() {
		return emp_id;
	}
	@XmlAttribute
	public String getEmp_name() {
		return emp_name;
	}
	@XmlAttribute
	public String getEmployee_dept() {
		return employee_dept;
	}
	@XmlAttribute
	public Float getEmployee_salary() {
		return employee_salary;
	}
}
