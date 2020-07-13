package exceptions;

public class buysupermissileException extends Exception {
	
	//______________ VARIABLE _____________________
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String message = "Do not enough points";
		
	//______________ CONSTRUCTOR __________________
		
	public buysupermissileException() {
		super(message);
	}	
}
