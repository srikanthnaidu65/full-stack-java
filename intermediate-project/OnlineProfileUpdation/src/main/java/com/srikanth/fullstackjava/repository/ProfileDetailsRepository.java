package com.srikanth.fullstackjava.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import com.srikanth.fullstackjava.entity.ProfileDetails;

/**
 * Profile Details Repository to perform the database operations
 * on profile_details table
 *
 * @author  Srikanth Sambirli
 * @version 2.0
 * @since   2018-06-05
 */
@Repository
public interface ProfileDetailsRepository extends JpaRepository<ProfileDetails, Integer>,
			QueryByExampleExecutor<ProfileDetails> {

	List<ProfileDetails> findByFirstName(String firstName);

	List<ProfileDetails> findByExperience(Integer experience);

	Optional<ProfileDetails> findByProfileIdAndUserId(Integer profileId, String userId);

}
