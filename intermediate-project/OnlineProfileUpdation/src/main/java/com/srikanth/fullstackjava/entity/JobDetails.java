package com.srikanth.fullstackjava.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Entity class for Job Details.
 * Mapped to job_details table.
 *
 * @author  Srikanth Sambirli
 * @version 2.0
 * @since   2018-06-05
 */
@Entity
public class JobDetails {

	@Id
	@GeneratedValue
	private Integer jobId;
	private String jobName;
	private String jobDescription;
	private String projectName;
	private String requiredSkills;
	private String optionalSkills;
	private String location;
	private String employeeBand;
	private Integer experience;
	private Integer positions;
	private String emailId;
	private String contactNumber;

	public JobDetails(String jobName, String jobDescription, String projectName, String requiredSkills,
			String optionalSkills, String location, String employeeBand, Integer experience, Integer positions,
			String emailId, String contactNumber) {
		super();
		this.jobName = jobName;
		this.jobDescription = jobDescription;
		this.projectName = projectName;
		this.requiredSkills = requiredSkills;
		this.optionalSkills = optionalSkills;
		this.location = location;
		this.employeeBand = employeeBand;
		this.experience = experience;
		this.positions = positions;
		this.emailId = emailId;
		this.contactNumber = contactNumber;
	}

	public JobDetails() {
		super();
	}

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getRequiredSkills() {
		return requiredSkills;
	}

	public void setRequiredSkills(String requiredSkills) {
		this.requiredSkills = requiredSkills;
	}

	public String getOptionalSkills() {
		return optionalSkills;
	}

	public void setOptionalSkills(String optionalSkills) {
		this.optionalSkills = optionalSkills;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmployeeBand() {
		return employeeBand;
	}

	public void setEmployeeBand(String employeeBand) {
		this.employeeBand = employeeBand;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public Integer getPositions() {
		return positions;
	}

	public void setPositions(Integer positions) {
		this.positions = positions;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "JobDetails [jobId=" + jobId + ", jobName=" + jobName + ", jobDescription=" + jobDescription
				+ ", projectName=" + projectName + ", requiredSkills=" + requiredSkills + ", optionalSkills="
				+ optionalSkills + ", location=" + location + ", employeeBand=" + employeeBand + ", experience="
				+ experience + ", positions=" + positions + ", emailId=" + emailId + ", contactNumber=" + contactNumber
				+ "]";
	}

}
