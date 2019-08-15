package com.srikanth.fullstackjava.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.srikanth.fullstackjava.entity.UserLoginDetails;
import com.srikanth.fullstackjava.entity.UserProfileDetails;
import com.srikanth.fullstackjava.service.UserDetailsService;

/**
 * Controller class for user details.
 *
 * @author  Srikanth Sambirli
 * @version 1.0
 * @since   2018-06-26
 */
@Controller
public class UserDetailsController implements ErrorController {

	private static final String errorPath = "/error";

	@Autowired
	private UserDetailsService userDetailsService;

	@GetMapping("/")
	public String homePage() {
		return "login";
	}

	/**
	 * This method is used to validate the user login details
	 * 
	 * @param userId
	 * @param password
	 * @param bankName
	 * @param model
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@PostMapping("/user/login")
	public String userLogin(@RequestParam("userId") String userId,
			@RequestParam("password") String password,
			@RequestParam("bankName") String bankName,
			Model model,
			HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session) {

		UserLoginDetails userDetails=null;
		String returnPage = "error";
		userDetails = userDetailsService.login(userId, password, bankName);
		if(userDetails != null) {
			returnPage = "userHome";
			model.addAttribute("msg", "Welcome User: "+userDetails.getUserId());
			session = request.getSession();
			session.setAttribute("user", userDetails.getUserId());
			session.setAttribute("pass", userDetails.getPassword());
		} else {
			model.addAttribute("msg", "Login Failed! Invalid UserId or Password.");
			returnPage = "login";
		}
		return returnPage;
	}

	/**
	 * This method is used to get the home page of the user
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@GetMapping("/user/userHome")
	public String employeeHomePage(Model model, HttpSession session) {
		model.addAttribute("msg", "Welcome User: "+session.getAttribute("user").toString());
		return "userHome";
	}

	/**
	 * This method is used to display the user details 
	 * so that user can edit and update their details
	 * 
	 * @param req
	 * @param session
	 * @param model
	 * @return
	 */
	@GetMapping("/user/modifyProfile")
	public String getProfile(HttpServletRequest req,
			HttpSession session, Model model) {

		Object user = session.getAttribute("user");
		if(user != null) {
			Optional<UserProfileDetails> profileDetails = userDetailsService.showUserProfileDetailsById(
					user.toString());
			if (profileDetails.isPresent()) {
				model.addAttribute("profile", profileDetails.get());
				return "modifyProfile";
			} else {
				model.addAttribute("errMsg", "User profile details not found!");
				return "userHome";
			}
		} else {
			model.addAttribute("secureMsg", "Please login first to continue!");
			return "login";
		}
	}

	/**
	 * This method is used to update the user profile details
	 * 
	 * @param profile
	 * @param session
	 * @param model
	 * @return
	 */
	@PostMapping(value= "/user/updateProfile")
	public String updateProfileDetails(@ModelAttribute("profile") UserProfileDetails profile,
			HttpSession session, Model model) {

		UserProfileDetails profileDetails = null;
		profile.setUserId(session.getAttribute("user").toString());
		profileDetails = userDetailsService.modifyProfile(profile);

		if(profileDetails != null) {
			model.addAttribute("succMsg", "User Profile Updated Successfully!");
		} else {
			model.addAttribute("errMsg", "Profile is not updated.");
		}
		return "userHome";
	}

	/**
	 * This method is used to get the contact us page
	 * 
	 * @return
	 */
	@GetMapping("user/contactUs")
	public String contactUsPage() {
		return "contactUs";
	}

	/**
	 * This method is used to logged out the user
	 * from the application
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@GetMapping("/user/logout")
	public String userLogout(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		session.invalidate();
		model.addAttribute("msg", "You are logged out now!");
		return "login";
	}

	/**
	 * This method is used to handle the errors in the application
	 */
	public String getErrorPath() {
		return errorPath;
	}

}
