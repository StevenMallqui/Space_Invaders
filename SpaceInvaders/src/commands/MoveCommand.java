package commands;

import game.Game;

public class MoveCommand extends Command{

	// ______________________ Variables   ______________________  

	private String direction;
	private String spaces;
	
	// ______________________ Constructor ______________________    

	public MoveCommand() {
		super("move","m","move <left|right><1|2>","Moves UCM-Ship to the indicated direction.");
	}

	// ______________________   Methods   ______________________

	// parse
	public Command parse(String[] commandWords) {
		Command command = null;
		
		if (commandWords.length == 3 && (commandWords[0].equals(shortCut) || commandWords[0].equals(name))) {
			command = new MoveCommand();
		}
			
		return command;
	}
	
	// Execute
	public boolean execute(Game game) {
		boolean ok = false;

		if (game.validMovement(direction, spaces)) {
			game.update();
			game.moveUCMShip(direction, spaces);
			ok = true;
		}

		return ok;
	}
}
