package gameObjects;

import game.Game;

public abstract class Weapons extends GameObject {
	
	// ______________________ Variables   ______________________  

	protected int damage = 1;
	
	
	// ______________________ Constructor ______________________    

	public Weapons(Game game, int x, int y, int lives) {
		super(game, x, y, lives);
	}

	// ______________________   Methods   ______________________
		
	// get weapon damage
	public int getDamage() {
		return damage;
	}
	
	// deactivate
	public void deactivate() {
		lives = 0;
	}
}
