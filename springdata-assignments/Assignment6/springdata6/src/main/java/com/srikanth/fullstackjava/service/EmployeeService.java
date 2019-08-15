package com.srikanth.fullstackjava.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Modifying;
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

	@Transactional(readOnly = true, timeout = 50)
	public Optional<Employee> getEmployeeById(Long empId) {
		return repository.findById(empId);
	}

	@Transactional(readOnly = true)
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}

	@Transactional(readOnly = true, timeout = 50)
	public List<Employee> getEmployeeByDoj(Date empDoj) {
		return repository.findByEmpDoj(empDoj);
	}

	@Transactional(readOnly = true, timeout = 50)
	public List<Employee> getEmployeeByName(String filter) {
		return repository.findByEmpNameIgnoreCase(filter);
	}

	@Transactional(readOnly = true, timeout = 50)
	public List<Employee> getEmployeeByNameFilter(Employee filter) {
		List<Employee> employees = repository.findAll(new Specification<Employee>() {

			@Override
			public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<Predicate>();
				if (filter.getEmpName() != null) {
					predicates.add(cb.equal(cb.lower(root.get("empName")), 
							filter.getEmpName().toLowerCase()));
				}
				return cb.and(predicates.toArray(new Predicate[0]));
			}
		});
		return employees;
	}

	@Transactional(rollbackFor = Exception.class)
	public Employee insertEmployee(Long empId, String empName, 
			Date empDoj, Double empSalary, String empType) {
		Employee emp = new Employee(empId, empName, empDoj, empSalary, empType);
		return repository.save(emp);
	}

	@Transactional(rollbackFor = Exception.class)
	public int updateEmployee(Long empId, String empName, 
			Date empDoj, Double empSalary, String empType) {
		return repository.updateEmployee(empId, empName, empDoj, empSalary, empType);
	}

	@Modifying
	public void deleteEmployee(Long empId) {
		repository.deleteById(empId);
	}

}
