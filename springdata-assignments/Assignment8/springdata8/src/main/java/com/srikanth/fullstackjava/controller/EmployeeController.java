package com.srikanth.fullstackjava.controller;

import java.util.Date;
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
	private EmployeeService service;

	public EmployeeService getService() {
		return service;
	}

	public void setService(EmployeeService service) {
		this.service = service;
	}

	@PostMapping("/addEmployees")
	public @ResponseBody void addEmployees() {
		for (int i=1; i<=20; i++) {
			Employee e = new Employee(i+100L, "employee"+i, new Date(), i+50000D, "permanent");
			service.saveEmployee(e);
		}
	}

	@GetMapping("/showAllEmployees")
	public @ResponseBody List<Employee> showAllEmployees() {
		List<Employee> emps = service.getAllEmployees();
		return emps;
	}

	@GetMapping("/showEmployeeById")
	public @ResponseBody Employee showEmployeeById(@RequestParam("empId") Long empId){
		Optional<Employee> emp = service.getEmployeeById(empId);
		if (emp.isPresent()) {
			return emp.get();
		} else {
			return null;
		}
	}

	@GetMapping("/showEmployeeByName/{empName}")
	public @ResponseBody List<Employee> showEmployeeByName(@PathVariable("empName") String empName){
		List<Employee> emps = service.getEmployeesByNameLike(empName);
		return emps;
	}
}
