package exceptions;

public class supermissileException extends Exception {
	//______________ VARIABLE _____________________
	
	private static String message = "No super missiles in stock ";
	
	//______________ CONSTRUCTOR __________________
	
	public supermissileException() {
		super(message);
	}
}
