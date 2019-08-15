package com.srikanth.fullstackjava.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.srikanth.fullstackjava.model.Account;
import com.srikanth.fullstackjava.service.AccountService;

@Controller
public class AccountController {

	@Autowired
	AccountService service;

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/getBalance")
	public ResponseEntity<Account> getBalance(@RequestParam("accNo") Long accNo) {
		Optional<Account> account = service.getBalance(accNo);
		if (account.isPresent()) {
			return new ResponseEntity<Account>(account.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/deposit")
	public ResponseEntity<Account> deposit(@RequestParam("accNo") Long accNo, 
			@RequestParam("amount") Long amount) {
		service.deposit(accNo, amount);
		Optional<Account> account = service.getBalance(accNo);
		if (account.isPresent()) {
			return new ResponseEntity<Account>(account.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
		}		
	}

	@PostMapping("/withdraw")
	public ResponseEntity<Account> withdraw(@RequestParam("accNo") Long accNo, 
			@RequestParam("amount") Long amount){
		int status = service.withdraw(accNo, amount);
		if (status == 1) {
			Optional<Account> account = service.getBalance(accNo);
			return new ResponseEntity<Account>(account.get(), HttpStatus.OK);
		} else if (status == 0) {
			return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Account>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

	public AccountService getService() {
		return service;
	}

	public void setService(AccountService service) {
		this.service = service;
	}

}

