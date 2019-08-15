package assignment2;

public class Instrument implements Guitar, Piano {
	
	//First approach
	@Override
	public void play() {
		System.out.println("play() method in Instrument class.");
	}
	
	//Second approach
	public void playParent(){
		Piano.super.play();
		Guitar.super.play();
	}
}
