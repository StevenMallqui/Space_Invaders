package game;

public abstract class Ship extends GameObject {

	// ______________________ Variables   ______________________  

	// ______________________ Constructor ______________________    

	public Ship(Game game, int x, int y, int live) {
		super(game, x, y, live);
		// TODO Auto-generated constructor stub
	}

	// ______________________   Methods   ______________________

	// ----------------------   Get Info  ----------------------


	// ----------------------   Set Info  ----------------------


	// ----------------------  Operations ----------------------


	public abstract void computerAction();
	public abstract void onDelete();
	public abstract void move();
	public abstract String toString();

}
