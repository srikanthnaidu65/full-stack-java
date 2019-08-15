package com.srikanth.fullstackjava.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.srikanth.fullstackjava.entity.UserLoginDetails;
import com.srikanth.fullstackjava.entity.UserProfileDetails;
import com.srikanth.fullstackjava.repository.UserLoginDetailsRepository;
import com.srikanth.fullstackjava.repository.UserProfileDetailsRepository;

/**
 * Service class for user details business operations.
 * Transaction management is handled through Spring Declarative Transaction Management
 *
 * @author  Srikanth Sambirli
 * @version 1.0
 * @since   2018-06-26
 */
@Service
public class UserDetailsService {

	@Autowired
	private UserLoginDetailsRepository userLoginDetailsRepository;

	@Autowired
	private UserProfileDetailsRepository userProfileDetailsRepository;

	/**
	 * This method is used to save the user profile details
	 * 
	 * @param userProfileDetails
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public UserProfileDetails save(UserProfileDetails userProfileDetails) {
		return userProfileDetailsRepository.save(userProfileDetails);
	}

	/**
	 * This method is used to fetch the user profile details
	 * identified by the userId
	 * 
	 * @param userId
	 * @return
	 */
	@Transactional(readOnly = true, timeout = 50)
	public Optional<UserProfileDetails> showUserProfileDetailsById(String userId) {
		return userProfileDetailsRepository.findById(userId);
	}

	/**
	 * This method is used to validate the user login details
	 * 
	 * @param userId
	 * @param password
	 * @param bankName
	 * @return
	 */
	@Transactional(readOnly = true, timeout = 50)
	public UserLoginDetails login(String userId, String password, String bankName) {
		return userLoginDetailsRepository.findByUserIdAndPasswordAndBank(userId, password, bankName);
	}

	/**
	 * This method is used to update the user profile details
	 * 
	 * @param userProfileDetails
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public UserProfileDetails modifyProfile(UserProfileDetails userProfileDetails) {
		return userProfileDetailsRepository.save(userProfileDetails);
	}

}
