package view;

import game.Game;

public interface GamePrinter {
	
	String toString(Game game);
	
	public GamePrinter parse(String name);
	
	public String helpText();

	void setGame(Game game);
}

