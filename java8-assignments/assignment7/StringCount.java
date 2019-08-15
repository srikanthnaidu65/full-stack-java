package assignment7;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCount {

	public static void main(String []args){
		List<String> list = new ArrayList<String>();
		list.add("Srikanth");
		list.add("Hemanth");
		list.add("Irfan");
		list.add("Charan");
		list.add("Giri");
		list.add("");
		list.add(null);
		list.add("");
		list.add("");

		System.out.println("Number of strings in list : " +list.size());

		Stream<String> nonEmptyStrings = list.stream().filter(s -> s != null 
				&& s.trim().length() > 5);
		System.out.println("Number of strings whose length greater than 5: " +nonEmptyStrings.count());

		Stream<String> emptyStrings = list.stream().filter(c -> c != null).
				filter( s -> s.trim().length() == 0);
		System.out.println("Number of empty strings: " +emptyStrings.count());

		List<String> anotherList = list.stream().filter(s -> s != null && s.trim().length() == 0).
				collect(Collectors.toList());
		System.out.println("Empty Strings: "+anotherList);
	}
}
