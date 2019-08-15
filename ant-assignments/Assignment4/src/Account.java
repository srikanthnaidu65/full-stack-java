public class Account {
	
	private Long accNo;
	private Long accBalance;
	
	public Account(Long accNo, Long accBalance) {
		this.accNo = accNo;
		this.accBalance = accBalance;
	}
	
	public void printAccount() {
		System.out.println("accNo: " +accNo+ ", AccBalance: " +accBalance);
	}
}
