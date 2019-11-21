package game;

public class UCMShip extends Ship {
	

	// ______________________ Variables   ______________________ 
	
	 private int life;
	 private int posX;
	 private int posY;
	 private String skin = "^__^";

	// ______________________ Constructor ______________________  
	 
		public UCMShip(Game game, int x, int y, int live) {
			super(game, x, y, live);
			// TODO Auto-generated constructor stub
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
