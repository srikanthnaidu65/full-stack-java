package assignment1;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMain {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<Employee>();
		EmployeeMain empMain = new EmployeeMain();       
		empMain.populateEmployees(employees);
		empMain.showEmployees(employees);
	}

	public void populateEmployees(List<Employee> employees) {

		employees.add(new Employee(100, "Srikanth", "Bangalore", 70000));
		employees.add(new Employee(101, "Mohan", "Hyderabad", 25000));
		employees.add(new Employee(102, "Kiran", "Vizag", 30000));
		employees.add(new Employee(103, "Raju", "Chennai", 50000));
		employees.add(new Employee(104, "Balu", "Kolkata", 80000));
	}

	public void showEmployees(List<Employee> employees) {
		employees.forEach(emp -> System.out.println(emp));
	}
}