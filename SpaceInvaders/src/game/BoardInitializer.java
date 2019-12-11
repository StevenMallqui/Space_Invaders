package game;

import gameObjects.Ovni;
import gameObjects.RegularAlien;
import gameObjects.DestroyerAlien;

public class BoardInitializer {
	
	private Level level;
	private GameObjectBoard board;
	private Game game;
	
	private int alienCont = 0;
	
	// initialize game object board
	public  GameObjectBoard initialize(Game game, Level level) {
		this.level = level;
		this.game = game;
		board = new GameObjectBoard(Game.DIM_X, Game.DIM_Y);
		
		initializeOvni();
		initializeRegularAliens();
		initializeDestroyerAliens();
		
		game.setNumAliens(alienCont);
		return board;
	}
	
	// initialize ufo
	private void initializeOvni () {
		board.add(new Ovni(game));
		
	}
	
	// initialize regular aliens
	private void initializeRegularAliens () {
		int numShips = level.getNumRegularAliens();
		int numShipsPerRow = level.getNumAliensPerRow();
		int strCol = level.getRegularStartingCol();
		int strRow = level.getRegularStartingRow();
		
		alienCont += numShips;
		
		for (int i = 0; i < (numShips / numShipsPerRow); i++) 
			for (int j = 0; j < numShipsPerRow; j++) 
				board.add(new RegularAlien(game, strRow + i, strCol + j));
			
		
	}
		
	// initialize destroyer alien
	private void initializeDestroyerAliens() {		
		int numShips = level.getNumDestroyerAliens();
		int strCol = level.getDestroyerStartingCol();
		int strRow = level.getDestroyerStartingRow();
		
		alienCont += numShips;

		for (int i = 0; i < numShips; i++) 
			board.add(new DestroyerAlien(game, strRow, strCol + i));
		
	
	}
	
}
