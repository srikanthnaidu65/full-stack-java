package com.srikanth.fullstackjava.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.srikanth.fullstackjava.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {
	
	List<Employee> findByEmpDoj(Date empDoj);
	
	List<Employee> findByEmpNameIgnoreCase(String empName);

	@Modifying
	@Query("UPDATE Employee e SET e.empName = ?2, e.empDoj = ?3, e.empSalary = ?4, "
			+ "e.empType = ?5 WHERE e.empId = ?1")
	int updateEmployee(Long empId, String empName, Date empDoj, Double empSalary, String empType);
}
