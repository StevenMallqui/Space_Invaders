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
		
		if (commandWords.length == 1 && (commandWords[0].equals(shortCut) || commandWords[0].equals(name)))
			command = new ShockwaveCommand();
		
		return command;		
	}
	
	// Execute
	public boolean execute(Game game) {
		boolean ok = false;

		if (game.getShockwave()) {
			game.shootShockwave();
			ok = false;
			game.update();
		}
		
		return ok;
	}
	
	
	
	
}
