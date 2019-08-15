package assignment2;

public interface Guitar {

	default void play() {
		System.out.println("play() method in Guitar interface.");
	}
}
