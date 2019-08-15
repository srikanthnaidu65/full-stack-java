package com.srikanth.fullstackjava.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.web.servlet.error.ErrorController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.srikanth.fullstackjava.entity.JobDetails;
import com.srikanth.fullstackjava.entity.ProfileDetails;
import com.srikanth.fullstackjava.service.JobService;
import com.srikanth.fullstackjava.service.ProfileService;

/**
 * Controller class for job details.
 *
 * @author  Srikanth Sambirli
 * @version 2.0
 * @since   2018-06-05
 */
@Controller
public class JobDetailsController implements ErrorController {

	private static final String errorPaths = "/errors";

	@Autowired
	private JobService jobService;

	@Autowired
	private ProfileService profileService;

	@RequestMapping("/admin/addJob")
	public String addJobPage(HttpServletRequest req,
			HttpSession session, Model model) {

		if(session.getAttribute("user") != null) {
			return "addJob";
		} else {
			model.addAttribute("secureMsg", "Please login first to continue!");
			return "login";
		}
	}

	@RequestMapping(value = "/admin/saveJob", method = RequestMethod.POST)
	public String addJob(@ModelAttribute("job") JobDetails job, Model model) {
		JobDetails jobDetails = null;
		jobDetails = jobService.addJob(job);

		if(jobDetails != null) {
			model.addAttribute("msg", "Job Saved Successfully!");
			model.addAttribute("jobMsg", "Job Id is "+jobDetails.getJobId()+ ". Please note it for future reference.");
		} else {
			model.addAttribute("msg", "Job is not saved.");
		}
		return "adminHome";
	}

	@RequestMapping("/admin/modifyJob")
	public String modifyJob(HttpServletRequest req,
			HttpSession session, Model model) {

		if(session.getAttribute("user")!=null) {
			return "findJob";
		} else {
			model.addAttribute("secureMsg", "Please login first to continue!");
			return "login";
		}
	}

	@RequestMapping("/admin/getJob")
	public String getJob(@RequestParam("jobId") Integer jobId, HttpServletRequest req,
			HttpSession session, Model model) {

		if(session.getAttribute("user") != null) {
			Optional<JobDetails> jobDetails = jobService.getJobById(jobId);
			if (jobDetails.isPresent()) {
				model.addAttribute("job", jobDetails.get());
				return "modifyJob";
			} else {
				model.addAttribute("errMsg", "Job details not found!");
				return "findJob";
			}
		} else {
			model.addAttribute("secureMsg", "Please login first to continue!");
			return "login";
		}
	}

	@RequestMapping(value = "/admin/updateJob", method = RequestMethod.POST)
	public String updateJob(@ModelAttribute("job") JobDetails job, Model model) {

		JobDetails jobDetails = null;	
		jobDetails = jobService.modifyJob(job);

		if(jobDetails != null) {
			model.addAttribute("succMsg", "Job has been updated Successfully!");
		} else {
			model.addAttribute("errMsg", "Job  has not been updated.");
		}
		return "findJob";
	}

	@RequestMapping("/admin/deleteJob")
	public String deleteJob(HttpServletRequest req,
			HttpSession session, Model model) {
		if(session.getAttribute("user") != null) {
			return "deleteJob";
		} else {
			model.addAttribute("secureMsg", "Please login first to continue!");
			return "login";
		}
	}

	@RequestMapping("/admin/deleteJobDetail")
	public String deleteJobDetail(@RequestParam("jobId") Integer jobId, Model model) {

		Optional<JobDetails> jobDetails = jobService.getJobById(jobId);
		if (jobDetails.isPresent()) {
			jobService.deleteJob(jobId);
			model.addAttribute("succMsg", "Job has been deleted Successfully!");
			return "deleteJob";
		} else {
			model.addAttribute("errMsg", "Job details not found!");
			return "deleteJob";
		}
	}

	@RequestMapping("/admin/downloadProfile")
	public String downloadProfilePage(HttpServletRequest req,
			HttpSession session, Model model) {
		if(session.getAttribute("user") != null) {
			return "downloadProfile";
		} else {
			model.addAttribute("secureMsg", "Please login first to continue!");
			return "login";
		}
	}

	@RequestMapping(value = "/admin/download", method = RequestMethod.POST)
	public String downloadProfile(@RequestParam("profileId") Integer profileId,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IllegalStateException {

		Optional<ProfileDetails> profileDetails = profileService.getProfileById(profileId);
		ProfileDetails profile = null;
		if (profileDetails.isPresent()) {

			profile = profileDetails.get();
			String path = profile.getProfileSavedLoc();

			if (path != null && !"".equals(path)) {
				Path file = Paths.get(path);

				if(Files.exists(file)) {
					File downloadFile = new File(path);
					FileInputStream inputStream = null;
					OutputStream outStream = null;
					try {
						inputStream = new FileInputStream(downloadFile);

						response.setContentType("application/octet-stream");
						response.setHeader("Content-Disposition", "attachment;fileName=\""+downloadFile.getName()+"\"");

						outStream = response.getOutputStream();

						byte[] buffer = new byte[4096];
						int bytesRead = -1;

						while ((bytesRead = inputStream.read(buffer)) != -1) {
							outStream.write(buffer, 0, bytesRead);
						}
						outStream.flush();
						model.addAttribute("succMsg", "File has been Downloaded!");
					} catch(Exception e) {
						model.addAttribute("errMsg", "Download failed!");
					} finally {
						try {
							inputStream.close();
						} catch (IOException e) {
						}
						try {
							outStream.close();
						} catch (IOException e) {
						}
					}
				} else {
					model.addAttribute("errMsg", "Profile not found!");
				}
			} else {
				model.addAttribute("errMsg", "Sorry! User with profile Id "+profileId+" has not uploaded resume.");
			}
		} else {
			model.addAttribute("errMsg", "Profile Id not found!");
		}
		return "downloadProfile";
	}

	@RequestMapping("/admin/showProfile")
	public String viewProfie(HttpServletRequest req,
			HttpSession session,
			Model model) {

		if(session.getAttribute("user") != null) {
			return "showProfile";
		} else {
			model.addAttribute("secureMsg", "Please login first to continue!");
			return "login";
		}
	}

	@RequestMapping("/admin/showProfilesByName")
	public String searchProfileByName(@RequestParam("firstName") String firstName, Model model) {
		String  returnPage = "errors";
		List<ProfileDetails> profiles = null;
		profiles = jobService.showProfilesByName(firstName);
		if(profiles == null || profiles.isEmpty()) {
			model.addAttribute("errMsg", "Sorry! No Profiles Found!");
			returnPage = "showProfile";
		} else {
			model.addAttribute("succMsg", "Search Results for Name: " +firstName);
			model.addAttribute("profiles", profiles);
			returnPage = "showProfile";
		}
		return returnPage;
	}

	@RequestMapping("/admin/showProfilesBySkill")
	public String searchProfileBySkill(@RequestParam("skill") String skill, Model model) {
		String  returnPage = "errors";
		List<ProfileDetails> profiles = null;
		profiles = jobService.showProfilesBySkill(skill);
		if(profiles == null || profiles.isEmpty()) {
			model.addAttribute("errMsg", "Sorry! No Profiles Found!");
			returnPage = "showProfile";
		} else {
			model.addAttribute("succMsg", "Search Results for Skill: " +skill);
			model.addAttribute("profiles", profiles);
			returnPage = "showProfile";
		}
		return returnPage;
	}

	@RequestMapping("/admin/showProfilesByLocation")
	public String searchProfileByLocation(@RequestParam("location") String location,
			Model model) {
		String  returnPage = "errors";
		List<ProfileDetails> profiles = null;
		profiles = jobService.showProfilesByLocation(location);
		if(profiles == null || profiles.isEmpty()) {
			model.addAttribute("errMsg", "Sorry! No Profiles Found!");
			returnPage = "showProfile";
		} else {
			model.addAttribute("succMsg", "Search Results for Location: " +location);
			model.addAttribute("profiles", profiles);
			returnPage = "showProfile";
		}
		return returnPage;
	}

	@RequestMapping("/admin/showProfilesByExpereince")
	public String searchProfileByExpereince(@RequestParam("expereince") Integer expereince,
			Model model) {
		String  returnPage = "errors";
		List<ProfileDetails> profiles = null;
		profiles = jobService.showProfilesByExperience(expereince);
		if(profiles == null || profiles.isEmpty()) {
			model.addAttribute("errMsg", "Sorry! No Profiles Found!");
			returnPage = "showProfile";
		} else {
			model.addAttribute("succMsg", "Search Results for Expereince: " +expereince);
			model.addAttribute("profiles", profiles);
			returnPage = "showProfile";
		}
		return returnPage;
	}

	public String getErrorPath() {
		return errorPaths;
	}

}
