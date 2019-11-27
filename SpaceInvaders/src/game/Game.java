package game;


import java.util.Random;

import stuff.*;

public class Game implements IPlayerController {
		
	// ______________________ Variables   ______________________  
	
	// World Borders :
	private final static int DIM_Y = 8;
	private final static int DIM_X = 9 ;
	
	// Objects
	private UCMShip ucm;
	private BoardInitializer initializer;
	GameObjectBoard board;
	
	// Variables
	private int cycle = 0;
	private Random rand;
	private Level level;

	// End
	private boolean end;
	
	// ______________________ Constructor ______________________    

	public Game(Level level,Random rand) {
		this.rand = rand;
		this.level = level;
		initializer = new BoardInitializer();
		initGame();
		
	}
	// ______________________   Methods   ______________________

	//Initializer 
	public void initGame () {
		cycle = 0;
		board = initializer.initialize(this, level);
		ucm = new UCMShip(this, DIM_X / 2, DIM_Y - 1);
		board.add(ucm);
	}
	
	//Return our random number 
	
	public Random getRandom() {
		return rand;
	}
	
	//Return the level selected 
	
	public Level getLevel() {
		return level;
	}
	
	//Restart the game
	
	public void reset() {
		initGame();
	}
	
	//Add objects 
	
	public void addObject(GameObject object) {
		board.add(object);
	}
	
	//COLLISIONS && PRINTING 
	public String toString(int x,int y) {
		return board.toString(x,y);
	}
	
	//Game is finished 
	
	public boolean isFinished() {
		return playerWin() || aliensWin() || doExit;
	}
	
	//Player wins
	
	private boolean playerWin() {
		return AlienShip.allDead();
	}
	
	//Aliens wins
	public boolean aliensWin() {
		return !ucm.isAlive() || AlienShip.haveLanded();
	}
	
	// ----------------------   Update   -----------------------

	// Update
	public void update() {
		board.computerAction();
		board.update();
		cycle +=1;
	}
	
	//Return a boolean if it´s on board
	
	public boolean isOnBoard(int posX, int posY) {

		return false;
	}
	
	
	// End game
	public void endGame() {
		end = true;
	}
	
	//When game is finished 
	
	public String getWinnerMessage () {
		if (playerWin()) return "Player win!";
		else if (aliensWin()) return "Aliens win!";
		else if (end) return "Player exits the game";
		else return "This should not happen";
	}

	@Override
	public boolean move(int numCells) {
		ucm.move(numCells);
		return false;
	}

	@Override
	public boolean shootLaser() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean shockWave() {
		
		return ucm.getShockwave;
	}

	@Override
	public void receivePoints(int points) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enableShockWave() {
		ucm.enableShockWave;
		
	}

	@Override
	public void enableMissile() {
		
 	}
}