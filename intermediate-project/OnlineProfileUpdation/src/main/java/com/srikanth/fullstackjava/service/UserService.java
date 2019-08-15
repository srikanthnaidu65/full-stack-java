package com.srikanth.fullstackjava.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.srikanth.fullstackjava.entity.UserDetails;
import com.srikanth.fullstackjava.repository.UserDetailsRepository;

/**
 * Service class for user details business operations.
 * Transaction management is handled through Spring Declarative Transaction Management
 *
 * @author  Srikanth Sambirli
 * @version 2.0
 * @since   2018-06-05
 */
@Service
public class UserService {

	@Autowired
	private UserDetailsRepository userDetailsRepository;

	@Transactional(rollbackFor = Exception.class)
	public UserDetails signUp(UserDetails userDetails) {
		return userDetailsRepository.save(userDetails);
	}

	@Transactional(readOnly = true, timeout = 50)
	public List<UserDetails> showAllUsers() {
		return userDetailsRepository.findAll();
	}

	@Transactional(readOnly = true, timeout = 50)
	public Optional<UserDetails> showUserById(String userId) {
		return userDetailsRepository.findById(userId);
	}

	@Transactional(readOnly = true, timeout = 50)
	public UserDetails login(String userId, String password) {
		return userDetailsRepository.findByUserIdAndPassword(userId, password);
	}

}
