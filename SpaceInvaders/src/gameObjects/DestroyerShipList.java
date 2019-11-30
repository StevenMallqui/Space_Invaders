package gameObjects;

import java.util.Random;

import game.Level;
import game.Game;

public class DestroyerShipList {
	
	// ______________________  Variables  ______________________
	
	private DestroyerAlien[] destroyers;
	private BombList bombList;
	private Game game;

	private final int points = 10;
	private final int damage = 1;

	
	// ______________________ Constructor ______________________ 
	
	public DestroyerShipList(Game game, Level level) {
		bombList = new BombList(game, level);
		this.game = game;
		
		int numAliens = level.getNumDestroyerAliens();
		int numAliRow = level.getNumDestroyerAliensPerRow();
		
		int strRow = level.getDestroyerStartingRow();
		int strCol = level.getDestroyerStartingCol();

		destroyers = new DestroyerAlien[numAliens];
		
		for (int i = 0; i < (numAliens/numAliRow); i++)
			for(int j = 0; j < numAliens; j++)
				destroyers[j+(i*numAliRow)] = new DestroyerAlien(game, strRow + i, strCol + j);
	}

	// ______________________   Methods   ______________________
	
	// ----------------------   Get Info  ----------------------
	
	// Find ship in location
	public boolean location(int x,int y) {
		boolean enc = false;
		for(int i=0;i<destroyers.length;i++) {
			if(destroyers[i].location(x,y)&& destroyers[i].isAlive()) {
				enc=true;
			}
		}
		return enc;
	}

	// Get skin
	public String toString(int x, int y) {
		String ship = "";
		int pos = 0;
		for(int i = 0; i < destroyers.length; i++) 
			if(destroyers[i].location(x, y)) 
				pos = i;
			
		if(destroyers[pos].isAlive())
			ship = "D[" + destroyers[pos].getLive() + "]";
		
		return ship;
	}
	
	// Reached world border
	public boolean reachLimit(int max, int min, boolean direction){
		boolean ok = false;
		int num;
		
		//!OK like while 
		if (direction)
			num = max;
		else
			num = min;
		
		for(int i = 0; i < destroyers.length && !ok; i++)   
			ok = destroyers[i].reachLimit(num);
			
		return ok;
	}
	
	// Reached bottom
	public boolean reachBottom(int NUMFIL) {
		boolean end = false;
		
		for (int i= 0; i < destroyers.length; i++)
			if (destroyers[i].getPosX() >= NUMFIL)
				end = true;
		return end;
	}

	
	// Get Counter
	public int getCounter() {
		return destroyers.length;
	}
	
	// Get Row
	public int getX(int i) {
		return destroyers[i].getPosX();
	}
	
	// Get Column
	public int getY(int i) {
		return destroyers[i].getPosY();
	}

	// Get Points
	public int getPoints() {
		return points;
	}
	
	// get damage
	public int getDamage() {
		return damage;
	}

	
	// ----------------------  Operations ----------------------
	
	// Advance ships
	public void advanceDestroyers() {
		
		for(int i=0;i<destroyers.length;i++) {
			destroyers[i].move();
		}
	}
	
	// Move down
	public void goDestroyersDown() {
		for(int i = 0; i < destroyers.length; i++) {
			destroyers[i].goDown();
		}
	}

	// take damage
		public int damage(int x, int y, int damage) {	
			int points = 0;
			boolean hit = false;
			
			for(int i = 0; !hit && i < destroyers.length; i++) {
				hit = (destroyers[i].getPosX() == x && destroyers[i].getPosY() == y);
				if (hit) {
					destroyers[i].damageObject(damage);
				
					if (!destroyers[i].isAlive()) {
						erraseShip(i);
						points += this.points;
					}
				}
			}
			return points;
		}
		
		// Erase ship
		private void erraseShip(int pos) {
			for (int i = destroyers.length -1; i > pos; i--)
				destroyers[i -1] = destroyers[i];
			
			destroyers = newList();
		}
		
		// Create smaller list
		private DestroyerAlien[] newList() {
			DestroyerAlien[] rShip = new DestroyerAlien[destroyers.length -1];
			
			for (int i = 0; i < rShip.length; i++)
				rShip[i] = destroyers[i];
			
			return rShip;
		}

	
	// _______________________ BombList ________________________
	
	// Bomb in x location
	public boolean bombLocation(int x, int y) {
		return bombList.location(x, y);
	}
	
	// Get skin
	public String bombSkin() {
		return bombList.toString();
	}

	// advance
	public void advanceBombs(int worldBorder){
		bombList.goDown(worldBorder);
	}
	
	// shoot
	public void shootBombs(Random rand) {
		for (int i = 0; i < destroyers.length; i ++)
			bombList.spawn(destroyers[i].getPosX(), destroyers[i].getPosY(), rand);
	}

	// Bomb destroyed
	public boolean bombDestroyed(int x, int y) {
		return bombList.impact(x, y);
	}
}