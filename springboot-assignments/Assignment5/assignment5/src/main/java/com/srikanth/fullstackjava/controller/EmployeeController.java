package com.srikanth.fullstackjava.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.srikanth.fullstackjava.data.EmployeeData;
import com.srikanth.fullstackjava.model.Employee;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeData data;

	@GetMapping("/displayAll")
	public @ResponseBody Map<String, Employee> displayAll() {
		return data.getMap();
	}

	@GetMapping("/display/{empId}")
	public @ResponseBody Employee show(@PathVariable("empId") String empId) {
		return data.getEmployee(empId);
	}

	@PostMapping("/addEmployee")
	public @ResponseBody Map<String, Employee> addEmployee(@RequestParam("id") String id,
			@RequestParam("name") String name, @RequestParam("email") String email, 
			@RequestParam("location") String location) {   
		data.addEmployee(id, name, email, location);
		return data.getMap();
	}

	@PutMapping("/updateEmployee/{id}")
	public @ResponseBody Map<String, Employee> updateEmployee(@PathVariable("id") String id) {   
		data.updateEmployee(id);
		return data.getMap();
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public @ResponseBody Map<String, Employee> deleteEmployee(@PathVariable("id") String id) {   
		data.deleteEmployee(id);
		return data.getMap();
	}

	public EmployeeData getData() {
		return data;
	}

	public void setData(EmployeeData data) {
		this.data = data;
	}

}
