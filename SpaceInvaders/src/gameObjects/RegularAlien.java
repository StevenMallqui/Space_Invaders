package gameObjects;

import game.Game;

public class RegularAlien extends AlienShip {

	// ______________________ Variables   ______________________  

	// ______________________ Constructor ______________________    

	public RegularAlien(Game game, int x, int y) {
		super(game, x, y, 2, 5);
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
		return "R[" + lives + "]";
	}

}