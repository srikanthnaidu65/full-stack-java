package com.srikanth.fullstackjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srikanth.fullstackjava.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

	@Transactional
	@Modifying
	@Query("UPDATE Employee e SET e.empSalary = :salary, e.empName = :name WHERE e.empId = :id")
	int updateEmployee(@Param("id") String id, @Param("name") String name, @Param("salary") Integer salary);
}
