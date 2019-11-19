package game;


public class RegularShip {
	
	// ______________________  Variables  ______________________
	
	private int resistance;
	private int posX;
	private int posY;

	// ______________________ Constructor ______________________    
	
	public RegularShip(int x, int y) {
		posX = x;
		posY = y;
		resistance = 2;
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

	// Move Left
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
		return resistance -= damage;
	}
	
}

