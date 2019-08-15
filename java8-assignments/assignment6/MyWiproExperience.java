package assignment6;

import java.time.LocalDate;
import java.time.Period;

public class MyWiproExperience {

	public static void main(String[] args) {

		int jngYear = 2018;
		int jngMonth = 2;
		int jngDay = 15;
		MyWiproExperience myWiproExp = new MyWiproExperience();
		myWiproExp.showMyExpereince(jngYear, jngMonth, jngDay);
	}

	public void showMyExpereince(int y, int m, int d) {
		LocalDate today = LocalDate.now();
		Period period = Period.between(LocalDate.of(y, m , d), today);
		System.out.println("My Total Experience in Wipro Digital is: " 
				+period.getYears()+ " years " +period.getMonths()+ " months and " 
				+period.getDays()+ " days");
	}
}
