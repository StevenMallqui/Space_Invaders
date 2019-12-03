package commands;

import game.Game;

public class UpdateCommand extends Command{

	// ______________________ Variables   ______________________  

	// ______________________ Constructor ______________________    

	public UpdateCommand() {
		super("","","[none]","Skips one cycle.");

	}

	// ______________________   Methods   ______________________

	// Execute
	public boolean execute(Game game) {
		game.update();
		return true;
	}
	
	
	// parse
	public Command parse(String[] commandWords) {
		Command command = null;
		
		if (commandWords.length == 1 && matchCommandName(commandWords[0]))
			command = new UpdateCommand();
		
		return command;
	}

	
	
}