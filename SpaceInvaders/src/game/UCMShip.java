package game;

public class UCMShip {
	
	// ______________________ Variables   ______________________ 
	
	 private int life;
	 private int posX;
	 private int posY;
	 private String skin = "^__^";

	// ______________________ Constructor ______________________  
	 
	public UCMShip() {
		life = 3;
		posX = 7;
		posY = 4;
		}


	// ______________________   Methods   ______________________

	// ----------------------   Get Info  ----------------------

	// Get skin
	public String toString(){
		return skin;
	}
	
	// Is in x position
	public boolean location(int x, int y) {
		return (this.posX == x && this.posY == y);
	}
	
	// Get Column
	public int getY() {
		return posY;
	}
	
	// Get height
	public int getX() {
		return posX;
	}
	
	// Get life
	public int getLife() {
		return life;
	}


	// ----------------------   Set Info  ----------------------

	// set losing skin
	public void setSkin(String skin) {
		this.skin = skin;
	}

	// ----------------------  Operations ----------------------
	
	//MOVE UCMSHIP
	public void move(int spaces) {
		posY += spaces;
	}	
	
	// Take lives
	public void takeLife(int damage) {
			life -= damage;
	}
	
	
	
	
	
	
	
	
}
