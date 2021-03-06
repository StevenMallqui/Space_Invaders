package commands;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import exceptions.*;
import game.Game;
import view.StringifierPrinter;

public class SaveCommand extends Command{
	
	private String name;

	// ______________________ Constructor ______________________    

	public SaveCommand() {
		super("save","v","save","saves the current game.");
	}

	// ______________________   Methods   ______________________

	// parse
	public Command parse(String[] commandWords) throws CommandParseException{
		SaveCommand command = null;
		try {
			
		
			if (commandWords.length == 2 && matchCommandName(commandWords[0])) {
				command = new SaveCommand();
				command.setCommands(commandWords[1]);
			}
			else {
				throw new wrongWordException();
			}
		}
		catch(wrongWordException e) {
			throw new CommandParseException(e.getMessage());
		}
		
		return command;
	}
	
	// Execute
	public boolean execute(Game game) throws CommandExecuteException {
		
		try {
			if  (saveGame(name,game))
				System.out.print("  Game successfully saved in file <" + name + ">\n");
			
				else 
					System.out.print("  Error, game not saved");
		} catch (IOException e) {
			e.printStackTrace();
			throw new CommandExecuteException(e.getMessage());
		}
			
		return false;
	}
	
	private void setCommands(String name) {
		this.name = name + ".dat";
	}

	public boolean saveGame(String name,Game game) throws IOException {
		StringifierPrinter sp = new StringifierPrinter();
		String text = sp.toString(game);
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(name));
		
		writer.write(text);
		writer.close();
		
		return true; 
	}
	
	
}