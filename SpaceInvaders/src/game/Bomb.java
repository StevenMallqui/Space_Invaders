package game;


public class Bomb extends Weapons {

	// ______________________ Variables  ______________________  
	
	// ______________________ Constructor ______________________    
	
	// Create Bomb
	public Bomb(Game game, int x, int y, int lives) {
		super(game, x, y, lives);
		
		posX = x;
		posY = y;
		live = lives;
	}
	
	// ______________________   Methods   ______________________
	
	// ----------------------   Get Info  ----------------------
	
	// Get Active bomb
	
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

	// ----------------------  Operations ----------------------
		
	// Advance Bomb
	public void moveDown() {
		posX++;
	}
	
	// Shoot Bomb
}