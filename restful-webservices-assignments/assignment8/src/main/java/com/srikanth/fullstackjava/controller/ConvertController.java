package com.srikanth.fullstackjava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.srikanth.fullstackjava.model.Album;

@Controller
public class ConvertController {

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/convert")
	public @ResponseBody Album convert(@RequestParam("title") String title,
			@RequestParam("singer") String singer){		
		Album album = new Album();
		album.setTitle(title);
		album.setSinger(singer);
		return album;
	}

}

