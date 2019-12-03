package commands;

import game.Game;

public class ShootCommand extends Command {

	// ______________________ Variables   ______________________  
	
	public boolean supermissil;

	// ______________________ Constructor ______________________    

	public ShootCommand() {
		super("shoot","s","shoot","UCM-Ship launches a missile.");

	}
	
	// ______________________   Methods   ______________________

	// Execute
	public boolean execute(Game game) {
		boolean ok = false;
	
		if (supermissil) {
			if (game.shootSuperMissile()) {
				game.update();
				ok = true;
			}			
		}
		
		else {
			if (game.shootLaser()) {
				game.update();
				ok = true;
			}
		}
		
		return ok;
	}
	
	// parse
	public Command parse(String[] commandWords) {
		Command command = null;
		
		if (commandWords.length == 1 && (commandWords[0].equals(shortCut) || commandWords[0].equals(name))) {
			command = new ShootCommand();
			supermissil = false;
		}
		
		if (commandWords.length == 2 && (commandWords[0].equals(shortCut) || commandWords[0].equals(name)) ) {
			if (commandWords[1].equals("supermissile")) {
				command = new ShootCommand();
				supermissil = true;
			}
		}
			
		return command;
	}

	
}