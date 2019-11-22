package game;


public class Bomb extends Weapons {

	// ______________________ Variables   ______________________  

	// ______________________ Constructor ______________________    

	public Bomb(Game game, int x, int y) {
		super(game, x, y, 1);
		// TODO Auto-generated constructor stub
	}

	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

	public void onDelete() {
		// TODO Auto-generated method stub
		
	}

	public void move() {
		posY++;
	}

	public String toString() {
		return "*";
	}

	// ______________________   Methods   ______________________

	// ----------------------   Get Info  ----------------------


	// ----------------------   Set Info  ----------------------


	// ----------------------  Operations ----------------------


	
}