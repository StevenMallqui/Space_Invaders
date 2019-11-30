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
	
	// Get Reached bottom
	public boolean reachBottom(int min) {
		return (posX == min);
	}
	
	// all dead
	public static boolean allDead() {
		return false;
	}
	
	// have landed
	public static boolean haveLanded() {
		return false;
	}

	// move
	public void move() {
		if (game.getDirection()) {
			if (posY + 1 < game.DIM_Y)
				posY++;
			else {
				game.changeDirection();
				this.posX++;
			}
		}
		
		else {
			if (posY - 1 > 0)
				posY--;
			else {
				game.changeDirection();
				this.posX++;
			}
		}
	}
	
}
