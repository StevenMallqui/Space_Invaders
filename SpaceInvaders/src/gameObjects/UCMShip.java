package gameObjects;

import game.Game;

public class UCMShip extends Ship {
	
	private boolean shockwave = false;
	
	private int numSpacesMove;

	// ______________________ Constructor ______________________    

	public UCMShip(Game game, int x, int y) {
		super(game, y, x, 3);
	}

	// ______________________   Methods   ______________________
	
	// computer action
	public void computerAction() {
		
	}

	// on delete
	public void onDelete() {
		
	}


	// get shock wave
	public boolean getShockwave() {
		return shockwave;
	}

	// enable shock wave
	public void setShockWave(boolean sk) {
		shockwave = sk;
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

	public void enableShockWave() {
		// TODO Auto-generated method stub
		
	}

	public void enableMissile() {
		// TODO Auto-generated method stub
		
	}

}
