package gameObjects;


import java.util.Random; 

public class BombList {
	
/*	// ______________________  Variables  ______________________
	
	private Level level;
	private Bomb []bomb;
	private String skin = ".";

	// ______________________ Constructor ______________________
	
	public BombList(Level level){
		this.level = level;
		
		bomb = new Bomb[level.getNumDestroyerAliens()];
		
		for(int i = 0; i < bomb.length; i++) {
			bomb[i] = new Bomb();
		}
	}

	
	// ______________________   Methods   ______________________
	
	// ----------------------   Get Info  ----------------------
	
	// Get Skin
	public String toString() {
		return skin;
	}
	
	// Get Number of Bombs
	public int getNumActiveBombs() {
		int num = 0;
		
		for (int i = 0; i < bomb.length; i++)
			if (bomb[i].getActiveBomb())
				num++;
			
		return num;
	}

	// Get Active in Location
	public boolean location(int x, int y) {
		boolean found = false;
		
		for (int i = 0; i < bomb.length && !found; i++)
			if ((bomb[i].getActiveBomb()) && (bomb[i].getX() == x && bomb[i].getY() == y)) 
				found = true;
			
		return found;
	}
	
	// ----------------------  Operations ----------------------
	
	// Spawn Bombs
	public void spawn(int X, int Y, Random rand) {
		boolean continueSearch = true;
		for (int i = 0; i < bomb.length && continueSearch; i++)
			if (!bomb[i].getActiveBomb()) {
				continueSearch = false;
				float frec = rand.nextFloat();
				
				if (frec < level.getShootFrequency()) 
					bomb[i].shootBomb(X, Y);
			}
	}
	
	
	// Advance Bombs
	public void goDown(int worldBorder) {
		for (int i = 0; i < bomb.length; i++) 
			if (bomb[i].getActiveBomb()) {
				bomb[i].moveDown();
			
				if(bomb[i].getX() >= worldBorder) 
					bomb[i].deactivateBomb();
			}	
	}
	
	// search if impacted
	public boolean impact(int x, int y) {
		boolean impacted = false;
		
		for(int i = 0; i < bomb.length && !impacted; i++)
			if( bomb[i].getActiveBomb() && bomb[i].getX() == x && bomb[i].getY() == y) {
				bomb[i].deactivateBomb();
				impacted = true;
			}
		return impacted;
	}
*/
	
}
	
	
	

