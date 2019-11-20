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
		
		if (commandWords.length == 1 && (commandWords[0].equals(shortCut) || commandWords[0].equals(name)))
			command = new UpdateCommand();
		
		return command;
	}

	
	
}