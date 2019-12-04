package commands;

import game.Game;
import view.BoardPrinter;

public class HelpCommand extends Command{

	// ______________________ Variables   ______________________  

	// ______________________ Constructor ______________________    

	public HelpCommand() {
		super("help","h","help","Prints this help message.");
	}

	// ______________________   Methods   ______________________

	// Parse
	public Command parse(String[] commandWords) {
		Command command = null;
		
		if (commandWords.length == 1 && (commandWords[0].equals(shortCut) || commandWords[0].equals(name)))
			command = new HelpCommand();
		
		return command;
	}
	
	// Execute
	public boolean execute(Game game) {
		BoardPrinter bp = new BoardPrinter(Game.DIM_X, Game.DIM_Y);

		System.out.print(bp.helpCommand());
		
		return false;
	}
}