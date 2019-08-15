package com.srikanth.fullstackjava.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.srikanth.fullstackjava.entity.UserBankDetails;

/**
 * User Bank Details Repository to perform the database operations
 * on user_bank_details table
 *
 * @author  Srikanth Sambirli
 * @version 1.0
 * @since   2018-06-26
 */
@Repository
public interface UserBankDetailsRepository extends JpaRepository<UserBankDetails, String> {

	@Query("select a from UserBankDetails a where a.userId = :userId")
	List<UserBankDetails> getUserAccountDetails(@Param("userId") String userId);

}
