package com.srikanth.fullstackjava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@GetMapping("/health")
	public @ResponseBody String health() {
		long time = System.currentTimeMillis();
		if (time % 2 == 0) {
			return "Health Status: UP";
		} else {
			return "Health Status: DOWN";
		}
	}

}
