package com.srikanth.fullstackjava.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srikanth.fullstackjava.model.Account;
import com.srikanth.fullstackjava.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository repository;

	public Optional<Account> getBalance(Long accNo) {
		return repository.findById(accNo);
	}

	public void deposit(Long accNo, Long amount) {
		Optional<Account> account = repository.findById(accNo);
		if (account.isPresent()) {
			Account a = account.get();
			a.setBalance(a.getBalance() + amount);
			repository.save(a);
		} else {
			Account a = new Account();
			a.setAccNo(accNo);
			a.setBalance(amount);
			repository.save(a);
		}
	}

	public int withdraw(Long accNo, Long amount) {
		Optional<Account> account = repository.findById(accNo);
		if (account.isPresent()) {
			Account a = account.get();
			Long balance = a.getBalance() - amount;
			if (balance < 1000) {
				return -1;
			} else {
				a.setBalance(balance);
				repository.save(a);
				return 1;
			}
		} else {
			return 0;
		}
	}

	public AccountRepository getRepository() {
		return repository;
	}

	public void setRepository(AccountRepository repository) {
		this.repository = repository;
	}

}
