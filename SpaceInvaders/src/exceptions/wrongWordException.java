package exceptions;

public class wrongWordException extends Exception {

	//______________ VARIABLE _____________________
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String message = "UNKNOWN COMMAND";
	
	//______________ CONSTRUCTOR __________________
	
	public wrongWordException() {
		super(message);
	}	
}
