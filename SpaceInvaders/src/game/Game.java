package game;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import exceptions.*;
import gameObjects.GameObject;
import gameObjects.ExplosiveAlien;
import gameObjects.UCMMissile;
import gameObjects.UCMShip;
import gameObjects.UCMSuperMissile;
import view.PrinterGenerator;
import view.StringifierPrinter;


public class Game implements IPlayerController {
		
	// ______________________ Variables   ______________________  
	
	// Constants :
	public final static int DIM_Y = 8;
	public final static int DIM_X = 9 ;
	private final int MissileCost = 20;
	
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
	private int numAliens;
	private boolean direction;
	private boolean goDown;
	private int cont;

	
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
		return numAliens == 0;
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
	
	// shock wave
	public boolean getShockWave() {
		return ucm.getShockwave();
	}

	// List Printer Command
	public String listPrinterCommand() {
		return PrinterGenerator.printerHelp();
	}

	
	// -------------------- Player Actions ---------------------
	
	// SHOOT MISSILE
	public boolean shootLaser() {
		if (ucm.getActiveMissile())
			return false;
			
		else {
			board.add(new UCMMissile(this, ucm.getPosX(), ucm.getPosY()));
			ucm.setMissileActive(true);
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
	
	// Shoot super Missile
	public boolean shootSuperMissile() {
		if (ucm.getActiveMissile())
			return false;
			
		else {
			board.add(new UCMSuperMissile(this, ucm.getPosX(), ucm.getPosY()));
			ucm.setMissileActive(true);
			points--;
			ucm.substractMissile();
			return true;
		}
	}

	// buy super missile
	public void buySuperMissile() {
		
		if (points >= MissileCost) {
				System.out.println("   Missile acquired");
				ucm.addSuperMissile();
				points -= MissileCost;
		}
		
		else 
			System.out.println("  Not enough points");
		
	}
	
	public void deactivateMissile() {
		ucm.setMissileActive(false);
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

	// ------------------- Misc Operations ---------------------
	
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
	
	// get number of missiles
	public int getNumSupermissiles() {
		return ucm.getNumSuperMissile();
	}

	// Serialize
	public String boardToStringifier() {
		return board.toStringifier();
	}

	// set GoDown
	public void setGoDown(boolean set) {
		goDown = set;
		cont = 0;
	}
	
	//Add objects 	
	public void addObject(GameObject object) {
		board.add(object);
	}
	
	// Set number of aliens
	public void setNumAliens(int num) {
		numAliens = num;
	}
		
	// decrease aliens
	public void decreaseAlien() {
		numAliens--;
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

	// Save Game
	public boolean saveGame(String name) throws IOException {
		StringifierPrinter sp = new StringifierPrinter();
		String text = sp.toString(this);
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(name));
		
		writer.write(text);
		writer.close();
		
		return true; 
	}

	// ----------------------   Update   -----------------------

	// Update
	public void update() {
		board.computerAction();
		board.update();
		cycle++;
	}
	
	//Return a boolean if its on board
	public boolean isOnBoard(int posX, int posY) {
		return ucm.getPosX() == posX && ucm.getPosY() == posY;
	}	
	
	// --------------------  Enemy Ships  ----------------------

	// Turn Explosive
	public void regularToExplosive(int posX, int posY, int lives) {
		board.add(new ExplosiveAlien(this, posX, posY, lives));
	}

	// change direction
	public void changeDirection() {
		direction = !direction;
	}

	// Explode
	public void damageNearbyObjects(int x, int y) {
		board.explode(x, y);
	}

	// get go Down
	public boolean goDown() {
		if (cont < numEnemies())
			cont++;
		else
			goDown = false;
		return goDown;
	}
	
	// get number of enemies
	public int numEnemies() {
		return numAliens;
	}

	// get direction
	public boolean getDirection() {
		return direction;
	}
	
}