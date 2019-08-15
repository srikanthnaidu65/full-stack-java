public class Employee {

	public static void main(String[] args) {
		System.out.println("Hello Employee");
		Account a = new Account(43678L, 10000L);
		a.printAccount();
		Manager m = new Manager("M001", "Srikanth");
		m.printManager();
	}
}
