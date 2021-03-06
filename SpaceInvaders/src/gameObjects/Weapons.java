package gameObjects;

import game.Game;

public abstract class Weapons extends GameObject {
	
	// ______________________ Variables   ______________________  

	protected int damage = 1;
	
	// ______________________ Constructor ______________________    

	public Weapons(Game game, int x, int y, int damage) {
		super(game, x, y, 1);
		this.damage = damage;
	}

	// ______________________   Methods   ______________________
		
	// get weapon damage
		public int getDamage() {
			return damage;
		}
		
		public int getLive() {
			return lives;
		}
	//_____________________Abstract Method_______________

	public abstract void deactivate();

	
	
}
