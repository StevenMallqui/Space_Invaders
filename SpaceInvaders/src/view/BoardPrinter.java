package view;

import commands.*;

import game.Game;
import game.GameObjectBoard;
import util.MyStringUtils;

public class BoardPrinter implements GamePrinter {

	int numRows; 
	int numCols;
	String[][] board;
	final String space = " ";
	
	public BoardPrinter(int dimX, int dimY) {
		numRows = dimX;
		numCols = dimY;
		
	}

	public String toString(Game game) {
		board = new String[numRows][numCols];
		for(int i = 0; i < numRows; i++) {
			for(int j = 0; j < numCols; j++) {
				board[i][j] =  game.toString(i, j);
			}
		}

		int cellSize = 7;
		int marginSize = 2;
		String vDelimiter = "|";
		String hDelimiter = "-";
		
		String rowDelimiter = MyStringUtils.repeat(hDelimiter, (numCols * (cellSize + 1)) - 1);
		String margin = MyStringUtils.repeat(space, marginSize);
		String lineDelimiter = String.format("%n%s%s%n", margin + space, rowDelimiter);
		
		StringBuilder str = new StringBuilder();
		
		str.append(lineDelimiter);
		
		for(int i=0; i<numRows; i++) {
				str.append(margin).append(vDelimiter);
				for (int j=0; j<numCols; j++) {
					str.append( MyStringUtils.centre(board[i][j], cellSize)).append(vDelimiter);
				}
				str.append(lineDelimiter);
		}
		return str.toString();
	}


	public GamePrinter parse(String name) {
		return PrinterGenerator.parse(name);
	}

	public String helpText() {
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
		
		return text;
	}
	
	// score board
	public String scoreBoard(Game game) {
		String text = "";		
		text += "\n  Life : " + game.getLives();
		text += "\n  Number of cycles : " + game.getCycle();
		text += "\n  Points : " + game.getPoints();
		text += "\n  Remaining aliens : " + game.numEnemies();
		text += "\n  Shockwave : " + game.shockWave();
		text += "\n  Super Missiles : " + game.getNumSupermissiles();
		return text;
	}
	
}
