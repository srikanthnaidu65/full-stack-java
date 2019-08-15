package com.srikanth.fullstackjava.assignment4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NameController {

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/convertCase")
	public @ResponseBody Result convertCase(@RequestParam("userName") String userName) {
		Result result = new Result();
		if (userName != null) {
			result.setResult(userName.toUpperCase());
		} else {
			result.setResult("");
		}
		return result;
	}
}

