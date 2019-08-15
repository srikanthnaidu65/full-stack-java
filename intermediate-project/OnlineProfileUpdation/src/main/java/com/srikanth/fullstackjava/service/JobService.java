package com.srikanth.fullstackjava.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.srikanth.fullstackjava.entity.JobDetails;
import com.srikanth.fullstackjava.entity.ProfileDetails;
import com.srikanth.fullstackjava.repository.JobDetailsRepository;
import com.srikanth.fullstackjava.repository.ProfileDetailsRepository;

/**
 * Service class for job details business operations.
 * Transaction management is handled through Spring Declarative Transaction Management
 *
 * @author  Srikanth Sambirli
 * @version 2.0
 * @since   2018-06-05
 */
@Service
public class JobService {

	@Autowired
	private JobDetailsRepository jobDetailsRepository;

	@Autowired
	private ProfileDetailsRepository profileDetailsRepository;

	@Transactional(rollbackFor = Exception.class)
	public JobDetails addJob(JobDetails job) {
		return jobDetailsRepository.save(job);
	}

	@Transactional(rollbackFor = Exception.class)
	public JobDetails modifyJob(JobDetails job) {
		return jobDetailsRepository.save(job);
	}

	@Transactional(rollbackFor = Exception.class)
	public void deleteJob(int jobID) {
		jobDetailsRepository.deleteById(jobID);
	}

	@Transactional(readOnly = true, timeout = 50)
	public List<ProfileDetails> showProfilesByName(String name) {
		ProfileDetails profileDetails = new ProfileDetails();
		profileDetails.setFirstName(name);
		ExampleMatcher matcher = ExampleMatcher.matching()
				.withStringMatcher(StringMatcher.CONTAINING)
				.withIgnoreCase();
		Example<ProfileDetails> example = Example.of(profileDetails, matcher); 

		return profileDetailsRepository.findAll(example);
	}

	@Transactional(readOnly = true, timeout = 50)
	public List<ProfileDetails> showProfilesBySkill(String skill) {
		ProfileDetails profileDetails = new ProfileDetails();
		profileDetails.setSkillSet(skill);
		ExampleMatcher matcher = ExampleMatcher.matching()
				.withStringMatcher(StringMatcher.CONTAINING)
				.withIgnoreCase();
		Example<ProfileDetails> example = Example.of(profileDetails, matcher); 

		return profileDetailsRepository.findAll(example);
	}

	@Transactional(readOnly = true, timeout = 50)
	public List<ProfileDetails> showProfilesByLocation(String location) {
		ProfileDetails profileDetails = new ProfileDetails();
		profileDetails.setLocation(location);
		ExampleMatcher matcher = ExampleMatcher.matching()
				.withStringMatcher(StringMatcher.CONTAINING)
				.withIgnoreCase();
		Example<ProfileDetails> example = Example.of(profileDetails, matcher); 

		return profileDetailsRepository.findAll(example);
	}

	@Transactional(readOnly = true, timeout = 50)
	public List<ProfileDetails> showProfilesByExperience(Integer exp) {
		return profileDetailsRepository.findByExperience(exp);
	}

	@Transactional(readOnly = true, timeout = 50)
	public Optional<JobDetails> getJobById(Integer jobId) {
		return jobDetailsRepository.findById(jobId);
	}

}
