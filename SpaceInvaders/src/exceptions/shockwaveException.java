package exceptions;

public class shockwaveException extends Exception{
//______________ VARIABLE _____________________
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private static String message = "Failed to shoot";
		
//______________ CONSTRUCTOR __________________
		
	public shockwaveException() {
		super(message);
	}	
}
