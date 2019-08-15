package com.srikanth.fullstackjava.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity class for User Account Details.
 * Mapped to user_account_details table.
 *
 * @author  Srikanth Sambirli
 * @version 1.0
 * @since   2018-06-26
 */
@Entity
public class UserAccountDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String accountNumber;
	private Double accountBalance;
	private Date updatedDateTime;

	public UserAccountDetails() {
		super();
	}

	public UserAccountDetails(String accountNumber, Double accountBalance, Date updatedDateTime) {
		super();
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		this.updatedDateTime = updatedDateTime;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Date getUpdatedDateTime() {
		return updatedDateTime;
	}

	public void setUpdatedDateTime(Date updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}

	@Override
	public String toString() {
		return "UserAccountDetails [accountNumber=" + accountNumber + ", accountBalance=" + accountBalance
				+ ", updatedDateTime=" + updatedDateTime + "]";
	}

}
