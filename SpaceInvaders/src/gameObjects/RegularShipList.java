package gameObjects;

import game.Level;
import game.Game;

public class RegularShipList {
	
	// ______________________  Variables  ______________________
	
	private RegularAlien[] regulars;
	private Game game;
	private final int points = 10;

	
	// ______________________ Constructor ______________________ 
	
	public RegularShipList(Game game, Level level) {	
		int numAliens = level.getNumRegularAliens();
		int numAliRow = level.getNumRegularAliensPerRow();
		
		int strRow = level.getRegularStartingRow();
		int strCol = level.getRegularStartingCol();

		regulars = new RegularAlien[numAliens];
		
		for (int i = 0; i < (numAliens/numAliRow); i++)
			for(int j = 0; j < numAliens; j++)
				regulars[j+(i*numAliRow)]
						= new RegularAlien(game, strRow + i, strCol + j);
	}

	// ______________________   Methods   ______________________
	
	// ----------------------   Get Info  ----------------------
	
	// Find ship in location
	public boolean location(int x,int y) {
		boolean enc = false;
		for(int i = 0; i < regulars.length; i++) {
			if(regulars[i].location(x,y) && regulars[i].isAlive()) {
				enc = true;
			}
		}
		return enc;
	}

	// Get skin
	public String toString(int x, int y) {
		String ship = "";
		int pos = 0;
		for(int i = 0; i < regulars.length; i++) 
			if(regulars[i].location(x, y)) 
				pos = i;
			
		if(regulars[pos].isAlive());
		ship = "D[" + regulars[pos].getLive() + "]";
		
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
		
		for(int i = 0; i < regulars.length && !ok; i++)   
			ok = regulars[i].reachLimit(num);
			
		return ok;
	}
	
	// Reached bottom
	public boolean reachBottom(int NUMFIL) {
		boolean end = false;
		
		for (int i= 0; i < regulars.length; i++)
			if (regulars[i].getPosX() >= NUMFIL)
				end = true;
		return end;
	}

	
	// Get Counter
	public int getCounter() {
		return regulars.length;
	}
	
	// Get Row
	public int getX(int i) {
		return regulars[i].getPosX();
	}
	
	// Get Column
	public int getY(int i) {
		return regulars[i].getPosY();
	}

	// Get Points
	public int getPoints() {
		return points;
	}
	
	// ----------------------  Operations ----------------------
	
	// Advance ships
	public void advanceRegulars() {
		
		for (int i = 0; i < regulars.length; i++)
			regulars[i].move();
	}
	
	// Move down
	public void goRegularsDown() {
		for(int i=0;i<regulars.length;i++) 
			regulars[i].goDown();
	}

	// take damage
	public int damage(int x, int y, int damage) {	
		boolean hit = false;
		int points = 0;
		
		for(int i = 0; !hit && i < regulars.length; i++) {
			hit = (regulars[i].getPosX() == x && regulars[i].getPosY() == y);
			if (hit) {
				regulars[i].damageObject(damage);
			
				if (!regulars[i].isAlive()) {
					erraseShip(i);
					points += this.points;
				}
			}
		}
		return points;
	}
	
	// Erase ship
	private void erraseShip(int pos) {
		for (int i = regulars.length -1; i > pos; i--)
			regulars[i -1] = regulars[i];
		
		regulars = newList();
	}
	
	// Create smaller list
	private RegularAlien[] newList() {
		RegularAlien[] rShip = new RegularAlien[regulars.length -1];
		
		for (int i = 0; i < rShip.length; i++)
			rShip[i] = regulars[i];
		
		return rShip;
	}

}	
