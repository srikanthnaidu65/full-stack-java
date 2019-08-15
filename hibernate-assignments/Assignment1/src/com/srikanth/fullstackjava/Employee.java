package com.srikanth.fullstackjava;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@Column(name = "employee_id")
	private Integer employeeId;

	@Column(name = "employee_name")
	private String employeeName;

	@Column(name = "employee_band")
	private String employeeBand;

	public Employee(Integer employeeId, String employeeName, String employeeBand) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeBand = employeeBand;
	}

	public Employee() {
		super();
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeBand="
				+ employeeBand + "]";
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeBand() {
		return employeeBand;
	}

	public void setEmployeeBand(String employeeBand) {
		this.employeeBand = employeeBand;
	}
}
