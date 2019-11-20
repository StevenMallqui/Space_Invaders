package commands;

import game.Game;

public class ShootCommand extends Command {

	// ______________________ Variables   ______________________  

	// ______________________ Constructor ______________________    

	public ShootCommand() {
		super("shoot","s","shoot","UCM-Ship launches a missile.");

	}
	
	// ______________________   Methods   ______________________

	// Execute
	public boolean execute(Game game) {
		boolean ok = false;
	
		if (!game.getActiveMissile()) {
			game.shootMissile();
			game.update();
			ok = true;
		}
		
		return ok;
	}
	
	// parse
	public Command parse(String[] commandWords) {
		Command command = null;
		
		if (commandWords.length == 1 && (commandWords[0].equals(shortCut) || commandWords[0].equals(name))) {
			command = new ShootCommand();
		}
			
		return command;
	}

	
}