package com.srikanth.fullstackjava.model;

public class Employee {

	private String empName;
	private String email;
	private String location;

	public Employee() {
		super();
	}

	public Employee(String empName, String email, String location) {
		super();
		this.empName = empName;
		this.email = email;
		this.location = location;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
