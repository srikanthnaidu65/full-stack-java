package com.srikanth.fullstackjava.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@Column(name = "emp_id")
	private Long empId;

	@Column(name = "emp_name")
	private String empName;

	@Column(name = "emp_doj")
	private Date empDoj;

	@Column(name = "emp_salary")
	private Double empSalary;

	@Column(name = "emp_type")
	private String empType;

	public Employee() {
		super();
	}

	public Employee(Long empId, String empName, Date empDoj, Double empSalary, String empType) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empDoj = empDoj;
		this.empSalary = empSalary;
		this.empType = empType;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Date getEmpDoj() {
		return empDoj;
	}

	public void setEmpDoj(Date empDoj) {
		this.empDoj = empDoj;
	}

	public Double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(Double empSalary) {
		this.empSalary = empSalary;
	}

	public String getEmpType() {
		return empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

}
