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
	
	// direction
	private int points = 0;
	private boolean direction;

	
	// ______________________ Constructor ______________________    

	public Game(Level level, Random rand) {
		this.rand = rand;
		this.level = level;
		initializer = new BoardInitializer();
		initGame();
		
	}
	// ______________________   Methods   ______________________
	
	// ----------------------  Get Info  -----------------------
	
	//Return our random number 
	public Random getRandom() {
		return rand;
	}
	
	//Return the level selected 	
	public Level getLevel() {
		return level;
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

	// receive points
	public void receivePoints(int points) {
		// TODO Auto-generated method stub
		
	}
	
	// Get lives
	public int getLives() {
		return ucm.getLive();
	}

	// get cycle
	public int getCycle() {
		return cycle;
	}

	// get points
	public int getPoints() {
		return points;
	}

	// get number of enemies
	public int numEnemies() {
		return board.getCurrentEnemies();
	}

	// get direction
	public boolean getDirection() {
		return direction;
	}
	
	// ----------------------  Set Info  -----------------------
	
	// enable shock wave
	public void enableShockWave() {
		ucm.enableShockWave();
	}

	// enable missile
	public void enableMissile() {
		ucm.enableMissile();
 	}

	// ----------------------  End Game  -----------------------

	//Initializer 
	public void initGame () {
		cycle = 0;
		board = initializer.initialize(this, level);
		ucm = new UCMShip(this, DIM_X /2, DIM_Y -1);
		board.add(ucm);
	}

	// End game
	public void endGame() {
		end = true;
	}

	//Restart the game	
	public void reset() {
		initGame();
	}

	//When game is finished 
	public String getWinnerMessage () {
		if (playerWin()) return "Player win!";
		else if (aliensWin()) return "Aliens win!";
		else if (end) return "Player exits the game";
		else return "This should not happen";
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
	
	
	// ---------------------- Operations -----------------------

	
	//Add objects 	
	public void addObject(GameObject object) {
		board.add(object);
	}
	
	// Move
	public boolean move(int num) {
		boolean ok = false;
		
		if (ucm.getPosY() + num >= 0 && ucm.getPosY() + num <= DIM_Y) {
			ok = true;
			ucm.setMovement(num);
		}
		
		return ok;
	}
	
	// shock wave
	public boolean getShockWave() {
		return ucm.getShockwave();
	}

	// print score board
	public String scoreBoard() {
		String text = "";
		
		text += "  Cycle : " + cycle + "\n";
		text += "  lives : " + ucm.getLive() + "\n";
		text += "  Points : " + points + "\n";
		text += "  Shockwave : " + ucm.getShockwave() + "\n";
		text += "  Aliens left : " + board.getCurrentEnemies() + "\n";

		return text;
	}
	
	// change direction
	public void changeDirection() {
		if (direction)
			direction = false;
		else
			direction = true;
	}

	// shoot Laser
	public boolean shootLaser() {
		return board.shootLaser();
	}

	// shoot shock wave
	public boolean shockWave() {
		return board.shootShockwave();
	}
}