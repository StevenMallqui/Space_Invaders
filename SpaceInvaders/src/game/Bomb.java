package game;


public class Bomb {

	// ______________________ Variables  ______________________  
	
	private int posX;
	private int posY;
	private boolean activeBomb;
	
	// ______________________ Constructor ______________________    
	
	// Create Bomb
	public Bomb() {
		activeBomb = false;
	}
	
	// ______________________   Methods   ______________________
	
	// ----------------------   Get Info  ----------------------
	
	// Get Active bomb
	public boolean getActiveBomb() {
		return activeBomb;
	}
	
	// Get Row
	public int getX() {
		return posX;
	}
	
	// Get Column
	public int getY() {
		return posY;
	}

	// ----------------------   Set Info  ----------------------
	
	// Set Row
	public void setX(int x) {
		posX= x;
	}
	
	// Set Column
	public void setY(int y) {
		posY = y;
	}
	
	// Deactivate bomb
	public void deactivateBomb() {
		activeBomb = false;
	}

	// ----------------------  Operations ----------------------
		
	// Advance Bomb
	public void moveDown() {
		posX++;
	}
	
	// Shoot Bomb
	public void shootBomb(int X, int Y) {
		activeBomb = true;
		posX = X;
		posY = Y;
	}
	
}