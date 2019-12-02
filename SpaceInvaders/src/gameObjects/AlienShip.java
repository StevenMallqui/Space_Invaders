package gameObjects;

import game.Game;

public abstract class AlienShip extends EnemyShip {

	// ______________________ Constructor ______________________    

	public AlienShip(Game game, int x, int y, int live, int points) {
		super(game, x, y, live, points);
		// TODO Auto-generated constructor stub
	}

	// ______________________   Methods   ______________________
	
	// Get Reached bottom
	public boolean reachBottom(int min) {
		return (posX == min);
	}
	
	// move
	public void move() {
		if (game.getDirection()) {
			if (Game.DIM_Y -1 == posY) 
				game.goADown();
						
			posY++;
		}
		
		else {
			if (0 == posY) 
				game.goADown();
			
			posY--;

		}
	}
	
	public void onDelete() {
		game.setPoints(this.points);		
	}
	
	public void computerAction() {
		posX++;
	}
	
}
