package commands;

import game.Game;

public class ShockwaveCommand extends Command {

	// ______________________ Variables   ______________________  

	// ______________________ Constructor ______________________    

	public ShockwaveCommand() {
		super("shockwave","w","shockwave","UCM-Ship releases a shock wave.");
	}

	// ______________________   Methods   ______________________

	// Parse
	public Command parse(String[] commandWords) {
		Command command = null;
		
		if (commandWords.length == 1 && matchCommandName(commandWords[0]))
			command = new ShockwaveCommand();
		
		return command;		
	}
	
	// Execute
	public boolean execute(Game game) {
		boolean ok = false;

		if (game.shockWave()) {
			ok = true;
			game.update();
		}
		
		return ok;
	}
	
	
	
	
}
