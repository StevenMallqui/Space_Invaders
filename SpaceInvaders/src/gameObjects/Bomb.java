package gameObjects;

import game.*;

public class Bomb extends Weapons{
	
		private DestroyerAlien destroyer;
	// ______________________ Constructor ______________________    


	public Bomb(Game game, int x, int y,DestroyerAlien destroyer) {
		super(game, x, y,1);
		this.destroyer = destroyer;
	}

	// ______________________ METHODS _______________________
	
	//_______________________ abstract _____________________
	
	@Override
	public void onDelete() {
	}
	
	@Override
	public void computerAction() {
	}

	@Override
	public void deactivate() {
		lives = 0;
		destroyer.set(false);
	}

	//_______________________ move __________________________
	public void move() {
		posX++;
		if (Game.DIM_X == posX) {
			deactivate();
			destroyer.set(false);
		}
	}

	//________________________ get skin _________________________
	
	public String toString() {
		return "*";
	}

	//________________________ recieve missil attack ____________
	
	public boolean receiveMissileAttack(int damage) {
		damageObject(damage);
		return true;
	}

	@Override
	public String toStringified() {
		return "B;" + posX + "," + posY + "\n";
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