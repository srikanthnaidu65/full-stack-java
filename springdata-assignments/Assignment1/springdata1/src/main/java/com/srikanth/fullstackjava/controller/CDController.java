package com.srikanth.fullstackjava.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/showAllCDs")
	public @ResponseBody List<CD> showAllCDs() {
		List<CD> cds = service.getAllCDs();
		return cds;
	}

	@GetMapping("/showCDById/{cdId}")
	public @ResponseBody CD showCDById(@PathVariable("cdId") Long cdId) {
		Optional<CD> cd = service.getCDById(cdId);
		if (cd.isPresent()) {
			return cd.get();
		} else {
			return null;
		}
	}

	@GetMapping("/showCDByTitle/{cdTitle}")
	public @ResponseBody List<CD> showCDByTitle(@PathVariable("cdTitle") String cdTitle) {
		List<CD> cds = service.getCDByTitle(cdTitle);
		return cds;
	}

	@GetMapping("/showCDByPublisher/{cdPublisher}")
	public @ResponseBody List<CD> showCDByPublisher(@PathVariable("cdPublisher") String cdPublisher) {
		List<CD> cds = service.getCDByPublisher(cdPublisher);
		return cds;
	}

}
