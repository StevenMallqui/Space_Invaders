package game;


public class Ovni {
		
	// ______________________ Variables   ______________________  
	
	private int posX;
	private int posY;
	private int lives;
	private boolean active;
	private final int points = 25;

	// ______________________ Constructor ______________________    

	public Ovni() {
		active = false;
	}

	// ______________________   Methods   ______________________

	// ----------------------   Get Info  ----------------------

	// is in x position
	public boolean location(int x, int y){
		return(posX == x && posY == y);
	}
		
	// get skin
	public String toString() {
		return "O[" + lives + "]";
	}
	
	// get active
	public boolean getActive() {
		return active;
	}
	
	// get points
	public int getPoints() {
		return points;
	}

	// ----------------------   Set Info  ----------------------
	
	// send ufo
	public void starting() {
		posX = 0;
		posY = 8;
		lives = 1;
		active = true;
	}

	// ----------------------  Operations ----------------------
	
	// move
	public void moverY(int min) {
		posY--;
		
		if(posY < min)
			active = false;
	}
	
	// take lives
	public int damage(int x, int y, int damage) {
		int p = 0;
		if (location(x, y)) {
			lives -= damage;
			
			if (lives <= 0) {
				active = false;
				p += points;
			}
		}
		return p;
	}
	
	
	
	
	
	
}
