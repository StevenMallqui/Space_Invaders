package game;


import java.util.Random;

import exceptions.*;
import gameObjects.GameObject;
import gameObjects.UCMMissile;
import gameObjects.UCMShip;
import view.PrinterGenerator;


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
	private boolean end = false;
	
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
	// ______________________   METHODS   ______________________
	
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
	public String toString(int posX, int posY) {
		return board.toString(posX,posY);
	}
	
	//Game is finished 	
	public boolean isFinished() {
		return playerWin() || aliensWin() || end;
	}
	
	//Player wins	
	private boolean playerWin() {
		return board.allDead();
	}
	
	//Aliens wins
	public boolean aliensWin() {
		return !ucm.isAlive() || board.haveLanded();
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
	
	// ______________________PLAYER ACTIONS__________________________
	
	// SHOOT MISSILE
	public boolean shootLaser() {
		if (!board.shootLaser())
			return false;
			
		else {
			board.add(new UCMMissile(this, ucm.getPosX(), ucm.getPosY(), 1));
			return true;
		}
	}

	// SHOOT SHOCKWAVE
	public boolean shockWave(){
	
			if (ucm.getShockwave()) {
				board.shootShockwave();
				ucm.setShockWave(false);
				return true;
			}
			
			else 
				return false;
			
	}
		
	// MOVE
	public boolean move(int num) throws CommandExecuteException {
		boolean ok = false;
		try {	
			if (ucm.getPosY() + num >= 0 && ucm.getPosY() + num <= DIM_Y) {
				ok = true;
				ucm.setMovement(num);
			}
			else {
				throw new limitException();
			}
		}
		catch(limitException e) {
			throw new CommandExecuteException(e.getMessage());
		}
			
	
		
		return ok;
	}

	//______________________CALLBACKS_____________________________
	
	// RECEIVE POINTS
	public void receivePoints(int points) {
		this.points += points;
	}
			
	// ENABLE SHOCKWAVE
	public void enableShockWave() {
		ucm.setShockWave(true);
	}

	// ENABLE MISSILE
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
		cycle ++;
	}
	
	//Return a boolean if it´s on board
	public boolean isOnBoard(int posX, int posY) {
		return ucm.getPosX() == posX && ucm.getPosY() == posY;
	}
	
	
	// ---------------------- Operations -----------------------

	
	//Add objects 	
	public void addObject(GameObject object) {
		board.add(object);
	}
	
	
	// shock wave
	public boolean getShockWave() {
		return ucm.getShockwave();
	}
	
	// change direction
	public void changeDirection() {
		direction = !direction;
	}

	public void buySuperMissile() {
		
		if (points >= 20) {
				System.out.println("   Missile acquired");
				ucm.addSuperMissile();
				points -= 20;
		}
		
		else 
			System.out.println("  Not enough points");
		
	}

	public int getNumSupermissiles() {
		return ucm.getNumSuperMissile();
	}

	public boolean shootSuperMissile() {
		if (!board.shootLaser())
			return false;
			
		else {
			board.add(new UCMMissile(this, ucm.getPosX(), ucm.getPosY(), 2));
			points--;
			ucm.substractMissile();
			return true;
		}
	}

	public void damageNearbyObjects(int x, int y) {
		board.explode(x, y);
	}

	public String boardToStringifier() {
		return board.toStringifier();
	}

	public String listPrinterCommand() {
		return PrinterGenerator.printerHelp();
	}

}