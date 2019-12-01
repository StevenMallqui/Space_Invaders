package view;

import game.Game;

public interface GamePrinter {
	
	String toString(Game game);
	
	public GamePrinter parse(String name);
	
	public String helpText();
}


/*
package game;

import util.MyStringUtils;

public class GamePrinter {
	
	
	
	public GamePrinter (Game game, int rows, int cols) {
		this.numRows = rows;
		this.numCols = cols;		
		encodeGame(game);
	}
	
	private void encodeGame(Game game) {
	}
	
	public String toString() {

	}
}
*/