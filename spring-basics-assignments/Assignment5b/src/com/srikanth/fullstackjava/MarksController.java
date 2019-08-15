package com.srikanth.fullstackjava;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/marks")
public class MarksController {
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView marks() {
		return new ModelAndView("marks", "command", new Marks());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView calculateSum(@ModelAttribute("SpringWeb") Marks marks, ModelMap model) {
		marks.setTotal(marks.getEnglish() + marks.getScience() + marks.getMaths());
		return new ModelAndView("marks", "command", marks);
	}
}
