package exceptions;

public class shootException extends Exception {
	//______________ VARIABLE _____________________
	
	private static String message = "Failed to shoot";
			
	//______________ CONSTRUCTOR __________________
			
		public shootException() {
			super(message);
		}	
}
