package com.srikanth.fullstackjava.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Entity class for User Details.
 * Mapped to user_details table.
 *
 * @author  Srikanth Sambirli
 * @version 2.0
 * @since   2018-06-05
 */
@Entity
public class UserDetails {

	@Id
	private String userId;
	private String password;
	private String userType;

	public UserDetails() {
		super();
	}

	public UserDetails(String userId, String password, String userType) {
		super();
		this.userId = userId;
		this.password = password;
		this.userType = userType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userType=" + userType + "]";
	}

}
