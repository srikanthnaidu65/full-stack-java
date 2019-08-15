package com.srikanth.fullstackjava.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srikanth.fullstackjava.model.Employee;
import com.srikanth.fullstackjava.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repository;

	public Optional<Employee> getEmployee(String id) {
		return repository.findById(id);
	}

	public List<Employee> getAllEmployee() {
		return repository.findAll();
	}

	public Employee insertEmployee(String id, String name, 
			String email, String location) {
		Employee emp = new Employee();
		emp.setEmpId(id);
		emp.setEmpName(name);
		emp.setEmail(email);
		emp.setLocation(location);
		return repository.save(emp);
	}

	public EmployeeRepository getRepository() {
		return repository;
	}

	public void setRepository(EmployeeRepository repository) {
		this.repository = repository;
	}

}
