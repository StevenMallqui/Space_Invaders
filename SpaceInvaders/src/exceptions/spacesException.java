package exceptions;

public class spacesException extends Exception {

	//______________ VARIABLE _____________________
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String message = "NOT IN RANGE(1 - 2 SPACES)";
		
	//______________ CONSTRUCTOR __________________
		
	public spacesException() {
		super(message);
	}	
}
