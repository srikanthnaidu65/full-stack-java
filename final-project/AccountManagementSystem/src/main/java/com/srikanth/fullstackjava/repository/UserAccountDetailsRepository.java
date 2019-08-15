package com.srikanth.fullstackjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srikanth.fullstackjava.entity.UserAccountDetails;

/**
 * User Account Details Repository to perform the database operations
 * on user_account_details table
 *
 * @author  Srikanth Sambirli
 * @version 1.0
 * @since   2018-06-26
 */
@Repository
public interface UserAccountDetailsRepository extends JpaRepository<UserAccountDetails, String> {

}
