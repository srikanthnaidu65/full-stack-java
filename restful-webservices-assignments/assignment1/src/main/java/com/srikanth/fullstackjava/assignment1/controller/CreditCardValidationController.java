package com.srikanth.fullstackjava.assignment1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditCardValidationController {

	@GetMapping("/creditCardCheck")
	public @ResponseBody String validateCreditCard(@RequestParam("creditCardNo") int creditCardNo) {
		if((creditCardNo % 2) == 0) {
			return "True: Valid Credit Card";
		} else {
			return "False: Invalid Credit Card";
		}
	}
}
