package exceptions;

public class lengthException extends Exception {
	
	//______________ VARIABLE _____________________
	
	private static String message = "MAX 3 WORDS";
	
	//______________ CONSTRUCTOR __________________
	
	public lengthException() {
		super(message);
	}	
	
	
}
