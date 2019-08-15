package assignment1;

public class Employee {

	private int id;
	private String name;
	private String address;
	private double salary;

	public Employee(int id, String name, String address, double salary) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public double getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [Id=");
		builder.append(id);
		builder.append(", Name=");
		builder.append(name);
		builder.append(", Address=");
		builder.append(address);
		builder.append(", Salary=");
		builder.append(salary);
		builder.append("]");
		return builder.toString();
	}
}