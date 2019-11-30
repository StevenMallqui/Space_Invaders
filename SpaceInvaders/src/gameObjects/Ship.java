package gameObjects;

import game.Game;

public abstract class Ship extends GameObject {

	// ______________________ Constructor ______________________    

	public Ship(Game game, int x, int y, int live) {
		super(game, x, y, live);
	}

	// ______________________   Methods   ______________________

	// Get Reached World Border
	public boolean reachLimit(int num) {
		return (posY == num);
	}

}
