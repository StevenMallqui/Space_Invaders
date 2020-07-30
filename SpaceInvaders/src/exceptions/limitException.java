package exceptions;

public class limitException extends Exception {

	//______________ VARIABLE _____________________
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String message = "Failed to move";
	
	//______________ CONSTRUCTOR __________________
	
	public limitException() {
		super(message);
	}	
}
