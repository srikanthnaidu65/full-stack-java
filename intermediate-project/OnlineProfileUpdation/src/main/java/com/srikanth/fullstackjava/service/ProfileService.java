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
 * Service class for profile details business operations.
 * Transaction management is handled through Spring Declarative Transaction Management
 *
 * @author  Srikanth Sambirli
 * @version 2.0
 * @since   2018-06-05
 */
@Service
public class ProfileService {

	@Autowired
	private JobDetailsRepository jobDetailsRepository;

	@Autowired
	private ProfileDetailsRepository profileDetailsRepository;

	@Transactional(rollbackFor = Exception.class)
	public ProfileDetails saveProfile(ProfileDetails profileDetails) {
		return profileDetailsRepository.save(profileDetails);
	}

	@Transactional(rollbackFor = Exception.class)
	public ProfileDetails modifyProfile(ProfileDetails profileDetails) {
		return profileDetailsRepository.save(profileDetails);
	}

	@Transactional(rollbackFor = Exception.class)
	public void deleteProfile(Integer profileId) {
		profileDetailsRepository.deleteById(profileId);
	}

	@Transactional(readOnly = true, timeout = 50)
	public List<JobDetails> showJobsBySkill(String skill) {
		JobDetails jobDetails = new JobDetails();
		jobDetails.setRequiredSkills(skill);
		ExampleMatcher matcher = ExampleMatcher.matching()
				.withStringMatcher(StringMatcher.CONTAINING)
				.withIgnoreCase();
		Example<JobDetails> example = Example.of(jobDetails, matcher); 

		return jobDetailsRepository.findAll(example);
	}

	@Transactional(readOnly = true, timeout = 50)
	public List<JobDetails> showJobsByLocation(String location) {
		JobDetails jobDetails = new JobDetails();
		jobDetails.setLocation(location);
		ExampleMatcher matcher = ExampleMatcher.matching()
				.withStringMatcher(StringMatcher.CONTAINING)
				.withIgnoreCase();
		Example<JobDetails> example = Example.of(jobDetails, matcher); 

		return jobDetailsRepository.findAll(example);
	}

	@Transactional(readOnly = true, timeout = 50)
	public List<JobDetails> showJobsByExperience(Integer exp) {
		return jobDetailsRepository.findByExperience(exp);
	}

	@Transactional(readOnly = true, timeout = 50)
	public Optional<ProfileDetails> getProfileById(Integer profileId) {
		return profileDetailsRepository.findById(profileId);
	}

	@Transactional(readOnly = true, timeout = 50)
	public Optional<ProfileDetails> getProfileByIdAndUserId(Integer profileId, String userId) {
		return profileDetailsRepository.findByProfileIdAndUserId(profileId, userId);
	}

}
