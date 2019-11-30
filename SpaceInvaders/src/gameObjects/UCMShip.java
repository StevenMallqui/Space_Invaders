package gameObjects;

import game.Game;

public class UCMShip extends Ship {
	
	private int numSpacesMove;
	private boolean shockwave = false;

	// ______________________ Constructor ______________________    

	public UCMShip(Game game, int x, int y) {
		super(game, y, x, 3);
	}

	// ______________________   Methods   ______________________
	
	// computer action -----------------------------------------
	public void computerAction() {
		
	}

	// on delete -----------------------------------------------
	public void onDelete() {
		
	}


	// get shock wave
	public boolean getShockwave() {
		return shockwave;
	}

	// enable shock wave
	public void enableShockWave() {
		
	}

	// get skin
	public String toString() {
		return "^__^";
	}

	// move ship
	public void move() {
		posY += numSpacesMove;
	}

	// set movement
	public void setMovement(int num) {
		numSpacesMove = num;
	}

}
