package assignment5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class DateFinder {

	public static void main(String[] args) {

		LocalDate today = LocalDate.now();
		LocalDate nextMonth = today.plusMonths(1);
		System.out.println("The date of next month's second Sunday: " 
				+nextMonth.with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.SUNDAY)));
	}
}
