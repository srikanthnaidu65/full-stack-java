package com.srikanth.fullstackjava.assignment1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BankController {

	@GetMapping("/bankName")
	public @ResponseBody String bankName() {
		return "Bank Name: HDFC Bank";
	}

	@GetMapping("/bankAddress")
	public @ResponseBody String bankAddress() {
		return "Bank Address: Survey No: 183/3, Dommasandra, "
				+ "Anekal Taluk, Sarjapura Road, Bengaluru, Karnataka 562125";
	}

}
