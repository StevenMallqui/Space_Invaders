package commands;

import game.Game;

public class MoveCommand extends Command{

	// ______________________ Variables   ______________________  

	private String direction;
	private int spaces;
	
	// ______________________ Constructor ______________________    

	public MoveCommand() {
		super("move","m","move <left|right><1|2>","Moves UCM-Ship to the indicated direction.");
	}

	// ______________________   Methods   ______________________

	// parse
	public Command parse(String[] commandWords) {
		MoveCommand command = null;
		
		if (commandWords.length == 3 && (commandWords[0].equals(shortCut) || commandWords[0].equals(name))) {
			command = new MoveCommand();
			command.setCommands(commandWords[1], commandWords[2]);
		}
		return command;
	}
	
	// Execute
	public boolean execute(Game game) {
		boolean ok = false;
		
		if (direction.equals("left"))
			spaces = -spaces;

		if (game.move(spaces)) {
			game.update();
			ok = true;
		}

		return ok;
	}
	
	private void setCommands(String command1, String command2) {
		direction = command1;
		spaces =Integer.parseInt(command2) ;
	}
}