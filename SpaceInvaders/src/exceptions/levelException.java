package exceptions;

public class levelException extends Exception {
	//______________ VARIABLE _____________________
	
		private static String message = "level must be one of: EASY, HARD, INSANE";
		
		//______________ CONSTRUCTOR __________________
		
		public levelException() {
			super(message);
		}	
}
