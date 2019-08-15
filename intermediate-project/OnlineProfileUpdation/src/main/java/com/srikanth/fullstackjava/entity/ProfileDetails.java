package com.srikanth.fullstackjava.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Entity class for Profile Details.
 * Mapped to profile_details table.
 *
 * @author  Srikanth Sambirli
 * @version 2.0
 * @since   2018-06-05
 */
@Entity
public class ProfileDetails {

	@Id
	@GeneratedValue
	private Integer profileId;
	private String userId;
	private String firstName;
	private	String lastName;
	private	String skillSet;
	private	String location;
	private	String dob;
	private	String qualification;
	private	Integer experience;
	private	String gender;
	private	String phoneNumber;
	private	String emailId;
	private String profileSavedLoc;

	public ProfileDetails() {
		super();
	}

	public ProfileDetails(String userId, String firstName, String lastName, String skillSet, String location,
			String dob, String qualification, Integer experience, String gender, String phoneNumber, String emailId,
			String profileSavedLoc) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.skillSet = skillSet;
		this.location = location;
		this.dob = dob;
		this.qualification = qualification;
		this.experience = experience;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.profileSavedLoc = profileSavedLoc;
	}

	public Integer getProfileId() {
		return profileId;
	}

	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
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

	public String getSkillSet() {
		return skillSet;
	}

	public void setSkillSet(String skillSet) {
		this.skillSet = skillSet;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
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

	public String getProfileSavedLoc() {
		return profileSavedLoc;
	}

	public void setProfileSavedLoc(String profileSavedLoc) {
		this.profileSavedLoc = profileSavedLoc;
	}

	@Override
	public String toString() {
		return "ProfileDetails [profileId=" + profileId + ", userId=" + userId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", skillSet=" + skillSet + ", location=" + location + ", dob=" + dob
				+ ", qualification=" + qualification + ", experience=" + experience + ", gender=" + gender
				+ ", phoneNumber=" + phoneNumber + ", emailId=" + emailId + ", profileSavedLoc=" + profileSavedLoc
				+ "]";
	}

}
