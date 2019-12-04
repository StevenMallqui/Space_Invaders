package exceptions;

public class limitException extends Exception {

	//______________ VARIABLE _____________________
	
	private static String message = "Failed to move";
	
	//______________ CONSTRUCTOR __________________
	
	public limitException() {
		super(message);
	}	
}
