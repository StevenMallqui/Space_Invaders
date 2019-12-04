package exceptions;

public class shockwaveException extends Exception{
//______________ VARIABLE _____________________
	
private static String message = "Failed to shoot";
		
//______________ CONSTRUCTOR __________________
		
	public shockwaveException() {
		super(message);
	}	
}
