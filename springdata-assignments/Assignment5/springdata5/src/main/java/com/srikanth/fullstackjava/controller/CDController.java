package com.srikanth.fullstackjava.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@DeleteMapping("/deleteCD")
	public @ResponseBody void deleteCD(@RequestParam("cdId") Long cdId){
		service.deleteCD(cdId);
	}

	@PutMapping("/updateCD")
	public @ResponseBody int updateCD(@RequestParam("cdId") Long cdId,
			@RequestParam("cdTitle") String cdTitle, @RequestParam("cdPrice") Double cdPrice,
			@RequestParam("cdPublisher") String cdPublisher){
		int status = service.updateCD(cdId, cdTitle, cdPrice, cdPublisher);
		return status;
	}

	@PostMapping("/insertCD")
	public @ResponseBody CD insertCD(@RequestParam("cdId") Long cdId,
			@RequestParam("cdTitle") String cdTitle, @RequestParam("cdPrice") Double cdPrice,
			@RequestParam("cdPublisher") String cdPublisher){
		CD cd = service.insertCD(cdId, cdTitle, cdPrice, cdPublisher);
		return cd;
	}

	@GetMapping("/findByPriceRange")
	public @ResponseBody List<CD> findByPriceRange(@RequestParam("startPrice") Double startPrice, 
			@RequestParam("endPrice") Double endPrice) {
		return service.findByPriceRange(startPrice, endPrice);
	}

	@GetMapping("/findByPriceRangeNamedParams")
	public @ResponseBody List<CD> findByPriceRangeNamedParams(
			@RequestParam("startPrice") Double startPrice, 
			@RequestParam("endPrice") Double endPrice) {
		return service.findByPriceRangeNamedParams(startPrice, endPrice);
	}

	@GetMapping("/findByTitleMatch")
	public @ResponseBody List<CD> findByTitleMatch(@RequestParam("title") String title) {
		return service.findByTitleMatch(title);
	}

	@GetMapping("/findByTitleMatchNative")
	public @ResponseBody List<CD> findByTitleMatchNative(@RequestParam("title") String title) {
		return service.findByTitleMatchNative(title);
	}

	@GetMapping("/findAllSorted")
	public @ResponseBody List<CD> findAllSorted() {
		return service.findAllSorted();
	}
	
	@GetMapping("/findByCdPrice")
	public @ResponseBody List<CD> findByCdPrice(@RequestParam("price") Double price) {
		return service.findByCdPrice(price);
	}

	@GetMapping("/countByCdPrice")
	public @ResponseBody int countByCdPrice(@RequestParam("price") Double price) {
		return service.countByCdprice(price);
	}
}
