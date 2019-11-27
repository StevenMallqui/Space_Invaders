package game;

public abstract class Weapons extends GameObject {
	
	// ______________________ Variables   ______________________  

	protected int damage;
	
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
	
}
