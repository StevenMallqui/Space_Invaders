package gameObjects;

import game.Game;

public class UCMShip extends Ship {
	
	private boolean shockwave = false;
	private boolean missile = false;
	private String skin = "^__^";
	
	private int numSpacesMove;
	private int superMissile = 0;

	// ______________________ Constructor ______________________    

	public UCMShip(Game game, int x, int y) {
		super(game, y, x, 3);
	}

	// ______________________   Methods   ______________________
	
	// computer action
	public void computerAction() {
		
	}
	
	public boolean performAttack(GameObject other) {
		if (other != null)
			return missile;
		
		else
			return false;
	}

	// on delete
	public void onDelete() {
		game.endGame();
		skin = "!xx!";
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
		return skin;
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
		shockwave = true;
	}

	public void enableMissile() {
		missile = true;
	}
	
	public boolean receiveBombAttack(int damage) {
		if (lives > 0) {
			damageObject(damage);
			return true;
		}
		
		return false;
	}

	public int getNumSuperMissile() {
		return superMissile;
	}

	public void addSuperMissile() {
		superMissile++;
	}

	public void substractMissile() {
		superMissile--;
	}

	@Override
	public String toStringified() {
		return "P;" + posX + "," + posY + ";" + lives + ";" + game.getPoints() +
				";" + game.getShockWave() + ";" + superMissile +"\n";
	}

	public void setMissileActive(boolean actv) {
		missile = actv;
	}
	
	public boolean getActiveMissile() {
		return missile;
	}

}
