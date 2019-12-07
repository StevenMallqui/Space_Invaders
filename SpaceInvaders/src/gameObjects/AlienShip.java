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
		checkBorders();
		
		if (game.getCycle() % game.getLevel().getNumCyclesToMoveOneCell() == 0) {
			
			if (game.getDirection()) 
				posY++;
			
			else 
				posY--;
			
		}
		
	}
	
	public void onDelete() {
		game.receivePoints(points);	
	}
	
	// Check Borders
	private void checkBorders() {		
		if (game.getDirection()) {
			if(Game.DIM_Y == posY) {
				game.changeDirection();
			}
		}
		
		
		else if (0 == posY) {
			game.changeDirection();
		}
		
	}
	
}
