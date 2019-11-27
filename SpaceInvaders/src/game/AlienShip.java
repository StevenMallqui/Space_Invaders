package game;

public abstract class AlienShip extends EnemyShip {

	// ______________________ Variables   ______________________  

	// ______________________ Constructor ______________________    

	public AlienShip(Game game, int x, int y, int live) {
		super(game, x, y, live);
		// TODO Auto-generated constructor stub
	}

	// ______________________   Methods   ______________________
	
	// Go down
	public void goDown() {
		this.posX--;
	}
}
