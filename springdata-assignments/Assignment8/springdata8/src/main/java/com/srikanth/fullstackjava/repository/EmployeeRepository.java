package com.srikanth.fullstackjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.srikanth.fullstackjava.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>, 
			QuerydslPredicateExecutor<Employee> {
	
}
