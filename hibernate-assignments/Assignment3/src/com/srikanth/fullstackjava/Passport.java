package com.srikanth.fullstackjava;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "passport")
public class Passport {

	@Id
	@Column(name = "passport_no")
	private String passportNo;

	@Column(name = "issue_authority")
	private String issueAuthority;

	public Passport() {
		super();
	}

	public Passport(String passportNo, String issueAuthority) {
		super();
		this.passportNo = passportNo;
		this.issueAuthority = issueAuthority;
	}

	public String getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	public String getIssueAuthority() {
		return issueAuthority;
	}

	public void setIssueAuthority(String issueAuthority) {
		this.issueAuthority = issueAuthority;
	}
}
