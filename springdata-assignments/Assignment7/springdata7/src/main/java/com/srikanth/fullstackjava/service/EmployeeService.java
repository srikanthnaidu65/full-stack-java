package com.srikanth.fullstackjava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.srikanth.fullstackjava.model.Employee;
import com.srikanth.fullstackjava.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	public EmployeeRepository getRepository() {
		return repository;
	}

	public void setRepository(EmployeeRepository repository) {
		this.repository = repository;
	}

	@Transactional(readOnly = true)
	public Long getEmployeeCount() {
		return repository.count();
	}

	@Transactional(readOnly = true)
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}

	@Transactional(readOnly = true)
	public List<Employee> getEmployeesByNameLike(String filterName) {
		Employee empfilterBy = new Employee();
		empfilterBy.setEmpName(filterName);
		ExampleMatcher matcher = ExampleMatcher.matching()
				.withStringMatcher(StringMatcher.CONTAINING)
				.withIgnoreCase();
		Example<Employee> example = Example.of(empfilterBy, matcher); 

		return repository.findAll(example);
	}

	@Transactional(readOnly = true)
	public List<Employee> getEmployeesByType(String empType) {
		Employee empfilterBy = new Employee();
		empfilterBy.setEmpType(empType);
		ExampleMatcher matcher = ExampleMatcher.matching()     
				.withIgnoreNullValues()
				.withStringMatcher(StringMatcher.EXACT)
				.withIgnoreCase();
		Example<Employee> example = Example.of(empfilterBy, matcher);
		return repository.findAll(example);
	}
}
