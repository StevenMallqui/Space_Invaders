package commands;

import exceptions.*;
import game.*;


public abstract class Command {
	
	// ______________________ Variables   ______________________  

	protected final String name; 
	protected final String shortCut; 
	private final String details ; 
	private final String help;

	protected static final String incorrectNumArgsMsg = "Incorrect number of arguments"; 
	protected static final String incorrectArgsMsg = "Incorrect argument format";
	
	// ______________________ Constructor ______________________    

	public Command(String name, String shortCut, String details, String help){
		this.name = name; 
		this.shortCut = shortCut; 
		this.details = details; 
		this.help = help;
	}

	// ______________________   Methods   ______________________

	// ----------------------  Abstract   ----------------------
	
	// execute
	public abstract boolean execute(Game game) throws CommandExecuteException;
	
	// Parse
	public abstract Command parse(String[] commandWords) throws CommandParseException;

	// ----------------------  Operations ----------------------

	// Match Command name
	protected boolean matchCommandName(String name) { 
		return this.shortCut.equalsIgnoreCase(name) ||
			this. name.equalsIgnoreCase(name); 
	}
	
	// help text
	public String helpText(){
		return " " + details + " : " + help + "\n";
	} 
}