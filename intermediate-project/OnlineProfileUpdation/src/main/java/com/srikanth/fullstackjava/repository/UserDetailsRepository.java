package com.srikanth.fullstackjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srikanth.fullstackjava.entity.UserDetails;

/**
 * User Details Repository to perform the database operations
 * on user_details table
 *
 * @author  Srikanth Sambirli
 * @version 2.0
 * @since   2018-06-05
 */
@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, String> {

	UserDetails findByUserIdAndPassword(String userId, String password);

}
