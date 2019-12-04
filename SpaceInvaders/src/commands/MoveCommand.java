package commands;

import exceptions.*;
import game.Game;

public class MoveCommand extends Command{

	// ______________________ Variables   ______________________  

	private String direction;
	private int spaces;
	
	// ______________________ Constructor ______________________    

	public MoveCommand() {
		super("move", "m","move <left|right> <1|2>","Moves UCM-Ship to the indicated direction.");
	}

	// ______________________   METHODS   ______________________

	// _________________________ PARSE ________________________________
	
	public Command parse(String[] commandWords) throws CommandParseException {
		
		MoveCommand command = null;
		
		try {
			if (commandWords.length == 3 ) {
				if(matchCommandName(commandWords[0])) {
					command = new MoveCommand();
					command.setCommands(commandWords[1], commandWords[2]);
				}
				
				else {
					throw new wrongWordException();
				}
			}
			
			else { 
				throw new lengthException();
			}
		}
		
		catch(lengthException | wrongWordException e){
			throw new CommandParseException(e.getMessage());
		}
		
		return command;
	}
	
	// __________________________ EXECUTE ___________________________
	
	public boolean execute(Game game) throws CommandExecuteException {
		
		boolean ok = false;
		
		try {
			if (direction.equals("left") || direction.equals("right")) { 
				if (spaces ==  1 || spaces == 2) {
					
					if (direction.equals("left"))
						spaces = -spaces;
			
					if (game.move(spaces)) {
						game.update();
						ok = true;
					}
				}
				
				else {
					throw new spacesException();
				}
			}
			
			else {
				throw new directionException();
			}
		}
			
		catch(directionException | spacesException e) {
			throw new CommandExecuteException(e.getMessage());
		}

		return ok;
	}
	
	private void setCommands(String command1, String command2) {
		direction = command1;
		spaces = Integer.parseInt(command2) ;
	}
}