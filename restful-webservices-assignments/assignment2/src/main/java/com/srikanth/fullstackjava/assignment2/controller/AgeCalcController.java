package com.srikanth.fullstackjava.assignment2.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AgeCalcController {
	
	@GetMapping("/")
	public String homePage() {
		return "home";
	}
	
	@GetMapping("/calculateAge")
	public @ResponseBody String validateCreditCard(@RequestParam("dob") String dob) {
		DateFormat dateFormat = null;
		Date birthDate = null;
		Date currentDate = null;
		LocalDate date1 = null;
		LocalDate date2 = null;
		try {
			dateFormat = new SimpleDateFormat("dd/MM/YYYY");
			birthDate = dateFormat.parse(dob);
			currentDate = new Date();
			date1 = birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			date2 = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if ((date1 != null) && (date2 != null)) {
            return "Age is: " + Period.between(date1, date2).getYears();
        } else {
            return "Cannot calculate age!";
        }
	}

}
