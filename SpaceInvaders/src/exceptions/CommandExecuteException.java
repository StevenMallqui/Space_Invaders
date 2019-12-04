package exceptions;

public class CommandExecuteException extends Exception{
	
	//______________ VARIABLE _____________________
	
	private static String Emessage;
	
	//______________ CONSTRUCTOR __________________
	
	public CommandExecuteException(String string) {
		super(Emessage);
		Emessage = string;
	}
	
	//______________ METHODS ______________________
	
	public String getMessage() {
		return Emessage;
	}
	
}
