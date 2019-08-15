package com.srikanth.fullstackjava.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.srikanth.fullstackjava.entity.UserDetails;
import com.srikanth.fullstackjava.service.UserService;

/**
 * Controller class for user details.
 *
 * @author  Srikanth Sambirli
 * @version 2.0
 * @since   2018-06-05
 */
@Controller
public class UserDetailsController implements ErrorController {

	private static final String errorPath = "/error";

	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String homePage() {
		return "login";
	}

	@RequestMapping("/employee/employeeHome")
	public String employeeHomePage(Model model, HttpSession session) {
		model.addAttribute("msg", "Welcome Employee: "+session.getAttribute("user").toString());
		return "employeeHome";
	}

	@RequestMapping("/admin/adminHome")
	public String adminHomePage(Model model, HttpSession session) {
		model.addAttribute("msg", "Welcome Admin: "+session.getAttribute("user").toString());
		return "adminHome";
	}

	@RequestMapping("/user/signup")
	public String signUpPage() {
		return "signup";
	}

	@RequestMapping(value = "/user/saveUserDetails", method = RequestMethod.POST)
	public String signUp(@ModelAttribute("user") UserDetails user) {
		String result = null;
		UserDetails userDetails = null;
		userDetails = userService.signUp(user);
		if(userDetails != null) {
			result = "success";
		} else {
			result = "signup";
		}
		return result;
	}

	@PostMapping("/user/login")
	public String userLogin(@ModelAttribute("user") UserDetails user,
			Model model,
			HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session) {

		UserDetails userDetails=null;
		String returnPage = "error";
		userDetails = userService.login(user.getUserId(), user.getPassword());
		if(userDetails!=null && userDetails.getPassword().equals(user.getPassword())
				&& userDetails.getUserType().equalsIgnoreCase("admin")) {
			returnPage = "adminHome";
			model.addAttribute("msg", "Welcome Admin: "+userDetails.getUserId());

			session=request.getSession();
			session.setAttribute("user", userDetails.getUserId());
			session.setAttribute("pass", userDetails.getPassword());
		} else if(userDetails!=null && userDetails.getPassword().equals(user.getPassword()) 
				&& userDetails.getUserType().equalsIgnoreCase("employee")) {
			returnPage = "employeeHome";
			model.addAttribute("msg", "Welcome Employee: "+userDetails.getUserId());

			session=request.getSession();
			session.setAttribute("user", userDetails.getUserId());
			session.setAttribute("pass", userDetails.getPassword()); 
		} else {
			model.addAttribute("msg", "Login Failed! Invalid UserId or Password.");
			returnPage = "login";
		}
		return returnPage;
	}

	@RequestMapping("/user/logout")
	public String userLogout(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		session.invalidate();
		model.addAttribute("msg", "You are logged out now!");
		return "login";
	}

	public String getErrorPath() {
		return errorPath;
	}

}
