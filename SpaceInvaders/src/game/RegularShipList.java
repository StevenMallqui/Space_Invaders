package game;

public class RegularShipList {
	// ______________________  Variables  ______________________
	
	private RegularShip[] regulars;
	private final int points=10;

	
	// ______________________ Constructor ______________________ 
	
	public RegularShipList(Level level) {	
		int numAliens = level.getNumRegularAliens();
		int numAliRow = level.getNumRegularAliensPerRow();
		
		int strRow = level.getRegularStartingRow();
		int strCol = level.getRegularStartingCol();

		regulars = new RegularShip[numAliens];
		
		for (int i = 0; i < (numAliens/numAliRow); i++)
			for(int j = 0; j < numAliens; j++)
				regulars[j+(i*numAliRow)]
						= new RegularShip(strRow + i, strCol + j);
		
	}

	// ______________________   Methods   ______________________
	
	// ----------------------   Get Info  ----------------------
	
	// Find ship in location
	public boolean location(int x,int y) {
		boolean enc = false;
		for(int i = 0; i < regulars.length; i++) {
			if(regulars[i].location(x,y) && regulars[i].getResistance()!= 0) {
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
			
		if(regulars[pos].getResistance()> 0)
			ship = "D[" + regulars[pos].getResistance() + "]";
		
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
			if (regulars[i].getX() >= NUMFIL)
				end = true;
		return end;
	}

	
	// Get Counter
	public int getCounter() {
		return regulars.length;
	}
	
	// Get Row
	public int getX(int i) {
		return regulars[i].getX();
	}
	
	// Get Column
	public int getY(int i) {
		return regulars[i].getY();
	}

	// Get Points
	public int getPoints() {
		return points;
	}
	
	// ----------------------  Operations ----------------------
	
	// Advance ships
	public void advanceRegulars(boolean direction) {
		
		for (int i = 0; i < regulars.length; i++)
			regulars[i].move(direction);
	}
	
	// Move down
	public void goRegularsDown() {
		for(int i=0;i<regulars.length;i++) 
			regulars[i].moveDown();
	}

	// take damage
	public int damage(int x, int y, int damage) {	
		boolean hit = false;
		int points = 0;
		
		for(int i = 0; !hit && i < regulars.length; i++) {
			hit = (regulars[i].getX() == x && regulars[i].getY() == y);
			if (hit) {
				regulars[i].damage(damage);
			
				if (regulars[i].getResistance() == 0) {
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
	private RegularShip[] newList() {
		RegularShip[] rShip = new RegularShip[regulars.length -1];
		
		for (int i = 0; i < rShip.length; i++)
			rShip[i] = regulars[i];
		
		return rShip;
	}

}	
