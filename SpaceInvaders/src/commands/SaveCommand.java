package commands;

import game.Game;

public class SaveCommand extends Command{
	
	private String name;

	// ______________________ Constructor ______________________    

	public SaveCommand() {
		super("save","s","save","saves the current game.");
	}

	// ______________________   Methods   ______________________

	// parse
	public Command parse(String[] commandWords) {
		Command command = null;
		
		if (commandWords.length == 2 && matchCommandName(commandWords[0])) {
			command = new SaveCommand();
			setFileName(commandWords[1]);
		}
		
		return command;
	}
	
	// Execute
	public boolean execute(Game game) {
		
//		if  (game.saveGame(name))
//			System.out.println("  Game successfully saved in file <" + name + ">\n");
//		
//			else 
//				System.out.println("  Error, game not saved");
			
		return false;
	}
	
	private void setFileName(String name) {
		this.name = name + ".dat";
	}

	
	
}