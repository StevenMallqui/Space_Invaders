package gameObjects;

import game.Game;

public abstract class EnemyShip extends Ship {

	
	// ______________________ Variables   ______________________  

	// ______________________ Constructor ______________________    

	public EnemyShip(Game game, int x, int y, int live) {
		super(game, x, y, live);
		// TODO Auto-generated constructor stub
	}

	// ______________________   Methods   ______________________

	public void move () {
		this.posY--;
	}
}
