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
			if (commandWords.length == 3) {
				if(matchCommandName(commandWords[0])) {
					command = new MoveCommand();
					
					if(commandWords[1].equals("left")||commandWords[1].equals("right")) {
						command.setCommands(commandWords[1], commandWords[2]);
						if(command.getSpaces() > 0 && command.getSpaces() < 3) {
							if(command.getDirection().equals("left")) {
								command.setSpaces(command.iSpaces());
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
				
				else {
					throw new wrongWordException();
				}
			}
			
			else if(commandWords.length > 3){ 
				throw new lengthException();
			}
		}
		
		catch(lengthException | wrongWordException | directionException|spacesException e){
			throw new CommandParseException(e.getMessage());
		}
		
		return command;
	}
	
	// __________________________ EXECUTE ___________________________
	
	public boolean execute(Game game) throws CommandExecuteException {
		
		boolean ok = false;
		
		if (game.move(spaces)) {
			game.update();
			ok = true;
		}
	
		return ok;
	}
	
	private void setCommands(String command1, String command2) {
		direction = command1;
		spaces = Integer.parseInt(command2) ;
	}
	
	private String getDirection() {
		return direction;
	}
	private int getSpaces() {
		return spaces;
	}
	private void setSpaces(int aux) {
		spaces = aux;
	}
	private int iSpaces() {
		return spaces = -spaces;
	}
}