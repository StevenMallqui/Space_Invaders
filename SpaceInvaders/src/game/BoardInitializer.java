package game;

import gameObjects.Ovni;
import gameObjects.RegularAlien;
import gameObjects.DestroyerAlien;

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
			board.add(new Ovni(game, 0, 9, 1));
		
	}

	//_______________INITIALIZE REGULAR ALIENS_______________________
	/*
	private void initializeRegularAliens () {
		int numAliens = level.getNumRegularAliens();
		int numAliRow = level.getNumRegularAliensPerRow();
		
		int strRow = level.getRegularStartingRow();
		int strCol = level.getRegularStartingCol();
		
		for (int i = 0; i < (numAliens/numAliRow); i++)
			for(int j = 0; j < numAliens; j++)
				board.add(new RegularAlien(game, strRow + i, strCol + j));

	}*/
	
	private void initializeRegularAliens () {
		int numAliens = level.getNumRegularAliens();
		int numAliRow = level.getNumRegularAliensPerRow();
		int strCol = 3;
		
		for (int i = 0; i < numAliRow; i++) {
				board.add(new RegularAlien(game,1, strCol));
				strCol++;
		}
		
		if(numAliens == 8 || numAliens == 12) {
			strCol = 3;
			for(int i = 4; i < 8; i++){
				board.add(new RegularAlien(game,2, strCol));
				strCol++;
			}
		}
		if(numAliens == 12) {
			strCol = 3;
			for(int i = 8; i< numAliens; i++){
				board.add(new RegularAlien(game,3, strCol));
				strCol++;
			}
		}
	}
	
	//_______________INITIALIZE DESTROYER ALIENS_______________________
	/*
	private void initializeDestroyerAliens() {		
		int numAliens = level.getNumDestroyerAliens();
		int numAliRow = level.getNumDestroyerAliensPerRow();
		
		int strRow = level.getDestroyerStartingRow();
		int strCol = level.getDestroyerStartingCol();
		
		for (int i = 0; i < (numAliens/numAliRow); i++)
			for(int j = 0; j < numAliens; j++)
				board.add(new DestroyerAlien(game, strRow + i, strCol + j));

	}*/
	
	private void initializeDestroyerAliens() {		
		int numDestroyers = level.getNumDestroyerAliens();
		int numRegulars = level.getNumRegularAliens();
		int strRow = level.getDestroyerStartingRow();
		int strCol = level.getDestroyerStartingCol();
		
		if(numDestroyers == 2){
			strRow = 2;
			strCol = 4;
		}
		else if(numRegulars == 8 && numDestroyers == 4) {
			strRow = 3;
			strCol = 3;
		}
		else {
			strRow = 4;
			strCol = 3;
		}
		
		for (int i = 0; i < numDestroyers; i++) {
			board.add(new DestroyerAlien(game, strRow, strCol));
			strCol++;
		}
	}
	
}
