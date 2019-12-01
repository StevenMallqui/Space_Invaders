package gameObjects;

import game.Game;

public abstract class AlienShip extends EnemyShip {

	// ______________________ Variables   ______________________  
	
	boolean direction = false;
	
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
			if (posY < Game.DIM_Y)
				posY++;
			
			else 
				game.changeDirection();
			
		}
		
		else {
			if (posY > 0)
				posY--;
			else 
				game.changeDirection();
			
		}
	}
	
	public void onDelete() {
		game.setPoints(this.points);		
	}
	// NearBorder
	
}
