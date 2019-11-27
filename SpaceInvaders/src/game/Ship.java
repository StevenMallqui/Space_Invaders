package game;

public abstract class Ship extends GameObject {

	// ______________________ Constructor ______________________    

	public Ship(Game game, int x, int y, int live) {
		super(game, x, y, live);
	}

	// move ship
	public void moveShip(int spaces) {
		this.posY += spaces;
	}

}
