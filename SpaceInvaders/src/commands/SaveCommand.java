package commands;

import java.io.IOException;

import game.Game;

public class SaveCommand extends Command{
	
	private String name;

	// ______________________ Constructor ______________________    

	public SaveCommand() {
		super("save","v","save","saves the current game.");
	}

	// ______________________   Methods   ______________________

	// parse
	public Command parse(String[] commandWords) {
		SaveCommand command = null;
		
		if (commandWords.length == 2 && matchCommandName(commandWords[0])) {
			command = new SaveCommand();
			command.setCommands(commandWords[1]);
		}
		
		return command;
	}
	
	// Execute
	public boolean execute(Game game) {
		
		try {
			if  (game.saveGame(name))
				System.out.print("  Game successfully saved in file <" + name + ">\n");
			
				else 
					System.out.print("  Error, game not saved");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return false;
	}
	
	private void setCommands(String name) {
		this.name = name + ".dat";
	}

	
	
}