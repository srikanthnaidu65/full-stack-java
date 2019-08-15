public class Manager {

	private String mid;
	private String mname;

	public Manager(String mid, String mname) {
		this.mid = mid;
		this.mname = mname;
	}

	public void printManager() {
		System.out.println("Manager Id: " +mid+ ", Manager Name: " +mname);
	}
}
