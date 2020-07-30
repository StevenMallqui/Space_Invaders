package exceptions;

public class levelException extends Exception {
	//______________ VARIABLE _____________________
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private static String message;
		
		//______________ CONSTRUCTOR __________________
		
		public levelException(String text) {
			super(text);
			this.message = text;
			
		}	
}
