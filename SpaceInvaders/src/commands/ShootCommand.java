package commands;

import exceptions.*;
import game.Game;

public class ShootCommand extends Command{

	// ______________________ Variables   ______________________  

	private boolean supermissile;
	
	// ______________________ Constructor ______________________    

	public ShootCommand() {
		super("shoot","s","shoot","UCM-Ship launches a missile.");
	}

	// ______________________   Methods   ______________________

	// parse
	public Command parse(String[] commandWords) {
		ShootCommand command = null;
		
		if (commandWords.length == 1 && matchCommandName(commandWords[0])) {
			command = new ShootCommand();
			command.setCommands(false);
		}
		
		else if (commandWords.length == 2 && matchCommandName(commandWords[0])) {
			if (commandWords[1].equals("supermissile") || commandWords[1].equals("s")) {
				command = new ShootCommand();
				command.setCommands(true);
			}
		}
		
		return command;
	}
	
	// Execute
	public boolean execute(Game game) throws CommandExecuteException{
		boolean ok = false;
		try {
			if (supermissile) {
				if (game.shootSuperMissile()) {
					game.update();
					ok = true;
					supermissile = false;
				}
				else {
					throw new supermissileException();
				}
			}
			 
			else if (game.shootLaser()) {
					game.update();
					ok = true;
			}
			else {
				throw new shootException();
			}
		}
		catch(shootException | supermissileException e) {
			throw new CommandExecuteException(e.getMessage());
		}
		
		
		return ok;
	}
	
	private void setCommands(boolean ok) {
		supermissile = ok;
	}
}