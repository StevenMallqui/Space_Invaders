package commands;

import game.Game;

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
		String text = "\n";
		Command c = new MoveCommand();
		text += c.helpText();
		c = new ShootCommand();
		text += c.helpText();
		c = new ShockwaveCommand();
		text += c.helpText();
		c = new ListCommand();
		text += c.helpText();
		c = new ResetCommand();
		text += c.helpText();
		c = new ExitCommand();
		text += c.helpText();
		c = new UpdateCommand();
		text += c.helpText();
		text += this.helpText();
		
		System.out.println(text);
		
		return true;
	}
}