package assignment4;

public class Employee {

	private int id;
	private String name;
	private String address;
	private long salary;

	public Employee(int id, String name, String address, long salary) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
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

	static int compareBySal(Employee e1, Employee e2) {
		return  e1.getSalary() != e2.getSalary() ? (e1.getSalary() < e2.getSalary() ? -1 : 1) : 0;
	}
}
