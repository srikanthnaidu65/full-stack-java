package com.srikanth.fullstackjava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping("getEmployee")
	public @ResponseBody Employee getEmployee(@RequestParam("id") String id){
		return service.getEmployee(id);
	}

	@GetMapping("getAllEmployee")
	public @ResponseBody List<Employee> getAllEmployee(){
		return service.getAllEmployee();
	}

	@DeleteMapping("deleteEmployee")
	public @ResponseBody List<Employee> deleteEmployee(@RequestParam("id") String id){
		service.deleteEmployee(id);
		return service.getAllEmployee();
	}

	@PostMapping("updateEmployee")
	public @ResponseBody List<Employee> updateEmployee(@RequestParam("id") String id, 
			@RequestParam("name") String name, @RequestParam("salary") int salary){
		service.updateEmployee(id, name, salary);
		return service.getAllEmployee();

	}

	@PutMapping("insertEmployee")
	public @ResponseBody List<Employee> insertEmployee(@RequestParam("id") String id,
			@RequestParam("name") String name, @RequestParam("salary") int sal){
		service.insertEmployee(id, sal, name);
		return service.getAllEmployee();
	}

	public EmployeeService getService() {
		return service;
	}

	public void setService(EmployeeService service) {
		this.service = service;
	}

}

