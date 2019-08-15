package com.srikanth.fullstackjava;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@Column(name = "emp_id")
	private Integer empId;

	@Column(name = "emp_name")
	private String empName;

	@Column(name = "city")
	private String city;

	@OneToOne(targetEntity=Passport.class,cascade=CascadeType.ALL)
	@JoinColumn(name="passport_no", referencedColumnName="passport_no")
	private Passport passport;

	public Employee() {
		super();
	}

	public Employee(Integer empId, String empName, String city, Passport passport) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.city = city;
		this.passport = passport;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}
}
