package gameObjects;

import game.Game;

public class UCMSuperMissile extends Weapons {
	
	// ______________________ Constructor ______________________    

	public UCMSuperMissile(Game game, int x, int y) {
		super(game, x, y, 2);
	}

	// ______________________   Methods   ______________________

	// Computer Action -----------------------------------------
	public void computerAction() {
		// Not USed
	}

	// On delete -----------------------------------------------
	public void onDelete() {
		game.getUCMShip().setMissileActive(false);
	}
	
	// move
	public void move() {
		posX--;
		if (posX < 0)
			deactivate();
	}

	// skin
	public String toString() {
		return "oo";
	}

	public boolean receiveBombAttack(int damage) {
		damageObject(damage);
		return true;
	}

	@Override
	public void deactivate() {
		lives = 0;
		
	}

	@Override
	public String toStringified() {
		return "M;" + posX + "," + posY +"\n";
	}

	public boolean performAttack(GameObject other) {
		if (other.receiveMissileAttack(damage)) {
			deactivate();
			return true;
		}
		return false;
	}

}
