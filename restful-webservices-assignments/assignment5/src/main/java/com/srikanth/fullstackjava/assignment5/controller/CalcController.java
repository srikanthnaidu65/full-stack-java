package com.srikanth.fullstackjava.assignment5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CalcController {

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/add")
	public @ResponseBody int add(@RequestParam("num1") int num1, 
			@RequestParam("num2") int num2) {
		return num1 + num2;
	}
	
	@GetMapping("/subtract")
	public @ResponseBody int subtract(@RequestParam("num1") int num1, 
			@RequestParam("num2") int num2) {
		return num1 - num2;
	}
}

