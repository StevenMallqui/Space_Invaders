package exceptions;

public class mainException extends Exception{
	
	//______________ VARIABLE _____________________
	
	private static String Mmessage;
	
	//______________ CONSTRUCTOR __________________
	
	public mainException(String string) {
		super(Mmessage);
		Mmessage = string;
	}
	
	//______________ METHODS ______________________
	
	public String getMessage() {
		return Mmessage;
	}
	
}
