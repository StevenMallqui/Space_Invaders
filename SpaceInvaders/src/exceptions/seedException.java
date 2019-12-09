package exceptions;

public class seedException extends Exception{

	//______________ VARIABLE _____________________
	
	private static String message = "the seed must be a number";
	
	//______________ CONSTRUCTOR __________________
	
	public seedException() {
		super(message);
	}	
}
