package com.srikanth.fullstackjava.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.core.types.dsl.StringExpression;
import com.srikanth.fullstackjava.model.Employee;
import com.srikanth.fullstackjava.model.QEmployee;
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

	@Transactional(rollbackFor = Exception.class)
	public Employee saveEmployee(Employee emp){
		Employee employee = repository.save(emp);
		return employee;
	}

	@Transactional(readOnly = true)
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}

	@Transactional(readOnly = true)
	public List<Employee> getEmployeesByNameLike(String empName) {
		List<Employee> empList = new ArrayList<Employee>();
		QEmployee employee = QEmployee.employee;
		StringExpression se = employee.empName;
		BooleanExpression be = se.containsIgnoreCase(empName);
		Iterable<Employee> emps = repository.findAll(be);
		emps.forEach(empList::add);
		return empList;
	}

	@Transactional(readOnly = true)
	public Optional<Employee> getEmployeeById(Long empId) {
		QEmployee qEmployee = QEmployee.employee;
		NumberExpression<Long> qEmpId = qEmployee.empId;
		BooleanExpression be = qEmpId.eq(empId);
		Optional<Employee> emp = repository.findOne(be);
		return emp;
	}
}
