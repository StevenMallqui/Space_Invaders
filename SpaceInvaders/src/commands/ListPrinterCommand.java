package commands;


import game.Game;

public class ListPrinterCommand extends Command {
	
	// ______________________ Variables   ______________________  


	// ______________________ Constructor ______________________    

	public ListPrinterCommand() {
		super("list printer","lp","list","Prints the list of available ships.");
	}

	// ______________________   Methods   ______________________	
	
	// Parse
	public Command parse(String[] commandWords){
		Command command = null;
		
	
			if (commandWords.length == 1 && matchCommandName(commandWords[0])) {
				
				command = new ListPrinterCommand();
			}
	
		return command;
	}
	
	public boolean execute(Game game) {

		System.out.println(game.listPrinterCommand());
		
		return false;
	}
}