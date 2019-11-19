package commands;

import game.Game;

public class ExitCommand extends Command{

	// ______________________ Variables   ______________________  

	// ______________________ Constructor ______________________    

	public ExitCommand() {
		super("exit","e","exit","Terminates the program.");
	}

	// ______________________   Methods   ______________________

	// parse
	public Command parse(String[] commandWords) {
		Command command = null;
		
		if (commandWords.length == 1 && (commandWords[0].equals(shortCut) || commandWords[0].equals(name)))
			command = new ExitCommand();
		
		return command;
	}
	
	// Execute
	public boolean execute(Game game) {
		game.endGame();
		return false;
	}
	
	
	
	
}
