package gameObjects;

import game.Game;

public class UCMShip extends Ship {
	
	private boolean shockwave = false;
	private boolean missile = false;
	
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
	
	// get active missile
	public boolean getMissile() {
		return missile;
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
		numSpacesMove = 0;
	}

	// set movement
	public void setMovement(int num) {
		numSpacesMove = num;
	}

	// enable shock wave
	public void enableShockWave() {
		// TODO Auto-generated method stub
		shockwave = true;
	}

	public void enableMissile() {
		// TODO Auto-generated method stub
		missile = true;
	}

}
