package game;

public abstract class GameObject implements IAttack {
	
	// ______________________ Variables   ______________________  

	protected int posX;
	protected int posY;
	protected int live;
	protected Game game;

	// ______________________ Constructor ______________________    

	public GameObject( Game game, int x, int y, int live) {
		posX = x;
		posY = y;
		this.game = game;
		this.live = live;
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

}
