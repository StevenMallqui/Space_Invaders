package commands;

import exceptions.CommandParseException;

public class CommandGenerator {
	
	// ______________________ Variables   ______________________  

	private static String help;
	
	private static Command[] availableCommands = { 
			new ListCommand(),
			new HelpCommand(),
			new ResetCommand(),
			new ExitCommand(),
			new UpdateCommand(), 
			new MoveCommand(), 
			new ShockwaveCommand(),
			new ShootCommand(),
			new BuySuperMissileCommand(),
			new StringifyCommand(),
			new ListPrinterCommand(),
			new SaveCommand()
			};

	
	// ______________________ Constructor ______________________    


	// ______________________   Methods   ______________________
	
	// Parse
	public static Command parse(String[]commandWords) throws CommandParseException {
		Command command = null;
		
		for(Command availableCommand : availableCommands) {
			command = availableCommand.parse(commandWords);
			
			if(command != null)
				return command;
		}
		
		throw new CommandParseException("NOT COMMAND FOUND");
	}
	
	// Execute help
	public static String commandHelp() {
		
		for(Command availableCommand : availableCommands) 
			help = availableCommand.helpText();
		
		return help;
	}
}