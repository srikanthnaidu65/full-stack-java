package com.srikanth.fullstackjava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srikanth.fullstackjava.model.Employee;
import com.srikanth.fullstackjava.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repository;

	public Employee getEmployee(String id) {
		return repository.getOne(id);
	}

	public List<Employee> getAllEmployee() {
		return repository.findAll();
	}

	public void deleteEmployee(String id) {
		repository.deleteById(id);
	}

	public int updateEmployee(String id, String name, int salary) {
		return repository.updateEmployee(id, name, salary);
	}

	public Employee insertEmployee(String id, int salary, String name) {
		Employee emp = new Employee();
		emp.setEmpId(id);
		emp.setEmpName(name);
		emp.setEmpSalary(salary);
		return repository.save(emp);
	}

	public EmployeeRepository getRepository() {
		return repository;
	}

	public void setRepository(EmployeeRepository repository) {
		this.repository = repository;
	}

}
