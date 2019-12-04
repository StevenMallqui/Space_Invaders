package view;

import game.Game;

public abstract class GamePrinter {
	
	protected String printerName;
	protected String helpText;

	public abstract String toString(Game game);
	
	public abstract GamePrinter parse(String name);
	
	public String helpText() {
		return  "  " + printerName + " : " + helpText + "\n";
	}
	
	public abstract void setGame(Game game);
}