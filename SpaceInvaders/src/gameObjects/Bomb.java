package gameObjects;

import game.*;

public class Bomb extends Weapons{

	// ______________________ Constructor ______________________    

	public Bomb(Game game, int x, int y) {
		super(game, x, y, 1);
		// TODO Auto-generated constructor stub
	}

	// ______________________   Methods   ______________________

	// Computer action
	

	// On delete -----------------------------------------------
	public void onDelete() {
		
	}

	// move
	public void move() {
		posX++;
		if (Game.DIM_X == posX)
			deactivate();
	}

	// skin
	public String toString() {
		return "*";
	}


	public boolean receiveMissileAttack(int damage) {
		damageObject(damage);
		return true;
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
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