package game;


public class UCMMissile extends Weapons {
	
	// ______________________ Constructor ______________________    

	public UCMMissile(Game game, int x, int y) {
		super(game, x, y, 1);
	}

	// ______________________   Methods   ______________________

	public void computerAction() {
		// Not USed
	}

	// On delete
	public void onDelete() {
		// No clue
		
	}

	// move
	public void move() {
		posY--;
	}

	// skin
	public String toString() {
		return "oo";
	}

	
}
/*
// Get Position X
public int getPosX() {
	return posX;
}

// Get Position Y
public int getPosY() {
	return posY;
}

// Is object alive
public boolean isAlive() {
	return this.live > 0;
}

// Get lives
public int getLive() {
	return this.live;
}

// is in current position
public boolean isOnPosition(int x, int y) {
	return (x == posX && y == posY);
}

// get object damage
public void getDamage (int damage) {
	this.live = damage >= this.live ? 0 : this.live - damage;
}

// is out of bounds
public boolean isOut() {
	return !game.isOnBoard(posX, posY);
}
*/