package gameObjects;

import game.Game;

public abstract class AlienShip extends EnemyShip {
	
	protected boolean goDown = false;
	protected int counter;
	
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
		
		if (goDown) {
			counter++;
			posX++;
		}
		
		else if (game.getCycle() % game.getLevel().getNumCyclesToMoveOneCell() == 0) {
			
			if (game.getDirection()) 
				posY++;
			
			else 
				posY--;
			
		}
	}
	
	public void onDelete() {
		game.receivePoints(points);	
	}
	
	private void checkBorders() {
		if (game.getDirection()) {
			if(Game.DIM_Y == posY) {
				game.changeDirection();
				goDown = true;
				counter = 0;
			}
		}
		
		else {
			if (0 == posY) {
				game.changeDirection();
				goDown = true;
				counter = 0;
			}
		}
		
		if (counter <= game.numEnemies())
			goDown = false;
	}
	
}
