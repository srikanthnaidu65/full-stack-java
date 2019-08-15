package com.srikanth.fullstackjava.data;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.srikanth.fullstackjava.model.Employee;

@Repository
public class EmployeeData {

	private	Map <String, Employee> map = new HashMap<String, Employee>();

	public EmployeeData() {
		map.put("E001", new Employee("Srikanth", "srikanth@gmail.com", "Banglore"));
		map.put("E002", new Employee("Kiran", "kiran@gmail.com", "Chittoor"));
		map.put("E003", new Employee("Rahul", "rahul@gmail.com", "Hyderabad"));
	}

	public Map<String, Employee> getMap() {
		return map;
	}

	public void setMap(Map<String, Employee> map) {
		this.map = map;
	}

	public Employee getEmployee(String id) {
		for(Map.Entry temp: map.entrySet()){  
			Employee emp = (Employee) temp.getValue();	 
			if(id.equals(temp.getKey())) {
				Employee e = new Employee(emp.getEmpName(), emp.getEmail(), emp.getLocation());
				return e;
			}
		}
		return null;
	}

	public void addEmployee(String id, String name, String email, String location) {
		map.put(id, new Employee(name, email, location));
	}

	public void deleteEmployee(String id) {
		map.remove(id);
	}

	public void updateEmployee(String id) {
		Employee e = new Employee("Mohan", "mohan@gmail.com", "delhi");
		map.put(id, e);
	}

}
