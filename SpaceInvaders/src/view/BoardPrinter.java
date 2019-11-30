package view;

import game.Game;
import gameObjects.GameObjectBoard;

public class BoardPrinter implements GamePrinter {

	public BoardPrinter(int dimX, int dimY) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString(Game game) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GamePrinter parse(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String helpText() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// score board
	public String scoreBoard(Game game) {
		String text = "";		
		text += "  Life : " + game.getLives();
		text += "\n  Number of cycles : " + game.getCycle();
		text += "\n  Points : " + game.getPoints();
		text += "\n  Remaining aliens : " + game.numEnemies();
		text += "\n  Shockwave : " + game.shockWave();
		
		return text;
	}
}
