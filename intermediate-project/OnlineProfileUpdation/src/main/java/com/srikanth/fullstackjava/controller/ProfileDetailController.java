package com.srikanth.fullstackjava.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.srikanth.fullstackjava.entity.JobDetails;
import com.srikanth.fullstackjava.entity.ProfileDetails;
import com.srikanth.fullstackjava.service.ProfileService;

/**
 * Controller class for profile details.
 *
 * @author  Srikanth Sambirli
 * @version 2.0
 * @since   2018-06-05
 */
@Controller
public class ProfileDetailController implements ErrorController {

	private static final String errorPath = "/errors";

	@Autowired
	private ProfileService profileService;

	@RequestMapping("/employee/addProfile")
	public String addProfile(HttpSession session, Model model) {
		if(session.getAttribute("user")!=null) {
			return "addProfile";
		} else {
			model.addAttribute("secureMsg","Please login first to continue!");
			return "login";
		}
	}

	@RequestMapping(value = "/employee/saveProfile", method = RequestMethod.POST)
	public String saveEmployeeProfile(@ModelAttribute("profile") ProfileDetails profile, 
			HttpSession session, Model model) {
		ProfileDetails profileDetails = null;
		profile.setUserId(session.getAttribute("user").toString());
		profileDetails = profileService.saveProfile(profile);
		if(profileDetails != null) {
			model.addAttribute("msg", "Your Profile has been saved successfully!");
			model.addAttribute("profMsg", "Your Profile Id is "+profileDetails.getProfileId()+ ". Please note it for future reference.");
		} else {
			model.addAttribute("msg", "Your Profile has not been saved!");
		}
		return "employeeHome";
	}

	@RequestMapping("/employee/modifyProfile")
	public String modifyProfileDetails(HttpServletRequest req,
			HttpSession session, Model model) {
		if(session.getAttribute("user")!=null) {
			return "findProfile";
		} else {
			model.addAttribute("secureMsg","Please login first!");
			return "login";	
		}
	}

	@RequestMapping("/employee/getProfile")
	public String getProfile(@RequestParam("profileId") Integer profileId, 
			HttpServletRequest req,
			HttpSession session, Model model) {

		if(session.getAttribute("user") != null) {
			Optional<ProfileDetails> profileDetails = profileService.getProfileByIdAndUserId(
					profileId, session.getAttribute("user").toString());
			if (profileDetails.isPresent()) {
				model.addAttribute("profile", profileDetails.get());
				return "modifyProfile";
			} else {
				model.addAttribute("errMsg", "Profile details not found!");
				return "findProfile";
			}
		} else {
			model.addAttribute("secureMsg", "Please login first to continue!");
			return "login";
		}
	}

	@RequestMapping(value= "/employee/updateProfile", method = RequestMethod.POST)
	public String updateProfileDetails(@ModelAttribute("profile") ProfileDetails profile,
			HttpSession session, Model model) {

		ProfileDetails profileDetails = null;
		profile.setUserId(session.getAttribute("user").toString());
		profileDetails = profileService.modifyProfile(profile);

		if(profileDetails != null) {
			model.addAttribute("succMsg", "Profile Updated Successfully!");
		} else {
			model.addAttribute("errMsg", "Profile is not updated.");
		}
		return "findProfile";
	}

	@RequestMapping("/employee/deleteProfile")
	public String deleteProfile(HttpServletRequest req,
			HttpSession session, Model model) {

		if(session.getAttribute("user") != null) {
			return "deleteProfile";
		} else {
			model.addAttribute("secureMsg", "Please login first to continue!");
			return "login";	
		}
	}

	@RequestMapping("/employee/deleteProfileDetails")
	public String deleteEmployeeProfile(@RequestParam("profileId") Integer profileId,
			HttpSession session, Model model) {
		Optional<ProfileDetails> profileDetails = profileService.getProfileByIdAndUserId(
				profileId, session.getAttribute("user").toString());
		if (profileDetails.isPresent()) {
			profileService.deleteProfile(profileId);
			model.addAttribute("succMsg", "Profile has been deleted Successfully!");
		} else {
			model.addAttribute("errMsg", "Profile details not found!");		
		}
		return "deleteProfile";
	}

	@RequestMapping("/employee/profileUpload")
	public String uploadProfille(HttpSession session, Model model) {

		if(session.getAttribute("user") != null) {
			return "profileUpload";
		} else {
			model.addAttribute("secureMsg", "Please login first to continue!");
			return "login";	
		}
	}

	@RequestMapping(value = "/employee/upload", method = RequestMethod.POST)
	public String uploadProfile(@RequestParam("profileId") Integer profileId, 
			@RequestParam MultipartFile file,
			HttpSession session, Model model) throws IOException {

		Optional<ProfileDetails> profileDetails = profileService.getProfileByIdAndUserId(
				profileId, session.getAttribute("user").toString());
		ProfileDetails profile = null;
		if (profileDetails.isPresent()) {
			profile = profileDetails.get();
			String fileName = null;
			if (!file.isEmpty()) {
				fileName = file.getOriginalFilename();
				BufferedOutputStream stream = null;
				try {
					String user = session.getAttribute("user").toString();
					byte[] bytes = file.getBytes();

					File dir = new File("profiles" + File.separator + user);
					if (!dir.exists()) {
						dir.mkdirs();
					}
					String filePath = dir.getAbsolutePath()	+ File.separator + fileName;
					File serverFile = new File(filePath);
					stream = new BufferedOutputStream(
							new FileOutputStream(serverFile));
					stream.write(bytes);
					profile.setProfileSavedLoc(filePath);
					profileService.saveProfile(profile);
					model.addAttribute("succMsg", "File " +fileName+ " uploaded successfully.");
				} catch (Exception e) {
					model.addAttribute("errMsg", "Failed to upload file " + fileName);
				} finally {
					stream.close();
				}
			} else {
				model.addAttribute("errMsg", "Failed to upload file " + fileName
						+ " because the file was empty.");
			}
		} else {
			model.addAttribute("errMsg", "Profile Id not found!");
		}
		return "profileUpload";
	}

	@RequestMapping("/employee/searchJob")
	public String viewEmployeeProfile(HttpSession session, Model model) {
		if(session.getAttribute("user") != null) {
			return "showJobs";
		} else {
			model.addAttribute("secureMsg", "Please login first to continue!");
			return "login";	
		}
	}

	@RequestMapping("/employee/showJobsBySkill")
	public String searchProfileBySkill(@RequestParam("skill") String skill, Model model) {
		String  returnPage = "errors";
		List<JobDetails> jobs = null;
		jobs = profileService.showJobsBySkill(skill);
		if(jobs == null || jobs.isEmpty()) {
			model.addAttribute("errMsg", "Sorry! No Jobs Found!");
			returnPage = "showJobs";
		} else {
			model.addAttribute("succMsg", "Search Results for Skill: " +skill);
			model.addAttribute("jobs", jobs);
			returnPage = "showJobs";
		}
		return returnPage;
	}

	@RequestMapping("/employee/showJobsByLocation")
	public String searchProfileByLocation(@RequestParam("location") String location, Model model) {

		String  returnPage = "errors";
		List<JobDetails> jobs = null;
		jobs = profileService.showJobsByLocation(location);
		if(jobs == null || jobs.isEmpty()) {
			model.addAttribute("errMsg", "Sorry! No Jobs Found!");
			returnPage = "showJobs";
		} else {
			model.addAttribute("succMsg", "Search Results for Location: " +location);
			model.addAttribute("jobs", jobs);
			returnPage = "showJobs";
		}
		return returnPage;
	}

	@RequestMapping("/employee/showJobsByExperience")
	public String searchProfileByExperience(@RequestParam("experience") Integer experience, Model model) {
		String  returnPage = "errors";
		List<JobDetails> jobs = null;
		jobs = profileService.showJobsByExperience(experience);
		if(jobs == null || jobs.isEmpty()) {
			model.addAttribute("errMsg", "Sorry! No Jobs Found!");
			returnPage = "showJobs";
		} else {
			model.addAttribute("succMsg", "Search Results for Experience: " +experience);
			model.addAttribute("jobs", jobs);
			returnPage = "showJobs";
		}
		return returnPage;
	}

	public String getErrorPath() {
		return errorPath;
	}

}
