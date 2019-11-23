package game;

public abstract class Ship extends GameObject {

	// ______________________ Constructor ______________________    

	public Ship(Game game, int x, int y, int live) {
		super(game, x, y, live);
		// TODO Auto-generated constructor stub
	}

	public void move(int spaces) {
		posX += spaces;
	}

}

/*
//Get Position X
public int getPosX() {
	return posX;
}

//Get Position Y
public int getPosY() {
	return posY;
}

//Is object alive
public boolean isAlive() {
	return this.live > 0;
}

//Get lives
public int getLive() {
	return this.live;
}

//is in current position
public boolean isOnPosition(int x, int y) {
	return (x == posX && y == posY);
}

//get object damage
public void getDamage (int damage) {
	this.live = damage >= this.live ? 0 : this.live - damage;
}

//is out of bounds
public boolean isOut() {
	return !game.isOnBoard(posX, posY);
}
*/