package commands;

import game.Game;

public class BuySuperMissileCommand extends Command {

	// ______________________ Variables   ______________________  

	// ______________________ Constructor ______________________    

	public BuySuperMissileCommand() {
		super("buy","b","Buy SUper Missile","Spend 20 points to buy a superMissile");
	}

	// ______________________   Methods   ______________________

	// parse
	public Command parse(String[] commandWords) {
		Command command = null;
		
		if (commandWords.length == 1 && matchCommandName(commandWords[0]))
			command = new BuySuperMissileCommand();
		
		return command;
	}
	
	// Execute
	public boolean execute(Game game) {
		
		game.buySuperMissile();
		
		return false;
	}
	
}