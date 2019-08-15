package com.srikanth.fullstackjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srikanth.fullstackjava.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	
}
