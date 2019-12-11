package exceptions;

public class levelException extends Exception {
	//______________ VARIABLE _____________________
	
		private static String message;
		
		//______________ CONSTRUCTOR __________________
		
		public levelException(String text) {
			super(message);
			this.message = text;
		}	
}
