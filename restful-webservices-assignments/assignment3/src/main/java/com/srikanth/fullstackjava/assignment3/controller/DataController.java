package com.srikanth.fullstackjava.assignment3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DataController {

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/getData")
	public @ResponseBody int check(@RequestParam("num") int num) {
		return num * 2;
	}
}

