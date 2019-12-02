package gameObjects;

import game.Game;

public abstract class EnemyShip extends Ship {

	
	// ______________________ Variables   ______________________  
	
	protected int points;

	// ______________________ Constructor ______________________    

	public EnemyShip(Game game, int x, int y, int live, int points) {
		super(game, x, y, live);
		// TODO Auto-generated constructor stub
	}

	// ______________________   Methods   ______________________
	/*
	public void move () {
		this.posY--;
	}
	
	public int getPoints() {
		return points;
	}*/
}
