package commands;

import game.Game;
import view.Stringifier;

public class StringifyCommand extends Command {
	
	// ______________________ Variables   ______________________  


	// ______________________ Constructor ______________________    

	public StringifyCommand() {
		super("stringify","","stringify","Prints standart text format");
	}

	// ______________________   Methods   ______________________	
	
	// Parse
	public Command parse(String[] commandWords) {
		Command command = null;
		
		if (commandWords.length == 1 && matchCommandName(commandWords[0]))
			command = new StringifyCommand();
		
		return command;
	}
	
	public boolean execute(Game game) {
		Stringifier str = new Stringifier();
		System.out.println(str.toString(game));
		return false;
	}
}