package com.srikanth.fullstackjava.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Entity class for User Profile Details.
 * Mapped to user_profile_details table.
 *
 * @author  Srikanth Sambirli
 * @version 1.0
 * @since   2018-06-26
 */
@Entity
public class UserProfileDetails {

	@Id
	private String userId;
	private String firstName;
	private	String lastName;
	private	String city;
	private	String dob;
	private	String gender;
	private	String phoneNumber;
	private	String emailId;

	public UserProfileDetails() {
		super();
	}

	public UserProfileDetails(String userId, String firstName, String lastName, String city,
			String dob, String gender, String phoneNumber, String emailId) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.dob = dob;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "UserProfileDetails [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", city=" + city + ", dob=" + dob + ", gender=" + gender + ", phoneNumber=" + phoneNumber
				+ ", emailId=" + emailId + "]";
	}

}
