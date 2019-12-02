package gameObjects;

import game.Game;

public class DestroyerAlien extends AlienShip {

	// ______________________ Variables   ______________________  
	private boolean activeBomb;
	
	// ______________________ Constructor ______________________    

	public DestroyerAlien(Game game, int x, int y) {
		super(game, x, y, 1, 10);
	}

	// ______________________   Methods   ______________________

	// Get skin
	public String toString() {
		return "D[" + lives + "]";
	}


}
