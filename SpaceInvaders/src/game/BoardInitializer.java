package game;

import gameObjects.Ovni;
import gameObjects.RegularAlien;
import gameObjects.DestroyerAlien;
import gameObjects.GameObjectBoard;

public class BoardInitializer {
	
	private Level level;
	private GameObjectBoard board;
	private Game game;
	
	// initialize game object board
	public  GameObjectBoard initialize(Game game, Level level) {
		this.level = level;
		this.game = game;
		board = new GameObjectBoard(Game.DIM_X, Game.DIM_Y);
		
		initializeOvni();
		initializeRegularAliens();
		initializeDestroyerAliens();
		return board;
	}
	
	// initialize ufo
	private void initializeOvni () {
		board.add(new Ovni(game, -1, -1, 0));
	}

	// initialize regular aliens
	private void initializeRegularAliens () {
		int numAliens = level.getNumRegularAliens();
		int numAliRow = level.getNumRegularAliensPerRow();
		
		int strRow = level.getRegularStartingRow();
		int strCol = level.getRegularStartingCol();
		
		for (int i = 0; i < (numAliens/numAliRow); i++)
			for(int j = 0; j < numAliens; j++)
				board.add(new RegularAlien(game, strRow + i, strCol + j));

	}
	
	// initialize destroyer aliens
	private void initializeDestroyerAliens() {		
		int numAliens = level.getNumDestroyerAliens();
		int numAliRow = level.getNumDestroyerAliensPerRow();
		
		int strRow = level.getDestroyerStartingRow();
		int strCol = level.getDestroyerStartingCol();
		
		for (int i = 0; i < (numAliens/numAliRow); i++)
			for(int j = 0; j < numAliens; j++)
				board.add(new DestroyerAlien(game, strRow + i, strCol + j));

	}
	
}
