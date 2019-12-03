package commands;

import game.Game;

public class ListCommand extends Command {
	
	// ______________________ Variables   ______________________  


	// ______________________ Constructor ______________________    

	public ListCommand() {
		super("list","l","list","Prints the list of available ships.");
	}

	// ______________________   Methods   ______________________	
	
	// Parse
	public Command parse(String[] commandWords) {
		Command command = null;
		
		if (commandWords.length == 1 && matchCommandName(commandWords[0]))
			command = new ListCommand();
		
		return command;
	}
	
	public boolean execute(Game game) {
		System.out.println("\n[R]egular ship: Points: 5 - Harm: 0 - Shield: 2");
		System.out.println("[D]estroyer ship: Points: 10 - Harm:1 - Shield: 1");
		System.out.println("[O]vni: Points: 25 - Harm: 0 - Shield: 1");
		System.out.println("^__^: Harm: 1 - Shield: 3\n");

		return false;
	}
}