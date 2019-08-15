package com.srikanth.fullstackjava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.srikanth.fullstackjava.model.CD;
import com.srikanth.fullstackjava.service.CDService;

@Controller
public class CDController {

	@Autowired
	private CDService service;

	public CDService getService() {
		return service;
	}

	public void setService(CDService service) {
		this.service = service;
	}

	@PostMapping("/addCDs")
	public @ResponseBody List<CD> addCDs() {
		for (int i=1; i<=50; i++) {
			CD cd = new CD(i+100L, "Title"+i, i+100D, "Publisher"+i);
			service.saveCD(cd);
		}
		return service.getAllCDs();
	}

	@GetMapping("/showAllCDs")
	public @ResponseBody List<CD> showAllCDs() {
		List<CD> cds = service.getAllCDs();
		return cds;
	}

	@GetMapping("/showCDsByPublisher/{publisher}")
	public @ResponseBody List<CD> showCDsByPublisher(@PathVariable("publisher") String publisher){
		List<CD> cds = service.getCDsByPublisher(publisher);
		return cds;
	}
}
