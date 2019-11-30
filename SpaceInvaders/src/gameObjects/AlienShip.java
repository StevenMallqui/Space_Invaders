package gameObjects;

import game.Game;

public abstract class AlienShip extends EnemyShip {

	// ______________________ Variables   ______________________  
	
	boolean direction = false;
	
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
	
	// Get Reached bottom
	public boolean reachBottom(int min) {
		return (posX == min);
	}
	
	/*public static boolean allDead() {
		return (lives == 0);
	}
	
	public static boolean haveLanded() {
		return (game.DIM_X == posX);
	}*/

	// move
	public void move() {
		if (direction)
			posY++;
		else 
			posY--;
	}
	
	// Change direction
	public void changeDirection() {
		if (direction)
			direction = false;
		else
			direction = true;
	}
}
