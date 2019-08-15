package com.srikanth.fullstackjava.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.srikanth.fullstackjava.model.Employee;
import com.srikanth.fullstackjava.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/display/{empId}")
	public @ResponseBody Employee getEmployee(@PathVariable("empId") String empId){
		Optional<Employee> employee = service.getEmployee(empId);
		if (employee.isPresent()) {
			return employee.get();
		} else {
			return null;
		}
	}

	@GetMapping("/displayAll")
	public @ResponseBody List<Employee> getAllEmployee(){
		return service.getAllEmployee();
	}

	@PostMapping("/insertEmployee")
	public @ResponseBody Employee insertEmployee(@RequestParam("empId") String empId,
			@RequestParam("empName") String empName, @RequestParam("email") String email,
			@RequestParam("location") String location){
		return service.insertEmployee(empId, empName, email, location);
	}

	public EmployeeService getService() {
		return service;
	}

	public void setService(EmployeeService service) {
		this.service = service;
	}

}
