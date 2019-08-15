package com.srikanth.fullstackjava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BankController {

	@GetMapping("/bankBranches")
	public String bankName() {
		return "bank-branches";
	}

	@GetMapping("/bankServices")
	public String bankAddress() {
		return "bank-services";
	}

}
