package gameObjects;

import game.Game;
import game.IAttack;

public abstract class GameObject implements IAttack {
	
	// ______________________ Variables   ______________________  

	protected int posX;
	protected int posY;
	protected int lives;
	protected Game game;
	
	// ______________________ Constructor ______________________    

	public GameObject(Game game, int x, int y, int live) {
		posX = x;
		posY = y;
		this.game = game;
		this.lives = live;
	}

	// ______________________   Methods   ______________________

	// ----------------------  Abstract   ----------------------

	public abstract void computerAction();
	public abstract void onDelete();
	public abstract void move();
	public abstract String toString();

	// ----------------------   Get Info  ----------------------
	
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
		return this.lives > 0;
	}

	// Get lives
	public int getLive() {
		return this.lives;
	}
	
	// is in current position
	public boolean location(int x, int y) {
		return (x == posX && y == posY);
	}

	// take crash damage
	public void damageObject (int damage) {
		// damages object, and if is dealt more damage than
		// life it stays at 0 health
		this.lives = damage >= this.lives ? 0 : this.lives - damage;
	}
	
	// is out of bounds
	public boolean isOut() {
		return !game.isOnBoard(posX, posY);
	}
		
	// receive explosion attack
	public boolean receiveExplosionAttack(int damage) {
		damageObject(damage);
		return true;
	}

}
