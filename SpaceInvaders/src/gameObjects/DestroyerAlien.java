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

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

	// Get skin
	public String toString() {
		return "D[" + lives + "]";
	}


}
