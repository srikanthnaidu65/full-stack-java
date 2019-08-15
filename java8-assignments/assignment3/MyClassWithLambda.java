package assignment3;

public class MyClassWithLambda {

	public static void main(String[] args) {
		String line = "Hello Srikanth! Welcome to Java8 Assignments in Topgear.";
		WordCount wordCount = (String sentence) -> {
			if (sentence == null) {
				return 0;
			} else {
				return sentence.split(" ").length;
			}
		};
		System.out.println("Number of Words  = " +wordCount.count(line));
	}
}
