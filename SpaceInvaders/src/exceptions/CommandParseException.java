package exceptions;

public class CommandParseException extends Exception{
	
	//______________ VARIABLE _____________________
	
	private static String Pmessage;
	
	//______________ CONSTRUCTOR __________________
	
	public CommandParseException(String string) {
		super(Pmessage);
		Pmessage = string;
	}
	
	//______________ METHODS ______________________
	
	public String getMessage() {
		return Pmessage;
	}
}
