package commands;

import game.Game;

public class ResetCommand extends Command {

	// ______________________ Variables   ______________________  

	// ______________________ Constructor ______________________    

	public ResetCommand() {
		super("reset", "r", "reset", "Starts a new game.");
	}
	
	// ______________________   Methods   ______________________

	// Parse
	public Command parse(String[] commandWords) {
		Command command = null;
		
		if (commandWords.length == 1 && matchCommandName(commandWords[0]))
			command = new ResetCommand();
		
		return command;

	}
	
	// Execute
	public boolean execute(Game game) {
		game.initGame();
		return true;
	}
	
	
	
	
}