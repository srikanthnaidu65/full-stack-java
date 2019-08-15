package com.srikanth.fullstackjava.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping("/showAllEmployees")
	public @ResponseBody List<Employee> showAllEmployees() {
		List<Employee> emps = service.getAllEmployees();
		return emps;
	}

	@GetMapping("/showEmployeeById/{empId}")
	public @ResponseBody Employee showEmployeeById(@PathVariable("empId") Long empId) {
		Optional<Employee> emp = service.getEmployeeById(empId);
		if (emp.isPresent()) {
			return emp.get();
		} else {
			return null;
		}
	}

	@GetMapping("/showEmployeeByDoj")
	public @ResponseBody List<Employee> showEmployeeByDoj(@RequestParam("empDoj") String empDoj) {
		List<Employee> emps = service.getEmployeeByDoj(getEmpDoj(empDoj));
		return emps;
	}

	@GetMapping("/showEmployeeByName/{empName}")
	public @ResponseBody List<Employee> showEmployeeByName(@PathVariable("empName") String empName) {
		List<Employee> emps = service.getEmployeeByName(empName);
		return emps;
	}
	
	@GetMapping("/showEmployeeByNameFilter/{empName}")
	public @ResponseBody List<Employee> showEmployeeByNameFilter(@PathVariable("empName") String empName) {
		Employee emp = new Employee();
		emp.setEmpName(empName);
		List<Employee> emps = service.getEmployeeByNameFilter(emp);
		return emps;
	}

	@DeleteMapping("/deleteEmployee")
	public @ResponseBody String deleteEmployee(@RequestParam("empId") Long empId){
		service.deleteEmployee(empId);
		return "Employee with id: " +empId+ " is Deleted!";
	}

	@PutMapping("/updateEmployee")
	public @ResponseBody String updateEmployee(@RequestParam("empId") Long empId,
			@RequestParam("empName") String empName, @RequestParam("empDoj") String empDoj,
			@RequestParam("empSalary") Double empSalary, @RequestParam("empType") String empType) {
		int status = service.updateEmployee(empId, empName, getEmpDoj(empDoj), empSalary, empType);
		if (status > 0) {
			return "Employee with id: " +empId+ " is Updated!";
		} else {
			return "Employee with id: " +empId+ " not found!";
		}
	}

	@PostMapping("/insertEmployee")
	public @ResponseBody Employee insertEmployee(@RequestParam("empId") Long empId,
			@RequestParam("empName") String empName, @RequestParam("empDoj") String empDoj,
			@RequestParam("empSalary") Double empSalary, @RequestParam("empType") String empType){
		Employee emp = service.insertEmployee(empId, empName, getEmpDoj(empDoj), empSalary, empType);
		return emp;
	}

	private Date getEmpDoj(String empDoj) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		Date doj = null;
		try {
			doj = df.parse(empDoj);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return doj;
	}
}
