package gameObjects;

import game.Game;

public class DestroyerAlien extends AlienShip {

	// ______________________ Variables   ______________________  

	// ______________________ Constructor ______________________    

	public DestroyerAlien(Game game, int x, int y) {
		super(game, x, y, 1);
		// TODO Auto-generated constructor stub
	}

	// ______________________   Methods   ______________________

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}

	// Get skin
	public String toString() {
		return "D[" + lives + "]";
	}


}
