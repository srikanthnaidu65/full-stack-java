package com.srikanth.fullstackjava;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="contract_employee")
public class ContractEmployee extends Employee{

	private int allowance;

	public int getAllowance() {
		return allowance;
	}

	public void setAllowance(int allowance) {
		this.allowance = allowance;
	}

}
