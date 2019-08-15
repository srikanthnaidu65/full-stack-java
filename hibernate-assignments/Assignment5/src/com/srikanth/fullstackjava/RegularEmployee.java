package com.srikanth.fullstackjava;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="regular_employee")
public class RegularEmployee extends Employee{

	private int qplc;

	public int getQplc() {
		return qplc;
	}

	public void setQplc(int qplc) {
		this.qplc = qplc;
	}
}
