package game;


import java.util.Random;

import gameObjects.AlienShip;
import gameObjects.GameObject;
import gameObjects.UCMShip;


public class Game implements IPlayerController {
		
	// ______________________ Variables   ______________________  
	
	// World Borders :
	public final static int DIM_Y = 8;
	public final static int DIM_X = 9 ;
	
	// Objects
	private UCMShip ucm;
	private BoardInitializer initializer;
	private GameObjectBoard board;
	
	// Variables
	private int cycle = 0;
	private Random rand;
	private Level level;

	// End
	private boolean end;
	
	// ______________________ Constructor ______________________    

	public Game(Level level, Random rand) {
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
		ucm = new UCMShip(this, DIM_X /2, DIM_Y -1);
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
	public String toString(int posX,int posY) {
		return board.toString(posX,posY);
	}
	
	//Game is finished 	
	public boolean isFinished() {
		return playerWin() || aliensWin() || end;
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

	// Move
	public boolean move(int num) {
		boolean ok = false;
		
		if (ucm.availableMove(num)) 
			ok = true;
		
		
		return ok;
	}
	

	// shoot laser
	public boolean shootLaser() {
		
		
		
		return false;
	}

	// shock wave
	public boolean shockWave() {
		
		return ucm.getShockwave();
	}

	// receive points
	public void receivePoints(int points) {
		// TODO Auto-generated method stub
		
	}

	// enable shock wave
	public void enableShockWave() {
		ucm.enableShockWave();
	}

	@Override
	public void enableMissile() {
		
 	}

	public int getNUMFIL() {
		return DIM_X;
	}

	public int getNUMCOL() {
		return DIM_Y;
	}

	public char[] scoreBoard() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int getLives() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getCycle() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getPoints() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int numEnemies() {
		// TODO Auto-generated method stub
		return 0;
	}

}