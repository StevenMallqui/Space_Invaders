package gameObjects;

import game.Game;

public abstract class EnemyShip extends Ship {

	
	// ______________________ Variables   ______________________  
	
	protected int points;
	
	// ______________________ Constructor ______________________    

	public EnemyShip(Game game, int x, int y, int live, int points) {
		super(game, x, y, live);
		this.points = points;
	}

	// ______________________   Methods   ______________________
	public void move () {
		this.posY--;
	}
		
	public boolean receiveMissileAttack(int damage) {
		if (lives > 0) {
			damageObject(damage);
			return true;
		}
		
		return false;
	}

	public boolean receiveShockWaveAttack(int damage) {
		if (lives > 0)
			damageObject(damage);
		return lives > 0;
	}

}
