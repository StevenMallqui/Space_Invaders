package gameObjects;

import game.Game;

public class UCMMissile extends Weapons {
	
	// ______________________ Constructor ______________________    

	public UCMMissile(Game game, int x, int y) {
		super(game, x, y);
	}

	// ______________________   Methods   ______________________

	// Computer Action -----------------------------------------
	public void computerAction() {
		// Not USed
	}

	// On delete -----------------------------------------------
	public void onDelete() {
		
	}

	// move
	public void move() {
		posX--;
		if (posX < 0)
			lives = 0;
	}

	// skin
	public String toString() {
		return "oo";
	}

	public boolean receiveBombAttack(int damage) {
		damageObject(damage);
		return true;
	}

}
