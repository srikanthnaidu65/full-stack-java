package com.srikanth.fullstackjava.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Entity class for User Bank Details.
 * Mapped to user_bank_details table.
 *
 * @author  Srikanth Sambirli
 * @version 1.0
 * @since   2018-06-26
 */
@Entity
public class UserBankDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String bankId;
	private String userId;
	private String bankName;
	private String accountType;

	@OneToOne(targetEntity = UserAccountDetails.class, cascade=CascadeType.ALL)
	@JoinColumn(name = "accountNumber", referencedColumnName = "accountNumber")
	private UserAccountDetails userAccountDetails;

	public UserBankDetails() {
		super();
	}

	public UserBankDetails(String bankId, String userId, String bankName,
			String accountType, UserAccountDetails userAccountDetails) {
		super();
		this.bankId = bankId;
		this.userId = userId;
		this.bankName = bankName;
		this.accountType = accountType;
		this.userAccountDetails = userAccountDetails;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public UserAccountDetails getUserAccountDetails() {
		return userAccountDetails;
	}

	public void setUserAccountDetails(UserAccountDetails userAccountDetails) {
		this.userAccountDetails = userAccountDetails;
	}

	@Override
	public String toString() {
		return "UserBankDetails [bankId=" + bankId + ", userId=" + userId + ", bankName=" + bankName + ", accountType="
				+ accountType + ", userAccountDetails=" + userAccountDetails + "]";
	}

}
