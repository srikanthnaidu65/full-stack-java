package com.srikanth.fullstackjava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.srikanth.fullstackjava.model.Employee;
import com.srikanth.fullstackjava.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	public EmployeeService getService() {
		return service;
	}

	public void setService(EmployeeService service) {
		this.service = service;
	}
	
	@GetMapping("/showEmployeeCount")
	public @ResponseBody Long getEmployeeCount() {
		Long count = service.getEmployeeCount();
		return count;
	}

	@GetMapping("/showAllEmployees")
	public @ResponseBody List<Employee> showAllEmployees() {
		List<Employee> emps = service.getAllEmployees();
		return emps;
	}
	
	@GetMapping("/showEmployeeByType")
	public @ResponseBody List<Employee> getEmployeeByType(@RequestParam("empType") String empType){
		List<Employee> emps = service.getEmployeesByType(empType);
		return emps;
	}

	@GetMapping("/showEmployeeByName/nameLike/{filter}")
	public @ResponseBody List<Employee> getEmployeeByNameFilter(@PathVariable("filter") String filter){
		List<Employee> emps = service.getEmployeesByNameLike(filter);
		return emps;
	}
}
