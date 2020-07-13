package game;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import exceptions.*;
import gameObjects.GameObject;
import gameObjects.AlienShip;
import gameObjects.ExplosiveAlien;
import gameObjects.UCMMissile;
import gameObjects.UCMShip;
import gameObjects.UCMSuperMissile;
import view.PrinterGenerator;
import view.StringifierPrinter;

public class Game implements IPlayerController {
	
	// ______________________ Variables   ______________________  													
	
	public final static int DIM_Y = 8;
	public final static int DIM_X = 9 ;
	
	private UCMShip ucm;
	private BoardInitializer initializer;
	private GameObjectBoard board;

	private int cycle = 0;
	private Random rand;
	private Level level;
	
	private int numAliens = 0;

	private boolean end = false;

	// ______________________ Constructor ______________________    

	public Game(Level level, Random rand) {
		this.rand = rand;
		this.level = level;
		initializer = new BoardInitializer();
		initGame();
		
	}
	// ______________________   METHODS   ______________________
	
	public void initGame () {
		cycle = 0;
		board = initializer.initialize(this, level);
		ucm = new UCMShip(this, DIM_X /2, DIM_Y -1);
		board.add(ucm);
	}
	
	public Random getRandom() {
		return rand;
	}
	
	public Level getLevel() {
		return level;
	}
	
	public void reset() {
		initGame();
	}
	
	public void addObject(GameObject object) {
		board.add(object);
	}

	public String toString(int posX, int posY) {
		return board.toString(posX,posY);
	}
	
	public boolean isFinished() {
		return playerWin() || aliensWin() || end;
	}
	
	private boolean aliensWin() {
		return !ucm.isAlive() || AlienShip.haveLanded();
	}
	
	private boolean playerWin() {
		return AlienShip.allDead();
	}
	
	public void update() {
		board.computerAction();
		board.update();
		cycle++;
	}
		
	public boolean isOnBoard(int posX, int posY) {
		return ucm.getPosX() == posX && ucm.getPosY() == posY;
	}	
	
	public void endGame() {
		end = true;
	}
	
	public String boardToStringifier() {
		return board.toStringifier();
	}

	public String getWinnerMessage () {
		if (playerWin()) return "Player win!";
		else if (aliensWin()) return "Aliens win!";
		else if (end) return "Player exits the game";
		else return "This should not happen";
	}
	

	//______________________IPlayerController____________________
	
	//PLAYER ACTIONS
	
	public boolean move(int num) throws CommandExecuteException{
		return ucm.emove(num);
	}

	public boolean shootLaser() {
		return ucm.shootLaser();
	}

	public boolean shockWave(){
		return ucm.shockWave();
	}
	
	//CALLBACKS
	
	public void receivePoints(int points) {
		ucm.setPoints(points);
	}
	
	public void enableShockWave() {
		ucm.setShockWave(true);
	}

	public void enableMissile() {
		ucm.setMissileActive(true);
	}
	
	//_____________________________________________________________________
	
	public GameObjectBoard getBoard() {
		return board;
	}

	public int getCycle() {
		return cycle;
	}

	public UCMShip getUCMShip() {
		return ucm;
	}
	//______________________COMMANDS____________________

	public String listPrinterCommand() {
		return PrinterGenerator.printerHelp();
	}

	public boolean shootSuperMissile() {
		return ucm.shootSuperMissile();
	}


	public void buySuperMissile() throws CommandExecuteException {
		ucm.buySuperMissile();
	}
	
	public boolean saveGame(String name) throws IOException {
		StringifierPrinter sp = new StringifierPrinter();
		String text = sp.toString(this);
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(name));
		
		writer.write(text);
		writer.close();
		
		return true; 
	}
	
	public void regularToExplosive(int posX, int posY, int lives) {
		board.add(new ExplosiveAlien(this, posX, posY, lives));
	}
	
	public void explode(int x, int y) {
		board.explode(x, y);
	}


	public void setNumAliens(int num) {
		numAliens = num;
	}

	public void decreaseAlien() {
		numAliens--;
	}
	
	public int numEnemies() {
    	return numAliens;
	}
	
}