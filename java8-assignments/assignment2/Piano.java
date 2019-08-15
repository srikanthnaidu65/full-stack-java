package assignment2;

public interface Piano {
	
	default void play() {
		System.out.println("play() method in Piano interface.");
	}
}
