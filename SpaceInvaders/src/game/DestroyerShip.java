package game;


public class DestroyerShip {
	
	// ______________________  Variables  ______________________
	
	private int resistance;
	private int posX;
	private int posY;

	// ______________________ Constructor ______________________    
	
	public DestroyerShip(int x,int y) {
		resistance = 1;
		posX=x;
		posY=y;
	}

	// ______________________   Methods   ______________________
	
	// ----------------------   Get Info  ----------------------
	
	// Get Lives
	public int getResistance() {
		return resistance;
	}

	// Get Active in location
	public boolean location(int x, int y) {
		return(posX == x && posY == y);
	}

	// Get Reached World Border
	public boolean reachLimit(int num) {
		return (posY == num);
	}
	
	// Get Reached bottom
	public boolean reachBottom(int min) {
		return (posX == min);
	}

	// Get Row
	public int getX() {
		return posX;
	}
	
	// Get Column
	public int getY() {
		return posY;
	}
	
	// ----------------------  Operations ----------------------

	// Move 
	public void move(boolean right) {
		if (right)
			posY++;
		else
			posY--;
	}
	
	// Move Down
	public void moveDown() {
		posX++;
	}
	
	// Take Resistance
	public int damage(int damage) {
		return resistance--;
	}
	
}

