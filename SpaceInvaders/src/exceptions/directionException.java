package exceptions;

public class directionException extends Exception{

	//______________ VARIABLE _____________________
	
	private static String message = "WRONG DIRECTION";
		
	//______________ CONSTRUCTOR __________________
		
	public directionException() {
		super(message);
	}	
}
