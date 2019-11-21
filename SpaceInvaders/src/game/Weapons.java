package game;

public class Weapons extends GameObject {
	
	// ______________________ Variables   ______________________  

	protected int damage;
	
	// ______________________ Constructor ______________________    

	public Weapons(Game game, int x, int y, int live) {
		super(game, x, y, live);
	}

	// ______________________   Methods   ______________________

	// get weapon damage
	public int getDamage() {
		return damage;
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
}
