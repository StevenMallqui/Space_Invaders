package commands;

import game.Game;

public class ExitCommand extends Command{

	// ______________________ Constructor ______________________    

	public ExitCommand() {
		super("exit","e","exit","Terminates the program.");
	}

	// ______________________   Methods   ______________________

	// parse
	public Command parse(String[] commandWords) {
		Command command = null;
		
		if (commandWords.length == 1 && matchCommandName(commandWords[0]))
			command = new ExitCommand();
		
		return command;
	}
	
	// Execute
	public boolean execute(Game game) {
		game.endGame();
		return false;
	}
	
	
	
	
}