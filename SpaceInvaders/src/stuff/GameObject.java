package game;

public abstract class GameObject implements IAttack {
	protected int posX;
	protected int posY;
	protected int live;
	protected Game game;
	
	public GameObject( Game game, int x, int y, int live) {
		posX = x;
		posY = y;
		this.game = game;
		this.live = live;
	}
	
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}

	public boolean isAlive() {
		return this.live > 0;
	}

	public int getLive() {
		return this.live;
	}
	
	public boolean isOnPosition(int x, int y) {
		return (x == posX && y == posY);
	}

	public void getDamage (int damage) {
		this.live = damage >= this.live ? 0 : this.live - damage;
	}
	
	public boolean isOut() {
		return !game.isOnBoard(posX, posY);
	}

	public abstract void computerAction();
	public abstract void onDelete();
	public abstract void move();
	public abstract String toString();
}
